package SpringCycle;

class Node {
    int value;
    Node left;
    Node right;
 
    
    @Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
	}


	Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
	

}