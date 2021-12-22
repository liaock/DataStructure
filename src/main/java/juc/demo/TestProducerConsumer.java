package juc.demo;


import java.util.LinkedList;

/**
 * 1个生产，1个线程消费，，
 * 生产队列最大 10 个元素.
 * Created by dell on 2021/12/22.
 */
public class TestProducerConsumer<T> {
    private final LinkedList<T> lists = new LinkedList<T>();
    private final int MAX = 10;  // 最多10个元素.
    private int count = 0;

    public synchronized void put(T t){
        while(lists.size() == MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++ count;
        this.notifyAll();  // 通知消费者消费
    }

    public synchronized T get(){
        while (lists.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = lists.removeFirst();
        count --;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        TestProducerConsumer testProducerConsumer = new TestProducerConsumer();
        //启动消费线程
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println("消费元素：" + testProducerConsumer.get());
            }).start();
        }

        //启动生产线程
        for (int i = 0; i < 100; i++) {
            final int k = i;
            new Thread(()->{
                System.out.println("生产元素:"+k);
                testProducerConsumer.put( k);
            }).start();
        }
    }
}
