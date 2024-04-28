package tn.enis.fusion;

public class Trieur extends Thread {
	private int debut;
	private int fin;
	Trieur(int debut, int fin) {
	 this.debut = debut;
	 this.fin = fin;
	}

	public void run() {
		for (int i = debut; i < fin; i++) {
			for (int j = i+1; j < fin ; j++) {
				if (Principale.tab[i] > Principale.tab[j]) {
					// Échange les éléments si nécessaire
					int aux = Principale.tab[i];
					Principale.tab[i] = Principale.tab[j];
					Principale.tab[j] = aux;
				}
			}
		}
	}
}
