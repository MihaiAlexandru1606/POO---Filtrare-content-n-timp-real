package operators;

/*
 * implementarea pentru ne
 */
public class NotEqual implements Operators {

	public NotEqual() {
		super();
	}

	/**
	 * metoda returneaza true daca variabile1 nu este egala cu variabile2
	 */
	@Override
	public boolean compare(String variable1, String variable2) {

		return !variable1.equals(variable2);
	}

}
