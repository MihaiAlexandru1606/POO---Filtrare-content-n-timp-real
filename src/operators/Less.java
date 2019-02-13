package operators;

/**
 * implementarea pentru lt
 * @author mihai
 *
 */
public class Less implements Operators {

	public Less() {
		super();
	}

	/**
	 * metoda returneaza true daca variabile1 este mai mica decat variabile2
	 */
	@Override
	public boolean compare(String variable1, String variable2) {

		return (Double.parseDouble(variable1) < Double.parseDouble(variable2) );
	}
}