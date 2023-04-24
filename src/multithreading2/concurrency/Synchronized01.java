package multithreading2.concurrency;

public class Synchronized01 {

    static int i = -1; // The element to be processed concurrently in the multithreads

    public static class Thread02Runnable implements Runnable {

        @Override
        public synchronized void run() { // With the synchronized, only one thread can execute the run method at a time, within the same Runnable instance
            i++; //With synchronized the concurrency issue to the variable i is eliminated           
            String tName = Thread.currentThread().getName();
            System.out.println(tName + ": " + i);
        }

        /*
        @Override
        public void run() { // Note: Just one run method is permited
            synchronized (this) { // You can too use the keyword synchronized in a block of code inside the run method
                i++;
                String tName = Thread.currentThread().getName();
                System.out.println(tName + ": " + i);
            }
        }
         */
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
