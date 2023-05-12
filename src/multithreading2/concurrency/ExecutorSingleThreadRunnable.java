package multithreading2.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorSingleThreadRunnable {

	public static void main(String[] args) throws Exception {
		ExecutorService executor = null;
		try {
			executor = Executors.newSingleThreadExecutor(); // Creates an executor with only one thread
			executor.execute(new Tarefa()); // You can execute twice the same executor
			executor.awaitTermination(5, TimeUnit.SECONDS); // Awaits the termination of the executor
		} catch (Exception e) {
			throw e;
		} finally {
			if (executor != null) {
				executor.shutdown(); // It is obligatory to end the execution after creation of an executor

			}
		}
	}

	public static class Tarefa implements Runnable {
		@Override
		public void run() {
			String tName = Thread.currentThread().getName();
			System.out.println(tName + ": " + "My task");
		}
	}

}
