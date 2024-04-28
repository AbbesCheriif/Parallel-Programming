package tn.enis.prodCons;

public class Consommateur extends Thread { // (2)
	static int i = 0;

	@Override
	public void run() {
		// verifier si le nb de place pleine est sup à 0
		try {
			Principale.nbplein.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// assurer l'exclusion mutuelle
		try {
			Principale.s.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// section critique
		take();
		// assurer l'exclusion mutuelle
		Principale.s.release();
		// incrémenter le nb de place vide
		Principale.nbvide.release();
	}

	public void take() {
		int x = Principale.tab[i];
		System.out.println("le cons consomme: " + x);
		i = (i + 1) % Principale.n;
	}
}
