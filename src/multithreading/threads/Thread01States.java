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
        }
    }
}

public class Thread01States {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadExampleRunnable('A'));
        Thread t2 = new Thread(new ThreadExampleRunnable('B'));
        Thread t3 = new Thread(new ThreadExampleRunnable('C'));
        Thread t4 = new Thread(new ThreadExampleRunnable('D'));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("############################# Dead " + Thread.currentThread().getName());
    }
}
