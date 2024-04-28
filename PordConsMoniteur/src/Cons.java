
public class Cons extends Thread {

	Moniteur m;

	Cons(Moniteur m) {
		this.m = m;
	}

	@Override
	public void run() {
		try {
			m.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
