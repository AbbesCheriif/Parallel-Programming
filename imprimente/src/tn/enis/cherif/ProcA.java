package tn.enis.cherif;

public class ProcA extends Thread {
	Moniteur m;

	ProcA(Moniteur m, String name) {
		super(name);
		this.m = m;
	}

	@Override
	public void run() {
		try {
			m.allouer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.utiliser("A");
		m.liberer();
	}
}
