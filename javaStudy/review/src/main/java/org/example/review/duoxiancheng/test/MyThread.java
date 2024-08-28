package org.example.review.duoxiancheng.test;

public class MyThread implements Runnable{
    private int seconds;
    public MyThread(int seconds) {
        this.seconds = seconds;
    }
    @Override
    public void run() {
        for(int i = seconds; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "还剩：" + i + "s");
        }
    }
}
