package multithreading.concurrency;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueue01 {

    public static void main(String[] args) throws InterruptedException {
//        ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue
        TransferQueue<Object> transferQueue = new LinkedTransferQueue<>();
        System.out.println(transferQueue.add("william"));
        System.out.println(transferQueue.offer("william"));
        System.out.println(transferQueue.offer("william", 10, TimeUnit.SECONDS));
        transferQueue.put("DevDojo");
        if (transferQueue.hasWaitingConsumer()) {
            transferQueue.transfer("Devojo");
        }
        System.out.println(transferQueue.tryTransfer("Academy"));
        System.out.println(transferQueue.tryTransfer("Academy", 5, TimeUnit.SECONDS));
        System.out.println(transferQueue.element());
        System.out.println(transferQueue.peek());
        System.out.println(transferQueue.poll());
        System.out.println(transferQueue.remove());
        System.out.println(transferQueue.take());
        System.out.println(transferQueue.remainingCapacity());
    }
}
