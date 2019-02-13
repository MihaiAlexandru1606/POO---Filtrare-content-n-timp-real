package operators;

/**
 * implementarea pentru eq
 * @author mihai
 *
 */
public class Equal implements Operators {

	public Equal() {
		super();
	}

	/**
	 * metoda returneaza true daca variabile1 este egala cu variabile2
	 */
	@Override
	public boolean compare(String variable1, String variable2) {

		return variable1.equals(variable2);
	}

}