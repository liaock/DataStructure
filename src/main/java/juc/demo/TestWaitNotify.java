package juc.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器，提供两个方法，add, size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素个数，当个数到5个时，线程2给出提示并结束
 * Created by dell on 2021/12/22.
 */
public class TestWaitNotify {

    List lists = new ArrayList();
    public void add(Object o){lists.add(o);}
    public int size(){return lists.size();}

    public static void main(String[] args) {
        TestWaitNotify testWaitNotify = new TestWaitNotify();
        final Object lock = new Object();
        Thread t1 = new Thread(()->{
            System.out.println("t1启动");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    testWaitNotify.add(i);
                    System.out.println("add " + i);
                    if (testWaitNotify.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(()-> {
            synchronized (lock){
                System.out.println("t2启动");
                if(testWaitNotify.size() != 5){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 执行结束");
                lock.notify();
            }
        });
        t2.start();
        t1.start();

    }
}
