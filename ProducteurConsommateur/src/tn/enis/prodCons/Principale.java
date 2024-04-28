package tn.enis.prodCons;

import java.util.concurrent.Semaphore;

public class Principale {
	static int n = 10;
	// variable partagé (1)
	static int[] tab = new int[n];
	static Semaphore s = new Semaphore(1);
	static Semaphore nbvide = new Semaphore(n);
	static Semaphore nbplein = new Semaphore(0);

	public static void main(String[] args) {
		Producteur prod1 = new Producteur();
		Producteur prod2 = new Producteur();
		Producteur prod3 = new Producteur();
		Consommateur cons1 = new Consommateur();
		Consommateur cons2 = new Consommateur();
		Consommateur cons3 = new Consommateur();
		cons1.start();
		cons2.start();
		cons3.start();
		prod1.start();
		prod2.start();
		prod3.start();
	}
}
// 1) ex mutuelle entre prod et cons sur le tampon
// 2) prod ne peut pas produie dans un tampon plein
// 3)cons ne peut pas consommer depuis un tampon vide
