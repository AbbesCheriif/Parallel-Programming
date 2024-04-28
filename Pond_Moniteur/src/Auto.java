
public class Auto extends Thread {
	Moniteur m;
	int sens;

	Auto(Moniteur m, String name, int sens) {
		super(name);
		this.m = m;
		this.sens = sens;
	}

	@Override
	public void run() {
		// rouler
		try {
			m.rouler(sens);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.acces_Pond();
		m.quitter();
	}

}
