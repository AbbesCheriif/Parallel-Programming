package tn.enis.cherif;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Moniteur {
	private boolean etat = true;
	private final ReentrantLock l = new ReentrantLock();
	private final Condition waitToImp = l.newCondition();

	public void allouer() throws InterruptedException {
		l.lock();
		try {
			// si etat = false attendre sinon on change son etat
			while (etat == false) {
				waitToImp.await();
			}
			etat = false;
			System.out.println(Thread.currentThread().getName() + ": j'alloue l'imprimente");
		} finally {
			l.unlock();
		}
	}

	public void utiliser(String impName) {
		System.out.println(Thread.currentThread().getName() + ": j'utilise l'imprimente " + impName);
	}

	public void liberer() {
		l.lock();
		try {
			etat = true;
			System.out.println(Thread.currentThread().getName() + ": je vais liberer l'imprimente");
			waitToImp.signal();
		} finally {
			l.unlock();
		}
	}

	public boolean getEtat() {
		return etat;
	}

}
