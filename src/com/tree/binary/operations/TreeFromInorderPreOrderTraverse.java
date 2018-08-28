package com.tree.binary.operations;

import com.tree.binary.Node;

public class TreeFromInorderPreOrderTraverse {

	public static void main(String[] args) {
		int inOrder[] = new int[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		int preOrder[] = new int[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = preOrder.length;
		buildBinaryTree(inOrder, preOrder, 0, len - 1);
	}

	private static Node buildBinaryTree(int[] inOrder, int[] preOrder, int iStart, int iEnd) {
		int data = preOrder[iStart];
		Node node = new Node(data);
		
		int index = findIndexInInorder(inOrder, data, iStart, iEnd);
		
		node.leftNode = buildBinaryTree(inOrder,preOrder,iStart, index-1);
		node.rightNode = buildBinaryTree(inOrder,preOrder,index+1, iEnd);
		return node;
	}

	private static int findIndexInInorder(int[] inOrder, int data, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (inOrder[i] == data) {
				return i;
			}
		}
		return -1;
	}

}
