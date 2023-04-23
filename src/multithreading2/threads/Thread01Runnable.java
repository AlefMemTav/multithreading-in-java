package multithreading2.threads;

public class Thread01Runnable implements Runnable {

    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        System.out.println(tName);
    }
}
