package com.tree.binary.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.tree.binary.Node;

public class TreeTraversals {
	
	/**
	 * (a) Traverse the left subtree, 
	 * (b) Visit the root node and print data of that node, and 
	 * (c) Traverse the right subtree.
	 */
	public static void inOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		inOrderTraversal(node.getLeftNode());
		System.out.print(node.getData() + " ");
		inOrderTraversal(node.getRightNode());
	}
	
	public static void inOrderTraversalIterative(Node node) {
		if(node == null) {
			return ;
		}
		Stack<Node> stack = new Stack<Node>();
		Node currentNode = node;

		while(true) {
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeftNode();
			}
			else {
				if(stack.isEmpty()) {
					break;
				}
				else {
					currentNode = stack.pop();
					System.out.print(currentNode.getData() + " ");
					currentNode = currentNode.getRightNode();
				}
			}
		}
	}
	
	/**
	 * (a) Visit the root node and print data of that node. 
	 * (b) Traverse the left subtree, and 
	 * (c) Traverse the right subtree.
	 */
	public static void preOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.getData() + " ");
		preOrderTraversal(node.getLeftNode());
		preOrderTraversal(node.getRightNode());
	}
	
	public static void preOrderTraversalIterative(Node node) {
		if(node == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.getData() + " ");
			if(temp.getRightNode() != null) {
				stack.push(temp.getRightNode());
			}
			if(temp.getLeftNode() != null) {
				stack.push(temp.getLeftNode());
			}
		}
	}
	
	/**
	 * (a) Traverse the left subtree, 
	 * (b) Traverse the right subtree, and 
	 * (c) Visit the root node and print data of that node.
	 */
	public static void postOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		postOrderTraversal(node.getLeftNode());
		postOrderTraversal(node.getRightNode());
		System.out.print(node.getData() + " ");
	}
	
	public static void postOrderTraversalUsingTwoStacks(Node node) {
		if(node == null) return;
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(node);
		while(!stack1.isEmpty()) {
			Node temp = stack1.pop();
			if(temp.getLeftNode() != null) {
				stack1.push(temp.getLeftNode());
			}
			if(temp.getRightNode() != null) {
				stack1.push(temp.getRightNode());
			}
			stack2.push(temp);
		}
		 while(!stack2.isEmpty()){
	            System.out.print(stack2.pop().getData() + " ");
	        }
	}
	
	public static void postOrderTraversalIterative(Node node) {
		if(node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node current = node;
		while(true) {
			if(current != null) {
				stack.push(current);
				current = current.getLeftNode();
			}
			else {
				Node temp = stack.peek().getRightNode();
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.getData() + " ");
                    while (!stack.isEmpty() && temp == stack.peek().getRightNode()) {
                        temp = stack.pop();
                        System.out.print(temp.getData() + " ");
                    }
                } else {
                    current = temp;
                }
			}
		}
	}
	
	public static void levelOrderTraversal(Node node) {
		if (node == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			while (!q.isEmpty()) {
				Node tempNode = q.poll();
				System.out.println(tempNode.getData());
				if (tempNode.getLeftNode() != null)
					q.add(tempNode.getLeftNode());
				if (tempNode.getRightNode() != null)
					q.add(tempNode.getRightNode());
			}
		}
	}
	
	public static void levelOrderTraversalPrintbyLevelsByHorizontal(Node node) {
		if (node == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			q.add(null);
			while (!q.isEmpty()) {
				Node tempNode = q.poll();
				if(tempNode != null) {
					System.out.print(tempNode.getData());
					if (tempNode.getLeftNode() != null)
						q.add(tempNode.getLeftNode());
					if (tempNode.getRightNode() != null)
						q.add(tempNode.getRightNode());
				}
				else {
					System.out.println("\n");
					if(!q.isEmpty())
						q.add(null);
				}
			}
		}
	}
	
	public static void verticalTraversal(Node node) {	
		Map<Integer, List<Node>> map = new LinkedHashMap<Integer, List<Node>>();
		updateMap(node, map, 0);
		printLevel(map);
	}
	
	public static void updateMap(Node node, Map<Integer, List<Node>> map, int level) {
		if(node == null) return;
		
		List<Node> listNodes = null;
        if(map.containsKey(level)){
            listNodes = map.get(level);
        }else{
            listNodes = new ArrayList<Node>();
            map.put(level, listNodes);
        }
        listNodes.add(node);
        
        updateMap(node.getLeftNode(),map,level-1);
        updateMap(node.getRightNode(),map,level+1);
		
	}
	
	private static void printLevel(Map<Integer,List<Node>> map){
        for(Integer key : map.keySet()){
            List<Node> listNodes = map.get(key);
            for(Node n : listNodes){
                System.out.print(n.getData() + " ");
            }
            System.out.println();
        }
    }
	
	public static void verticalTraversalIterative(Node node) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		int level = 0;
		Map<Integer, List<Node>> map = new LinkedHashMap<Integer, List<Node>>();
		
		Map<Node, Integer> levelmap = new HashMap<>();
		levelmap.put(node, level);
		
		while(!stack.isEmpty()) {
			level = levelmap.get(stack.peek());
			Node temp = stack.pop();
			if(map.containsKey(level)) {
				map.get(level).add(temp);
			}else {
				List<Node> listNodes = new ArrayList<>();
				listNodes.add(temp);
				map.put(level, listNodes);
			}
			if(temp.getRightNode() != null) {
				stack.push(temp.getRightNode());
				levelmap.put(temp.getRightNode(), level + 1);
			}
			if(temp.getLeftNode() != null) {
				stack.push(temp.getLeftNode());
				levelmap.put(temp.getLeftNode(), level - 1);
			}
		}
		printLevel(map);
	}

}
