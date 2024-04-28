package tn.enis.fumeurs;

public class Fumeur2 extends Thread {
	String tabac = "tabac";

	@Override
	public void run() {
		try {
			Principale.AP.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fumer();
		Principale.c.release();
	}

	public void fumer() {
		System.out.println("Fumeur T: je fume trop");
	}
}
