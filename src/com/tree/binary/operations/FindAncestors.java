package com.tree.binary.operations;

import com.tree.binary.Node;
import static com.tree.binary.operations.BinaryTreeOperations.insertNodeInBinarySearchTree;

import java.util.Stack;

public class FindAncestors {

	private static Node root = null;
	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		insertNodeInBinarySearchTree(root, 45);
		insertNodeInBinarySearchTree(root, 25);
		insertNodeInBinarySearchTree(root, 75);
		insertNodeInBinarySearchTree(root, 15);
		insertNodeInBinarySearchTree(root, 35);
		findAncestors(root, 75);

	}
	
	public static void insertNodeInBinarySearchTree(Node node, int data) {
		if (root == null) {
			root = new Node(data);
		} else if (data <= node.getData()) {
			if (node.leftNode != null) {
				insertNodeInBinarySearchTree(node.leftNode, data);
			} else {
				node.leftNode = new Node(data);
			}
		} else {
			if (node.rightNode != null) {
				insertNodeInBinarySearchTree(node.rightNode, data);
			} else {
				node.rightNode = new Node(data);
			}
		}
	}
	
	private static void findAncestors(Node node, int data) {
		if(node == null) {
			return;
		}
		
		if(node.getData() == data) {
			System.out.println(stack);
		}
		stack.push(node.getData());
		findAncestors(node.getLeftNode(), data);
		findAncestors(node.getRightNode(), data);
		stack.pop();
	}

}
