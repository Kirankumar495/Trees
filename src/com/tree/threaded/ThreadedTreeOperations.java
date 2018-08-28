package com.tree.threaded;

public class ThreadedTreeOperations {

	public static ThreadNode root;

	public static void main(String[] args) {

	}

	public static void insertNode(int data) {
		if(root == null) {
			root = new ThreadNode(data);
		}else {
			ThreadNode newNode = new ThreadNode(data);
			ThreadNode current = root;
			ThreadNode parent = null;
			
			while(true) {
				parent = current;
				if(data < current.data) {
	                current = current.left;
	                if(current==null){
	                    parent.left = newNode;
	                    newNode.right = parent;
	                    newNode.rightThread = true;
	                    return;
	                }
	            }else {
	                if(current.rightThread == false) {
	                    current = current.right;
	                    if(current==null){
	                        parent.right = newNode;
	                        return;
	                    }
	                } else {
	                		ThreadNode temp = current.right;
	                    current.right = newNode;
	                    newNode.right = temp;
	                    newNode.rightThread=true;
	                    return;
	                }
	            }
			}
		}
	}
	
	public ThreadNode leftMostNode(ThreadNode node){
        if(node==null){
            return null;
        }else{
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }
    }
	
	public void traverse() {
		//first go to most left node
		ThreadNode current = leftMostNode(root);
	
		//now travel using right pointers
        while(current!=null){
            System.out.print(" " + current.data);
            //check if node has a right thread
            if(current.rightThread)
                current = current.right;
            else // else go to left most node in the right subtree
                current = leftMostNode(current.right);
        }

	}
}
