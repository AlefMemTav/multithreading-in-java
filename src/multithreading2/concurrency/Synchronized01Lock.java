package multithreading2.concurrency;

public class Synchronized01Lock {

    static int i = -1;

    public static class Thread02Runnable implements Runnable {

        static Object lock1 = new Object(); // A object that locks the synchrony.
        static Object lock2 = new Object();

        @Override
        public void run() {
            synchronized (lock1) { // When using a synchronized block, you need to specify which object should be used for the synchronization
                i++;
                String tName = Thread.currentThread().getName();
                System.out.println("BlockOne" + tName + ": " + i);
            }

            synchronized (lock2) { 
                i++;
                String tName = Thread.currentThread().getName();
                System.out.println("BlockTwo" + tName + ": " + i);
            }
        }
    }

    public static void main(String[] args) {

        Thread02Runnable runnable = new Thread02Runnable();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
