
public class Processus extends Thread {
	Moniteur m;
	int amount;

	Processus(Moniteur m, int amount) {
		this.m = m;
		this.amount = amount;
	}

	@Override
	public void run() {
		// request
		try {
			m.request(amount);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.acces_Memoire();
		// release
		m.release(amount);

	}
}
