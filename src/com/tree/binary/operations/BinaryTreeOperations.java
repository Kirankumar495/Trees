package com.tree.binary.operations;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.tree.binary.Node;

public class BinaryTreeOperations {

	private static Node root = null;
	private static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		insertNodeInBinarySearchTree(root, 45);
		insertNodeInBinarySearchTree(root, 25);
		insertNodeInBinarySearchTree(root, 75);
		insertNodeInBinarySearchTree(root, 15);
		insertNodeInBinarySearchTree(root, 35);
		
		printRootToLeafPaths(root);
		
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

	public void insertNodeInBinaryTree(Node node, int data) {
		if (root == null) {
			root = new Node(data);
		} 
		else {
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			while(!q.isEmpty()) {
				Node temp = q.poll();
				if(temp.getLeftNode() == null) {
					temp.leftNode = new Node(data);
					break;
				}else if(temp.getRightNode() == null) {
					temp.rightNode = new Node(data);
					break;
				}else {
					q.add(temp.getLeftNode());
					q.add(temp.getRightNode());
				}
			}
		}
	}

	
	public static int findSize(Node node) {
		if(node == null) {
			return 0;
		}
		return 1 + findSize(node.getLeftNode()) + findSize(node.getRightNode());
	}
	
	public static boolean searchElementInBinaryTree(Node node, int data) {
		if(node == null) {
			return false;
		}
		if(node.getData() == data) {
			return true;
		}
		return searchElementInBinaryTree(node.getLeftNode(), data) || 
				searchElementInBinaryTree(node.getRightNode(), data);
	}
	
	public static boolean searchElementWithoutRecursion(Node node, int data) {	
		Queue<Node> queue = new LinkedList<Node>();
		if(node == null) {
			return false;
		}
		queue.offer(node);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			if(temp.getData() == data) {
				return true;
			}
			if(temp.getLeftNode() != null) {
				queue.offer(temp.getLeftNode());
			}
			if(temp.getRightNode() != null) {
				queue.offer(temp.getRightNode());
			}
		}
		return false;
	}
	
	public static int heightOfBinaryTree(Node node) {
		if(node == null) {
			return 0;
		}
		int left = heightOfBinaryTree(node.getLeftNode());
		int right = heightOfBinaryTree(node.getRightNode());
		
		return Math.max(left, right) + 1;
	}
	
	public static void printRootToLeafPaths(Node node) {
		if(node == null) {
			return;
		}
		stack.push(node.getData());
		if(node.getLeftNode() == null && node.getRightNode() == null) {
			printStackInInsertOrder(stack);
			System.out.println("\n");
		}
		printRootToLeafPaths(node.getLeftNode());
		printRootToLeafPaths(node.getRightNode());
		stack.pop();	
	}
	
	private static void printStackInInsertOrder(Stack<Integer> stack) {
		Enumeration<Integer> elements = stack.elements();
		while(elements.hasMoreElements()) {
			System.out.print(elements.nextElement() + " ");
		}
	}
}
