package operators;

/**
 * implenatarea pentru gt
 * @author mihai
 *
 */
public class Greater implements Operators {

	public Greater() {
		super();
	}

	/**
	 * metoda returneaza true daca variabile1 este mai mare decat variabile2
	 */
	@Override
	public boolean compare(String variable1, String variable2) {

		return (Double.parseDouble(variable1) > Double.parseDouble(variable2));
	}
	
}