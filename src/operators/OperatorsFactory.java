package operators;

/**
 * @author mihai
 *
 */
public class OperatorsFactory {
	private static OperatorsFactory instance = null;

	private OperatorsFactory() {
	}

	/**
	 * 
	 * @return instanata pentru aceasta clasa
	 */
	public static OperatorsFactory getInstance() {
		if (instance == null) {
			instance = new OperatorsFactory();
		}

		return instance;
	}

	/**
	 * metoda care returneaza o noua instanta pentru a unui "Op"
	 * @param typeOperators stringul care sugereaza numele "Op"
	 * @return o instana a clasei in functie de typeOperators 
	 */
	public Operators getOperators(String typeOperators) {
		if (typeOperators.equals("eq")) {
			return new Equal();
		}
		if (typeOperators.equals("ne")) {
			return new NotEqual();
		}
		if (typeOperators.equals("gt")) {
			return new Greater();
		}
		if (typeOperators.equals("ge")) {
			return new GreaterEqual();
		}
		if (typeOperators.equals("lt")) {
			return new Less();
		}
		if (typeOperators.equals("le")) {
			return new LessEqual();
		}

		return null; // nu se intampla in program
	}
}
