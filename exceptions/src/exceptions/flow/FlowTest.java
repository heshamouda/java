package exceptions.flow;

public class FlowTest {

	public static void main(String[] args) {

		try {
			p(3);
		} catch (E3 e) {

			e.printStackTrace();
		}

	}

	static void p(int status) throws E3 {

		try {
			q(status);
			System.out.println("p - after q()");
		} catch (E1 ex) {
			System.out.println("p - " + ex.getMessage());
		}
		System.out.println("p - end");
	}

	static void q(int status) throws E1, E3 {

		try {
			r(status);
			System.out.println("q - after r()");
		} catch (E2 ex) {
			System.out.println("q - " + ex.getMessage());
		} finally {
			System.out.println("q - finally...");
		}
		System.out.println("q - end");
	}

	static void r(int status) throws E1, E2, E3 {
		if (status == 0) {
			throw new E1("E1");
		} else if (status == 1) {
			throw new E2("E2");
		} else if (status == 2) {
			throw new E3("E3");
		}
	}

}

class E1 extends Exception {

	E1(String msg) {
		super(msg);
	}
}

class E2 extends Exception {

	E2(String msg) {
		super(msg);
	}
}

class E3 extends Exception {

	E3(String msg) {
		super(msg);
	}
}
