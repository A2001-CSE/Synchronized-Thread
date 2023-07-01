public class Consumer implements Runnable {
	Stock s;
	Thread t;

	public Consumer(Stock s) {
		this.s = s;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
			s.getGoods((int) (Math.random() * 1000));
		}
	}

	@Deprecated
	void kill() {
		t.stop();
		t = null;
	}
}