package org.example.review.duoxiancheng;

public class MyThread extends Thread{
    public MyThread(){
        super();
        System.out.println("当前线程名为：" + Thread.currentThread().getName());
    }
    @Override
    public void run() {
        for(int i = 1; i <= 10; i ++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
                System.out.println("线程睡眠1s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
