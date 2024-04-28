package tn.enis.cherif;

public class Redacteur extends Thread {
	Moniteur m;

	Redacteur(Moniteur m, String nom) {
		super(nom);
		this.m = m;
	}

	@Override
	public void run() {
		try {
			m.debecrire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.ecrire();
		m.finecrire();
	}
}
