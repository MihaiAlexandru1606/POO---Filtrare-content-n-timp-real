package exception;
/**
 * exceptia aruncate in cazul in care un operand din arbore ar fi incorect
 * exemplu: pentru eq name ; se arunca exceptia
 * pentru arbore am consiederat ca && si || sunt operanzi, 
 * 	iar eq name A este operand
 * @author mihai
 *
 */
public class OperandException extends RuntimeException {

	/**
	 * seria pentru exceptie
	 */
	private static final long serialVersionUID = -2340892536297827473L;
	
	public OperandException() {
		super();

	}
	
	public OperandException(String message) {
		super(message);

	}

}
