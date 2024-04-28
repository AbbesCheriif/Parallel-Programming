package tn.enis.fumeurs;

public class Fumeur3 extends Thread {
	String allumette = "allumette";

	@Override
	public void run() {
		try {
			Principale.TP.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fumer();
		Principale.c.release();
	}

	public void fumer() {
		System.out.println("Fumeur A: je fume trop");
	}
}
