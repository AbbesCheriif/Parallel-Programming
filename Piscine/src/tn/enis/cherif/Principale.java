package tn.enis.cherif;

import java.util.concurrent.Semaphore;

public class Principale {
	static int n = 7;
	static int p = 5;
	static int c = 3;
	static Semaphore paniers = new Semaphore(p);
	static Semaphore cabines = new Semaphore(c);

	public static void main(String[] args) {
		Nageur n1 = new Nageur("n1");
		Nageur n2 = new Nageur("n2");
		Nageur n3 = new Nageur("n3");
		Nageur n4 = new Nageur("n4");
		Nageur n5 = new Nageur("n5");
		Nageur n6 = new Nageur("n6");
		Nageur n7 = new Nageur("n7");
		Nageur n8 = new Nageur("n8");
		n1.start();
		n2.start();
		n3.start();
		n4.start();
		n5.start();
		n6.start();
		n7.start();
		n8.start();
	}

}
