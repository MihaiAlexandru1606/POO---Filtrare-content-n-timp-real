package exception;

/**
 * exceptia pentru pasarea incorecta
 * @author mihai
 *
 */

public class ParserException extends Exception{

	/**
	 * seria pentru exceptie
	 */
	private static final long serialVersionUID = -3709964437922606926L;

	public ParserException() {
		super();
	}

	public ParserException(String message) {
		super(message);
	}
	
	

}
