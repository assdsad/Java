package org.example.review.duoxiancheng.producerandconsumer;

public class SyncTest {
    public static void main(String[] args) {
        SyncStack stack = new SyncStack();
        new Thread(new Producer(stack)).start();;
        new Thread(new Consumer(stack)).start();
    }
}
