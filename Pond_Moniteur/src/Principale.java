
public class Principale {
	public static void main(String[] args) {
		Moniteur m = new Moniteur();
		Auto a1 = new Auto(m, "a1", 1);
		Auto a2 = new Auto(m, "a2", -1);
		Auto a3 = new Auto(m, "a3", -1);
		Auto a4 = new Auto(m, "a4", 1);
		Auto a5 = new Auto(m, "a5", 1);
		Auto a6 = new Auto(m, "a6", -1);
		Auto a7 = new Auto(m, "a7", 1);
		Auto a8 = new Auto(m, "a8", 1);
		Auto a9 = new Auto(m, "a9", 1);
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();
		a6.start();
		a7.start();
		a8.start();
		a9.start();
	}
}
