package expression;

/**
 * nodul && din arboreale de expresii
 * atruibute clasei:
 * - letf : fiul sau stang
 * - right : fiul sau drept
 * @author mihai
 *
 */
public class AndNode implements Node {

	private Node left;
	private Node right;

	public AndNode() {
		this(null, null);
	}

	public AndNode(Node left, Node right) {
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
