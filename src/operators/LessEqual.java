package operators;

/**
 * implemetarea le
 * @author mihai
 *
 */
public class LessEqual implements Operators {

	public LessEqual() {
		super();
	}

	/**
	 * metoda returneaza true daca variabile1 este mai mica sau egale decat variabile2
	 */
	@Override
	public boolean compare(String variable1, String variable2) {

		return (Double.parseDouble(variable1) <= Double.parseDouble(variable2));
	}
}