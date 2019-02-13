package operators;

/**
 * Interfata pentru "Op"
 * @author mihai
 *
 */
public interface Operators {

	/**
	 * metoda returneaza o valuare booleana in functie de cum sunt comparate
	 * exemplu pentru: lt 10 123 este true
	 * @param variable1 variabila 1
	 * @param variable2 variabila 2
	 * @return "relatia" dintre cele doua variabile
	 */
	public abstract boolean compare(String variable1, String variable2);
}
