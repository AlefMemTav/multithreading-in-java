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
