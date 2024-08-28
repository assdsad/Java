package org.example.review.duoxiancheng;

public class ThreadTest {
    public static void main(String[] args) {
        new Thread(new SyncThread()).start();
//        Thread thread = new MyThread();
//        thread.start();

//        MyRunnable run = new MyRunnable();
//        new Thread(run).start();
//        System.out.println("运行结束");

//        Thread thread = new MyThread();
//        thread.start();
//        System.out.println("运行结束");
//        当前线程名为：main
//                运行结束
//        当前线程名为：Thread-0
    }
}
