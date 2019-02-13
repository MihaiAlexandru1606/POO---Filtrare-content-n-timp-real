package expression;

import operators.*;

/**
 * clasa care implementeaza nodul operand
 * un nod operand in arbore este : eq name AAAA, el fiind true daca name = AAAA
 * atributele clasei:
 * - operator : se refera la operatile eq, ne, lt, etc.
 * - variable: este name sau value, in functie de initilizare
 * - compareValue: este "valuarea" cu care se compara variable
 * - value : true sau false, daca feed-ul este corect
 * exemplu:
 * 	pentru eq name AAAA
 * 	operator va fi Equal
 * 	variable va fi name dintr-un feed
 * 	compareValue va fi "AAAA"
 * 	daca se primeste feed AAAA 112, atunci value = true( eq "AAAA" "AAAA")
 * 	daca se primeste feed QQAA 12, atunci value = false( eq "QQAA" "AAAA")
 * @author mihai
 *
 */
public class OperandNode implements Node {

	private Operators operator;
	private StringBuilder variable;
	private String compareValue;
	private boolean value;

	public OperandNode() {
		this(null, null, null);
	}

	public OperandNode(String operatorType, StringBuilder variable, String compareValue) {
		super();

		this.operator = OperatorsFactory.getInstance().getOperators(operatorType);
		this.variable = variable;
		this.compareValue = compareValue;
	}

	/**
	 * 
	 * @return operator
	 */
	public Operators getOperator() {
		return operator;
	}

	/**
	 * 
	 * @param operator valuare operator
	 */
	public void setOperator(Operators operator) {
		this.operator = operator;
	}

	/**
	 * 
	 * @return compareValue
	 */
	public String getCompareValue() {
		return compareValue;
	}

	/**
	 * 
	 * @param compareValue valuarea pentru compareValue
	 */
	public void setCompareValue(String compareValue) {
		this.compareValue = compareValue;
	}

	/**
	 * 
	 * @return variable 
	 */
	public StringBuilder getVariable() {
		return variable;
	}

	/**
	 * 
	 * @param variable zona de memorie unde se va afla variable
	 */
	public void setVariable(StringBuilder variable) {
		this.variable = variable;
	}

	/**
	 * 
	 * @return daca un feed a trecut de expresia din nod
	 */
	public boolean getValue() {
		this.value = this.operator.compare(this.variable.toString(), this.compareValue);
		return value;
	}

	/**
	 * implementarea metodei accept pentru nodul operand
	 */
	@Override
	public boolean accept(Visitor visitor) {

		return visitor.visit(this);
	}

}
