package multithreading2.threads;

public class Thread01 {

    public static void main(String[] args) {
        // To know the current thread
        Thread t = Thread.currentThread();
        System.out.println(t.getName()); // output: main

        // To create a new thread with runnable interface
        Thread01Runnable runnable = new Thread01Runnable();
        Thread t0 = new Thread(runnable);
        //t1.run(); // It will execute the thread t1 on the same thread t, without creating a new thread
        t0.start(); // To create a new thread you must use the method start (and not use run method)
        
        // To create a new thread with runnable using lambda function
        Thread t1 = new Thread(() -> System.out.println(Thread.currentThread().getName())); // output: Thread-1
        t1.start();
        //t1.start(); // DO NOT DO IT! Never try execute the same thread twice
        
        Thread t2 = new Thread(new Thread01Runnable()); // You can not execute the same thread twice, but you can execute the same runnable twice, incluse the same instance
        t2.start();
    }
}
