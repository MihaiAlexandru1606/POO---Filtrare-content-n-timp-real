package expression;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Clasa care contine metoda care transforma o expresie infix in forma postfix
 * metoda care realizea acest lucru este convert
 * @author mihai
 *
 */
public class InfixToPostfix {

	public InfixToPostfix() {

	}

	
	/**
	 * metoda care verifica daca este operator
	 * operator se considera pentru arborele de expresi :&& si ||
	 */
	public static boolean isOperator(String token) {
		return (token.equals("&&") || token.equals("||"));
	}

	
	/**
	 * metoda care realizeaza transformarea expresiei
	 * metoda foloseste o forma simplicata a algoritmului Shunting-yard
	 * am considera ca && si || sunt operatori( au aceiasi prioritate) 
	 * iar eq name AAA sau lt value 10 etc sa fie operanzi
	 * @param infixExpression exprsia in forma normala 
	 * @return expersia in forma postfix
	 */
	public static String[] convert(String[] infixExpression) {
		Stack<String> operator = new Stack<String>();
		ArrayList<String> postfix = new ArrayList<String>(infixExpression.length);
		String[] postfixExpression;

		for (String token : infixExpression) {

			if (isOperator(token)) {
				operator.push(token);

			} else if (token.equals("(")) {
				operator.push(token);

			} else if (token.equals(")")) {

				while (!operator.isEmpty() && !operator.peek().equals("(")) {
					postfix.add(operator.pop());
				}
				operator.pop();
			} else {
				postfix.add(token);
			}

		}

		while (!operator.empty()) {
			postfix.add(operator.pop());
		}

		postfixExpression = new String[postfix.size()];
		return postfix.toArray(postfixExpression);
	}

}
