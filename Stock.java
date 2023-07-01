public class Stock {
	public int goods = 0;

	public synchronized void addGoods(int i) {
		goods += i;
		System.out.println("Added goods are :" + i);
		System.out.println("Total goods are :" + goods);
		notify();
	}

	public synchronized int getGoods(int i) {
		while (true) {
			if (goods >= i) {
				goods -= i;
				System.out.println("Deducted goods are :" + i);
				System.out.println("Total goods are :" + goods);
				break;
			} else {
				System.out.println("insuffient goods");
				try {
					wait();
				} catch (Exception ee) {
				}
			}
		}
		return goods;
	}

	public static void main(String args[]) {
		Stock ss = new Stock();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		try {
			Thread.sleep(1000);
		} catch (Exception ee) {
		}
		p.kill();
		c.kill();
	}
}