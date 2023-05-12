package multithreading2.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedList {

	private static List<String> list = new ArrayList<>(); // Not synchronized

	public static void main(String[] args) throws InterruptedException {

		list = Collections.synchronizedList(list); // Synchronized
		
		MyRunnable runnable = new MyRunnable();

		Thread t0 = new Thread(runnable);
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		t0.start();
		t1.start();
		t2.start();
		Thread.sleep(500);
		System.out.println(list);
	}

	public static class MyRunnable implements Runnable {
		@Override
		public void run() {
			list.add("Hello World!");
			String tName = Thread.currentThread().getName();
			System.out.println(tName + " added to the list");
		}
	}
}
