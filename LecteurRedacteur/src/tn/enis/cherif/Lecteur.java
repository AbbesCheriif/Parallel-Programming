package tn.enis.cherif;

public class Lecteur extends Thread {
	Moniteur m;

	Lecteur(Moniteur m, String nom) {
		super(nom);
		this.m = m;
	}

	@Override
	public void run() {
		try {
			m.deblire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.lire();
		m.finlire();
	}
}
