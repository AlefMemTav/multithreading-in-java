package multithreading.threads;

public class Thread01Runnable {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadExampleRunnable('A'));
        Thread t2 = new Thread(new ThreadExampleRunnable('B'));
        Thread t3 = new Thread(new ThreadExampleRunnable('C'));
        Thread t4 = new Thread(new ThreadExampleRunnable('D'));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
