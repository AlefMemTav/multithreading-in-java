package multithreading2.concurrency;

import java.lang.Thread.State;

public class Volatile02 {

	// private static int num = 0; // BAD
	// private static boolean finished = false; // BAD
	private static volatile int num = 0;
	private static volatile boolean finished = false;

	private static class MeuRunnable implements Runnable {

		@Override
		public void run() {
			while (!finished) {
				Thread.yield();
			}

			if (num != 42) {
				System.out.println(num);
				throw new IllegalStateException("The number must be 42.");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			Thread t0 = new Thread(new MeuRunnable());
			t0.start();
			Thread t1 = new Thread(new MeuRunnable());
			t1.start();
			Thread t2 = new Thread(new MeuRunnable());
			t2.start();

			num = 42;
			finished = true;

			while (t0.getState() != State.TERMINATED || t1.getState() != State.TERMINATED
					|| t2.getState() != State.TERMINATED) {
				// waiting all threads finish
			}

			// Reset the values
			num = 0;
			finished = false;
		}
	}
}
