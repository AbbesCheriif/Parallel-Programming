package tn.enis.prodCons;

public class Producteur extends Thread { // (2)
	static int i = 0;

	@Override
	public void run() {
		//vérifier si le nb de place vide est sup à 0
		try {
			Principale.nbvide.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//assurer l'exclusion mutuelle
		try {
			Principale.s.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//section critique
		append();
		//assurer l'exclusion mutuelle
		Principale.s.release();
		//incrémenter le nb de place plein
		Principale.nbplein.release();
	}

	public void append() {
		int x = (int) (Math.random() * 100);
		Principale.tab[i] = x;
		System.out.println("le prod produit: " + x);
		i = (i + 1) % Principale.n;
	}
}
