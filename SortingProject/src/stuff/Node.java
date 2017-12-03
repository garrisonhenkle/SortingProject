package stuff;

class Node {
	 public Object element;
	 public Node left;
	 public Node right;

	 // CONSTRUCTORS 
	 public Node(Object theElement) {
	  this(theElement, null, null);
	 }

	 public Node(Object theElement, Node lLink, Node rLink) {
	  element = theElement;
	  this.left = lLink;
	  this.right = rLink;
	 }
	}