package com.tree.threaded;

public class ThreadNode {
	ThreadNode left;
	ThreadNode right;
	int data;
	boolean rightThread;

	public ThreadNode(int data){
        this.data = data;
        rightThread = false;
    }
}
