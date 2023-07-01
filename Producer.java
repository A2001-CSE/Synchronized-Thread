public class Producer implements Runnable {
	Stock s;
	Thread t;

	public Producer(Stock s) {
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
			s.addGoods((int) (Math.random() * 1000));
		}
	}

	@Deprecated
	void kill() {
		t.stop();
		t = null;
	}
}