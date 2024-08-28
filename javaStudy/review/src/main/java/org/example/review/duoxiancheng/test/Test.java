package org.example.review.duoxiancheng.test;

public class Test {
    public static void main(String[] args) {
        new Thread(new MyThread(10), "倒计时1").start();
        new Thread(new MyThread(10), "倒计时2").start();
        new Thread(new MyThread(10), "倒计时3").start();

    }
}
