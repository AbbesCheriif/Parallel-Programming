package tn.enis.fumeurs;

public class Fumeur1 extends Thread {
	String papier = "papier";

	@Override
	public void run() {
		try {
			Principale.AT.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fumer();
		Principale.c.release();
	}

	public void fumer() {
		System.out.println("Fumeur P: je fume trop");
	}
}
