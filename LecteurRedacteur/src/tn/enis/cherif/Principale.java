package tn.enis.cherif;

public class Principale {
	public static void main(String[] args) {
		Moniteur m = new Moniteur();
		Lecteur l1 = new Lecteur(m, "lec1");
		Lecteur l2 = new Lecteur(m, "lec2");
		Lecteur l3 = new Lecteur(m, "lec3");
		Lecteur l4 = new Lecteur(m, "lec4");
		Lecteur l5 = new Lecteur(m, "lec5");

		Redacteur r1 = new Redacteur(m, "red1");
		Redacteur r2 = new Redacteur(m, "red2");

		l1.start();
		l2.start();
		l3.start();
		l4.start();
		l5.start();

		r1.start();
		r2.start();
	}
}
