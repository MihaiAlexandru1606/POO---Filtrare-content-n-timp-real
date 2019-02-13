package expression;

/**
 * clasa care implementeza nodul or din arborele de expresii
 * atributele clasei:
 * - left: fiul stang
 * - right: fiul drept
 * @author mihai
 *
 */
public class OrNode implements Node {

	private Node left;
	private Node right;

	public OrNode() {
		this(null, null);
	}

	public OrNode(Node left, Node right) {
		super();
		this.left = left;
		this.right = right;
	}

	
	public Node getLeft() {
		return left;
	}

	
	public void setLeft(Node left) {
		this.left = left;
	}

	
	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public boolean accept(Visitor visitor) {
		return visitor.visit(this);
	}

}
