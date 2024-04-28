
public class Lecteur extends Thread {
	Moniteur m;

	Lecteur(Moniteur m, String nom) {
		super(nom);
		this.m = m;
	}

	public void run() {

		try {
			m.debutLecture();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.lire();
		m.finLecture();
	}

}
