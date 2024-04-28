package tn.enis.reservation;

import java.util.concurrent.Semaphore;

public class Client extends Thread { // (2)
	static Semaphore s = new Semaphore(1);

	@Override
	public void run() {
		// séquence critique (3)
		try {
			s.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		reserver();
		s.release();
	}

	void reserver() {
		if (Principale.nbplace > 0) {

			Principale.nbplace -= 1;
		}
	}
}
