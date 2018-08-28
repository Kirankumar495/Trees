package com.tree.binary;

public class BinaryTreeImpl {

	private Node root = null;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public BinaryTreeImpl(int data) {
		root = new Node(data);
	}
	
	public BinaryTreeImpl() {
		
	}
	
	public static void main(String[] args)
    {
		BinaryTreeImpl tree = new BinaryTreeImpl();
 
        /*create root*/
        tree.root = new Node(1);
 
        /* following is the tree after above statement
 
              1
            /   \
          null  null     */
 
        tree.root.leftNode= new Node(2);
        tree.root.leftNode = new Node(3);
 
        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */
 
 
        tree.root.leftNode.leftNode = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
    }
}
