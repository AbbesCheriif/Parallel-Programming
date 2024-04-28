package tn.enis.fumeurs;

public class Agent extends Thread {
	String[] names = { "A", "P", "T" };

	@Override
	public void run() {
		while (true) {
			try {
				Principale.c.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int x = (int) (Math.random() * 3);
			int y = (int) (Math.random() * 3);
			while (x == y) {
				y = (int) (Math.random() * 3);
			}
			String a = names[x];
			String b = names[y];
			fabriquer(a, b);
		}
	}

	public void fabriquer(String a, String b) {
		if ((a == "T") && (b == "A")) {
			Principale.AT.release();
		} else if ((a == "A") && (b == "T")) {
			Principale.AT.release();
		}

		if ((a == "P") && (b == "A")) {
			Principale.AP.release();
		} else if ((a == "A") && (b == "P")) {
			Principale.AP.release();
		}

		if ((a == "T") && (b == "P")) {
			Principale.TP.release();
		} else if ((a == "P") && (b == "T")) {
			Principale.TP.release();
		}
	}
}
