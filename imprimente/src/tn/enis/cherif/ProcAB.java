package tn.enis.cherif;

public class ProcAB extends Thread {
	Moniteur mA;
	Moniteur mB;

	ProcAB(Moniteur ma, Moniteur mb, String name) {
		super(name);
		this.mA = ma;
		this.mB = mb;
	}

	@Override
	public void run() {
		if (mA.getEtat()) {
			try {
				mA.allouer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mA.utiliser("A");
			mA.liberer();
		} else {
			try {
				mB.allouer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mB.utiliser("B");
			mB.liberer();
		}
	}

}
