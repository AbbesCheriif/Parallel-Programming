package tn.enis.cherif;

public class Principale {

	public static void main(String[] args) {
		Moniteur ma = new Moniteur();
		Moniteur mb = new Moniteur();
		ProcA pa = new ProcA(ma, "processusA");
		ProcB pb = new ProcB(mb, "processusB");
		ProcAB pab = new ProcAB(ma, mb, "processusAB");
		pa.start();
		pb.start();
		pab.start();
	}
}
