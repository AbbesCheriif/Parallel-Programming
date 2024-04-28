package tn.enis.cherif;

public class Nageur extends Thread {
	Nageur(String name) {
		super(name);
	}

	@Override
	public void run() {
		// deshabiller()
		deshabiller();
		// nager()
		nager();
		// rehabiller()
		rehabiller();
	}

	private void deshabiller() {
		// verifier s'il y a une cabine disponible
		try {
			Principale.cabines.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// verifier s'il y a un panier disponible
		try {
			Principale.paniers.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + ": je vais nager");
		// libérer la cabine avant de nager
		Principale.cabines.release();
		// on ne libère pas le panier ici car le naqgeur libère le panier après qu'il se
		// rehabille
	}

	private void nager() {
		System.out.println(Thread.currentThread().getName() + ": je nage dans la piscine");
	}

	private void rehabiller() {
		// verifier s'il y a une cabine disponible
		try {
			Principale.cabines.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + ": je vais quitter");
		// libérer la cabine avant de quitter
		Principale.cabines.release();
		// libérer le panier avant de quitter
		Principale.paniers.release();
	}

}
