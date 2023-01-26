package multithreading.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueue01 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
        blockingQueue.put("William");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), blockingQueue.peek());
        System.out.println("Trying to add another value");
        new Thread(new RemoveFromQueue(blockingQueue)).start();
        blockingQueue.put("Suane");
        System.out.printf("%s added the value %s%n", Thread.currentThread().getName(), blockingQueue.peek());
    }

    static class RemoveFromQueue implements Runnable {

        private final BlockingQueue<String> blockingQueue;

        public RemoveFromQueue(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            System.out.printf("%s going to sleep for 5s %n", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.printf("%s removing value from queue %s%n", Thread.currentThread().getName(), blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
