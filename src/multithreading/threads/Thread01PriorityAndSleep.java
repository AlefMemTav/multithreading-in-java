package multithreading.threads;

class ThreadExampleRunnable implements Runnable {

    private final char c;

    public ThreadExampleRunnable(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0) {
                System.out.println();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Thread01PriorityAndSleep {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadExampleRunnable('A'), "T1A");
        Thread t2 = new Thread(new ThreadExampleRunnable('B'), "T1B");
        Thread t3 = new Thread(new ThreadExampleRunnable('C'), "T1C");
        Thread t4 = new Thread(new ThreadExampleRunnable('D'), "T1D");
        t4.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("############################# Dead " + Thread.currentThread().getName());
    }
}
