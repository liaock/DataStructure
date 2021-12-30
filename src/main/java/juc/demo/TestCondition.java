package juc.demo;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者问题，用Condtion实现
 * Created by dell on 2021/12/22.
 */
public class TestCondition<T> {
    private final LinkedList<T> lists = new LinkedList<T>();
    private final int MAX = 10;  // 最多10个元素.
    private int count = 0;

    Lock lock = new ReentrantLock();
    Condition consumer = lock.newCondition();
    Condition producer = lock.newCondition();

    public void put(T t){
        lock.lock();
        try {
            while(lists.size() == MAX){
                try {
                    producer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lists.add(t);
            ++ count;
            consumer.signalAll();  // 通知消费者消费
        } finally {
            lock.unlock();
        }
    }

    public T get(){
        T t;
        try {
            lock.lock();
            while (lists.size()==0){
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            t = lists.removeFirst();
            count --;
            producer.signalAll();
        } finally {
            lock.unlock();
        }
        return t;
    }


    public static void main(String[] args) {
        TestCondition testCondition = new TestCondition();
        //启动消费线程
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println("消费元素：" + testCondition.get());
            }).start();
        }

        //启动生产线程
        for (int i = 0; i < 100; i++) {
            final int k = i;
            new Thread(()->{
                System.out.println("生产元素:"+k);
                testCondition.put( k);
            }).start();
        }
    }

}
