package expression;

/**
 * interfata pentru visitor,
 * visitor va evalua fiecare valuare a fiecarui nod, in functie de tipul nodului
 * @author mihai
 *
 */
public interface Visitor {
	
	/**
	 * metoada efectueza and logic intre valuarea fiul drept si stang
	 * @param and nodul and pe care il viziteaza
	 * @return and logic intre valuarea fiului drept si stang al noduli and
	 */
	public abstract boolean visit(AndNode and);
	
	/**
	 * metoada efectueza or logic intre valuarea fiul drept si stang
	 * @param or nodul and pe care il viziteaza
	 * @return or logic intre valuarea fiului drept si stang al noduli or
	 */
	public abstract boolean visit(OrNode or);
	
	/**
	 * metoda returneaza valuare nodului operand
	 * @param operand nodul funza 
	 * @return valueazea nodului( true sau false) 
	 */
	public abstract boolean visit(OperandNode operand);

}
