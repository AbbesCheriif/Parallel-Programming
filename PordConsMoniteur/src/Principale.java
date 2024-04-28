
public class Principale {

	public static void main(String[] args) {
		Moniteur m = new Moniteur();
		Prod p1 = new Prod(m);
		Cons c1 = new Cons(m);
		Prod p2 = new Prod(m);
		Cons c2 = new Cons(m);
		Prod p3 = new Prod(m);
		Cons c3 = new Cons(m);
		Prod p4 = new Prod(m);
		Cons c4 = new Cons(m);
		Prod p5 = new Prod(m);
		Cons c5 = new Cons(m);
		Prod p6 = new Prod(m);
		Cons c6 = new Cons(m);
		Prod p7 = new Prod(m);
		Cons c7 = new Cons(m);
		p1.start();
		c2.start();
		p3.start();
		c4.start();
		p5.start();
		c6.start();
		p7.start();
		c1.start();
		p2.start();
		c3.start();
		p4.start();
		c5.start();
		p6.start();
		c7.start();
	}
}
