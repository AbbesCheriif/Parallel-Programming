
public class Redacteur extends Thread {
	Moniteur m;

	Redacteur(Moniteur m, String nom) {
		super(nom);
		this.m = m;
	}

	public void run() {

		try {
			m.debutEcriture();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.ecrire();
		m.finEcriture();
	}

}
