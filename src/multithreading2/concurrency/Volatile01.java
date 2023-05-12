package multithreading2.concurrency;

public class Volatile01 {

	private static int num = 0;
	private static boolean finished = false;

	private static class MeuRunnable implements Runnable {
		@Override
		public void run() {
			while (!finished) {
				Thread.yield(); // Don't have job
				System.out.println("Sorry, i'm lazy...");
			}
			System.out.println("I'm a worker!");
			System.out.println(num); // Thread have a job
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t0 = new Thread(new MeuRunnable());
		t0.start();
		Thread.sleep(1); // To see the thread without any job
		num = 42;
		finished = true;
	}

}
