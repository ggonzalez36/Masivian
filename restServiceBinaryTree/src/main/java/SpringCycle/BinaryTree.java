package SpringCycle;

public class BinaryTree {
	
	 @Override
	public String toString() {
		return "BinaryTree [root=" + root + "]";
	}

	Node root; 
	  
	    // Constructors 
	    BinaryTree(int key) 
	    { 
	        root = new Node(key); 
	    } 
	  
	    BinaryTree() 
	    { 
	        root = null; 
	    }
	    
		private Node addRecursive(Node current, int value) {
		    if (current == null) {
		        return new Node(value);
		    }
		 
		    if (value < current.value) {
		        current.left = addRecursive(current.left, value);
		    } else if (value > current.value) {
		        current.right = addRecursive(current.right, value);
		    } else {
		        // value already exists
		        return current;
		    }
		 
		    return current;
		}
		
		public void add(int value) {
		    root = addRecursive(root, value);
		}

}
