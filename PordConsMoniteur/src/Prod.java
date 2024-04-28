
public class Prod extends Thread {
	Moniteur m;

	Prod(Moniteur m) {
		this.m = m;
	}

	@Override
	public void run() {
		try {
			m.append();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
