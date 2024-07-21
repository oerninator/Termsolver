package term;

/**
 * A Node in a parse tree. Each Node represents one of two things:
 * 
 * <ol>
 *   <li>An operator, in which case there needs to be a left and right subtree to
 *       represent the operands.</li>
 *   <li>A literal, in which case the subtrees will be empty.</li>
 * </ol>
 */
public class Node {

	/** The literal or operator represented by this Node. */
	private String content;
	/** The left subtree, if any. */
	private Node left;
	/** The right subtree, if any. */
	private Node right;

	/**
	 * Creates a new term without subtrees.
	 * 
	 * @param content
	 *            the operator or literal represented by this Node.
	 */
	public Node(String content) {
		// Call the other constructor
		this(content, null, null);
	}

	/**
	 * Creates a new term with the given subtrees.
	 * 
	 * @param content
	 *            the operator or literal represented by this Node.
	 * @param left
	 *            the left subtree, if any.
	 * @param right
	 *            the right subtree, if any.
	 */
	public Node(String content, Node left, Node right) {
		this.content = content;
		this.left = left;
		this.right = right;
	}

	/**
	 * Returns the operator or literal represented by this Node.
	 * 
	 * @return the operator or literal.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the operator or literal represented by this Node.
	 * 
	 * @param content
	 *            the new operator or literal.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Returns the left subtree.
	 * 
	 * @return the left subtree.
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Returns the right subtree.
	 * 
	 * @return the right subtree.
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Sets the left subtree.
	 * 
	 * @param left
	 *            the new left subtree.
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * Sets the right subtree.
	 * 
	 * @param right
	 *            the new right subtree.
	 */
	public void setRight(Node right) {
		this.right = right;
	}
}
