
public class Principale {

	public static void main(String[] args) {
		Moniteur m = new Moniteur();
		Processus p50 = new Processus(m, 50);
		Processus p30 = new Processus(m, 30);
		Processus p25 = new Processus(m, 25);
		Processus p11 = new Processus(m, 11);
		Processus p7 = new Processus(m, 7);

		p50.start();
		p25.start();
		p30.start();
		p11.start();
		p7.start();
	}

}
