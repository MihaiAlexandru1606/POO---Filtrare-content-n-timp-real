package operators;

/**
 * implementarea pentru ge
 * @author mihai
 *
 */
public class GreaterEqual implements Operators {

	public GreaterEqual() {
		super();
	}

	/**
	 * metoda returneaza true daca variabile1 este mai mare sau egala cu variabile2
	 */
	@Override
	public boolean compare(String variable1, String variable2) {

		return (Double.parseDouble(variable1) >= Double.parseDouble(variable2));
	}
}