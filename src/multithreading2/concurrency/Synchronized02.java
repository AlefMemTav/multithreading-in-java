package multithreading2.concurrency;

public class Synchronized02 {

	private static int i = 0;

	public static class Thread02Runnable implements Runnable {

		@Override
		public void run() {

			int j = 0;

			synchronized (this) { // Isolated the use of synchronized just to the local that exists concurrency.
				i++;
				j = i * 2;
			}

			double jToThePowerOf100 = Math.pow(j, 100);
			double sqrt = Math.sqrt(jToThePowerOf100);
			String tName = Thread.currentThread().getName();
			System.out.println("Sqrt" + "(" + j + "^100" + ")" + tName + ": " + sqrt);
		}
	}

	public static void main(String[] args) {
		Thread02Runnable runnable = new Thread02Runnable();

		Thread t0 = new Thread(runnable);
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		Thread t4 = new Thread(runnable);

		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
