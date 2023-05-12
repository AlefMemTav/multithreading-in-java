package multithreading2.concurrency;

public class Volatile01 {

	private static int num = 0;
	private static boolean finished = false;

	private static class MeuRunnable implements Runnable {
		@Override
		public void run() {
			while (!finished) {
				Thread.yield(); // Don't have job
			}

			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		Thread t0 = new Thread(new MeuRunnable());
		t0.start();
		num = 42;
		finished = true;
	}

}
