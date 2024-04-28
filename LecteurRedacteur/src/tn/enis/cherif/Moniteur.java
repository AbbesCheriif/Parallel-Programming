package tn.enis.cherif;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Moniteur {
	private int readers = 0;
	private int lectactif = 0;
	private boolean redacitf = false;
	private final ReentrantLock l = new ReentrantLock();
	private final Condition oktowrite = l.newCondition();
	private final Condition oktoread = l.newCondition();

	public void debecrire() throws InterruptedException {
		l.lock();
		try {
			// si mem_occupée attendre sinon deb_ecrire
			while (redacitf || lectactif > 0) {
				readers++;
				oktowrite.await();
				readers--;
			}
			redacitf = true;
			System.out.println(Thread.currentThread().getName() + "je vais ecrire sur la mem");
		} finally {
			l.unlock();
		}
	}

	public void finecrire() {
		l.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "*je libère la mem*");
			redacitf = false;
			oktowrite.signal();
			oktoread.signal();
		} finally {
			l.unlock();
		}
	}

	public void deblire() throws InterruptedException {
		l.lock();
		try {
			// si mem_occupée attendre sinon deb_ecrire
			while ((redacitf) || (readers > 0)) {
				oktoread.await();
			}
			lectactif++;
			System.out.println(Thread.currentThread().getName() + "je vais lire sur la mem");
			oktoread.signal();
		} finally {
			l.unlock();
		}
	}

	public void finlire() {
		l.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "*je libère la mem*");
			lectactif--;
			if (lectactif == 0)
				oktowrite.signal();
		} finally {
			l.unlock();
		}
	}

	public void ecrire() {
		System.out.println(Thread.currentThread().getName() + "j'ecris sur la memoire");
	}

	public void lire() {
		System.out.println(Thread.currentThread().getName() + "je lis sur la memoire");
	}

}
