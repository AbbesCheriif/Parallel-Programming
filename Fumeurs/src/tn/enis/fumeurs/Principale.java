package tn.enis.fumeurs;

import java.util.concurrent.Semaphore;

public class Principale {
	static Semaphore AP = new Semaphore(0);
	static Semaphore AT = new Semaphore(0);
	static Semaphore TP = new Semaphore(0);
	static Semaphore c = new Semaphore(1);

	public static void main(String[] args) {
		Fumeur1 f1 = new Fumeur1();
		Fumeur2 f2 = new Fumeur2();
		Fumeur3 f3 = new Fumeur3();
		Agent a = new Agent();
		f1.start();
		f2.start();
		f3.start();
		a.start();
	}
}
