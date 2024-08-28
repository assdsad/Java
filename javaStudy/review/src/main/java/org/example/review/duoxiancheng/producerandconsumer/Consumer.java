package org.example.review.duoxiancheng.producerandconsumer;

public class Consumer implements Runnable{
    SyncStack theStack;
    public Consumer(SyncStack s) {
        theStack = s;
    }
    @Override

    public void run() {
        char c;
        for(int i = 0; i < 20; i++) {
            c = theStack.pop();
            System.out.println("Consumed: " + c);

            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
