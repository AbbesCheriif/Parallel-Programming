import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Moniteur {

	// variables partagées
	private int nbdispo = 100;
	ReentrantLock l = new ReentrantLock();
	Condition c1 = l.newCondition();

	public void release(int amount) {
		l.lock();
		try {
			nbdispo = nbdispo + amount;
			System.out.println("le processus p" + amount + " libère " + amount + "cellules");
			c1.signal();
		} finally {
			l.unlock();
		}

	}

	public void request(int amount) throws InterruptedException {
		l.lock();
		try {
			while (amount > nbdispo) {
				System.out.println("le processus p" + amount + " demandant " + amount + "cellules est en attente");
				c1.await();
			}
			nbdispo = nbdispo - amount;
			System.out.println("le processus p" + amount + " reserve " + amount + "cellules");
		} finally {
			l.unlock();
		}
	}

	void acces_Memoire() {
		System.out.println("le processus est sur la memoire ");
	}

}
