import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Moniteur {
	private final ReentrantLock l = new ReentrantLock();
	private final Condition c = l.newCondition();
	private int sensPond = 0;
	private int nbv = 0;

	public void rouler(int sens) throws InterruptedException {
		l.lock();
		try {
			// 1er voiture arrivée
			if (nbv == 0)
				sensPond = sens;
			// cond => attente
			while (sens != sensPond) {
				System.out.println("***" + Thread.currentThread().getName() + ": je suis en attente***");
				c.await();
				if (nbv == 0)
					sensPond = sens;
			}
			nbv++;
			System.out.println(Thread.currentThread().getName() + " passe sur le pond dans le sens " + sens
					+ " et le nbv= " + nbv);
		} finally {

			l.unlock();
		}
	}

	public void acces_Pond() {
		System.out.println(Thread.currentThread().getName() + " je roule sur le pond");
	}

	public void quitter() {
		l.lock();
		try {
			nbv--;
			System.out.println(Thread.currentThread().getName() + " je quitte le pond et nbv=" + nbv);
			c.signal();
		} finally {
			l.unlock();
		}
	}
}


