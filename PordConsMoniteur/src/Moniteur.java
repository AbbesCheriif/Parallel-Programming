import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Moniteur {

	// declarer les variables partagés
	private int n = 10;
	private int[] tab = new int[n];
	private int i = 0;
	private int j = 0;
	private final ReentrantLock l = new ReentrantLock();
	private final Condition cond1 = l.newCondition();
	private final Condition cond2 = l.newCondition();
	private int nbvide = n;

	public void append() throws InterruptedException {
		Thread.sleep(1);
		l.lock();
		try {
			int x = (int) (Math.random() * 100);
			while (nbvide == 0) {
				System.out.println("prod: je vais m'attendre");
				cond1.await();
				System.out.println("prod: quitte l'attente");
			}
			tab[i] = x;
			System.out.println("le prod produit: " + x);
			i = (i + 1) % n;
			nbvide--;
			cond2.signal();
		} finally {
			l.unlock();
		}
	}

	public void take() throws InterruptedException {
		l.lock();
		try {
			while (nbvide == n) {
				System.out.println("cons: je vais m'attendre");
				cond2.await();
				System.out.println("prod: quitte l'attente");
			}
			int x = tab[j];
			System.out.println("le cons consomme: " + x);
			j = (j + 1) % n;
			nbvide++;
			cond1.signal();
		} finally {
			l.unlock();
		}
	}

}
