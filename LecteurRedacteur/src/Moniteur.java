import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Moniteur {
	private final ReentrantLock l = new ReentrantLock();
	private Condition oktowrite = l.newCondition();
	private Condition oktoread = l.newCondition();
	private boolean red_actif = false;
	private int l_actif = 0;
	private int nbRed = 0;

	void debutLecture() throws InterruptedException {
		l.lock();
		try {
			while ((red_actif) || (nbRed > 0)) {
				System.out.println(Thread.currentThread().getName() + " a entree la file d'att de lecture");
				oktoread.await();
				System.out.println(Thread.currentThread().getName() + " a quitte la file d'att de lecture");
			}
			l_actif++;
			System.out.println(Thread.currentThread().getName() + " a commencer de lire");
			oktoread.signal();
		} finally {
			l.unlock();
		}
	}

	void finLecture() {
		l.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " a terminer de lire");
			l_actif--;
			if (l_actif == 0)
				oktowrite.signal();
		} finally {
			l.unlock();
		}
	}

	void debutEcriture() throws InterruptedException {
		l.lock();
		try {
			// solution 2
			// nbRed++;
			while ((red_actif) || (l_actif > 0)) {
				nbRed++;
				System.out.println(Thread.currentThread().getName() + "a entree la file d'att d'ecriture");
				oktowrite.await();
				System.out.println(Thread.currentThread().getName() + "a quitte la file d'att d'ecriture");
				nbRed--;
			}
			// nbRed--;
			System.out.println(Thread.currentThread().getName() + " a commencer d'ecrire");
			red_actif = true;
		} finally {
			l.unlock();
		}
	}

	void finEcriture() {
		l.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " a terminer de ecriture");
			red_actif = false;
			oktoread.signal();
		} finally {
			l.unlock();
		}
	}

	void lire() {
		System.out.println(Thread.currentThread().getName() + "en cour de lire");
	}

	void ecrire() {
		System.out.println(Thread.currentThread().getName() + "en cour d'ecrire");
	}

}
