package com.tree.binary.operations;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.tree.binary.Node;

public class RightViewOfBinaryTree {
	private static Node root = null;
	private static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		insertNodeInBinaryTree(root, 1);
		insertNodeInBinaryTree(root, 2);
		insertNodeInBinaryTree(root, 3);
		insertNodeInBinaryTree(root, 4);
		insertNodeInBinaryTree(root, 5);
		insertNodeInBinaryTree(root, 6);
		insertNodeInBinaryTree(root, 8);
		insertNodeInBinaryTree(root, 9);
		insertNodeInBinaryTree(root, 10);
		rightViewOfBinaryTree(root);
	}

	public static void insertNodeInBinaryTree(Node node, int data) {
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

	private static void rightViewOfBinaryTree(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		int last = -1;
		while (!q.isEmpty()) {
			Node tempNode = q.poll();
			if (tempNode != null) {
				last = tempNode.getData();
				if (tempNode.getLeftNode() != null)
					q.add(tempNode.getLeftNode());
				if (tempNode.getRightNode() != null)
					q.add(tempNode.getRightNode());
			} else {
				System.out.println("\n");
				stack.push(last);
				if(!q.isEmpty())
					q.add(null);
			}
		}
	}

}
