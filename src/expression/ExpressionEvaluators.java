package expression;

/**
 * clasa care implementeaza un evaluator de expresie, 
 * pentru a determina daca un feed este valid
 * @author mihai
 *
 */
public class ExpressionEvaluators implements Visitor {
	
	private static ExpressionEvaluators instance = null;
	
	private ExpressionEvaluators() {}
	
	
	public static ExpressionEvaluators getInstance() {
		if(instance == null ) {
			instance = new ExpressionEvaluators();
		}
		
		return instance;
	}
	
	/**
	 * implemetarea metodei visit pentru nodul And
	 * metoda returneaza and logic intre valorile nodului left si right
	 */
	@Override
	public boolean visit(AndNode and) {
		return (and.getLeft().accept(this) && and.getRight().accept(this));
	}

	/**
	 * implemetarea metodei visit pentru nodul Or
	 * metoda returneaza or logic intre valorile nodului left si right
	 */
	@Override
	public boolean visit(OrNode or) {
		return (or.getLeft().accept(this) || or.getRight().accept(this));
	}

	/**
	 * implemetarea metodei visit pentru nodul operand 
	 * metoda returneaza valoare booleana pentru o expresie
	 * exemplu : true pentru eq AAA AAA
	 */
	@Override
	public boolean visit(OperandNode operand) {

		return operand.getValue();
	}

}
