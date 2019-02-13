package expression;

public interface Visitable {
	
	public abstract boolean accept(Visitor visitor);
}
