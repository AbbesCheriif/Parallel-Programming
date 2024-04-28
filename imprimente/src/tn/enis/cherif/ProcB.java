package tn.enis.cherif;

public class ProcB extends Thread {
	Moniteur m;

	ProcB(Moniteur m, String name) {
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
		m.utiliser("B");
		m.liberer();
	}

}
