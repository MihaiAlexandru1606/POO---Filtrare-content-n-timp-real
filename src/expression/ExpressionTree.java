package expression;

import java.util.Stack;

import exception.*;

/**
 * clasa care creaza arborele pe baza unei expresii postfix
 * atributele clasei sunt:
 * - root: radacina arborelului creat
 * - name : variabila cu care se efectueaza compararea
 * - value : variabila cu care se efectueaza compararea
 * pentru feed : AAAA 122 , name este AAAA si value este 122
 * am folosit StringBuilder pentru a putea modifica respectivul string,
 * 	si a nu fii nevoit sa tot modific pentru fiecare feed, fiecare nod
 * @author mihai
 *
 */
public class ExpressionTree {

	private Node root;
	private StringBuilder name = null;
	private StringBuilder value = null;

	public ExpressionTree() {
		this.setRoot(null);
		this.name = null;
		this.value = null;
	}

	public ExpressionTree(String[] infixExpression) {
		this.name = new StringBuilder("  ");
		this.value = new StringBuilder("  ");
		this.setRoot(this.create(InfixToPostfix.convert(infixExpression)));
	}

	
	public StringBuilder getName() {
		return name;
	}

	/**
	 * 
	 * @param name numele stock-ului pentru un feed
	 * pentru fiecare feed, vechiul name este inlocult cu name actualui feed 
	 */
	public void setName(String name) {
		this.name.delete(0, this.name.length());
		this.name.append(name);
	}

	
	public StringBuilder getValue() {
		return value;
	}
	
	
	/**
	 * 
	 * @param value valuarea stock-ului pentru un feed
	 * functioneaza dupa aceiasi logica ca si this.name
	 */
	public void setValue(String value) {
		this.value.delete(0, this.value.length());
		this.value.append(value);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * metoda care creaza un arbore pe baza unei expresi postfix
	 * @param postfixExpression expresia dupa ce a fost transformata in forma RNP
	 * @return radacina arborelui creat
	 */
	public Node create(String[] postfixExpression) {
		Stack<Node> stack = new Stack<Node>();
		Node aux, auxLeft, auxRight;

		for (String token : postfixExpression) {

			if (!InfixToPostfix.isOperator(token)) {
				String[] operand = token.split(" ");

				if (operand.length != 3)
					throw new OperandException();

				if (operand[1].equals("name"))
					aux = new OperandNode(operand[0], this.name, operand[2]);
				else if (operand[1].equals("value"))
					aux = new OperandNode(operand[0], this.value, operand[2]);
				else
					throw new OperandException();

				stack.push(aux);
			} else {
				auxRight = stack.pop();
				auxLeft = stack.pop();

				if (token.equals("&&"))
					aux = new AndNode(auxLeft, auxRight);
				else
					aux = new OrNode(auxLeft, auxRight);

				stack.push(aux);
			}
		}
		aux = stack.peek();
		stack.pop();

		return aux;
	}

}
