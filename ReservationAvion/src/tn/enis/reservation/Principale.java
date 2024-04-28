package tn.enis.reservation;

public class Principale {
	// variable partagé
	static int nbplace = 1;

	public static void main(String[] args) {
		Client c1 = new Client();
		Client c2 = new Client();
		c1.start();
		c2.start();
		try {
			c1.join();
			c2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(nbplace);
	}
}
