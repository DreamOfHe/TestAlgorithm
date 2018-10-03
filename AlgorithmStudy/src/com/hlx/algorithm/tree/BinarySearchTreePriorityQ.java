package com.hlx.algorithm.tree;

//programming work 12.4
public class BinarySearchTreePriorityQ {
	private BinarySearchTree queTree;
	
	public BinarySearchTreePriorityQ(){
		queTree = new BinarySearchTree();
	}
	
	public void insert(int item){
		queTree.insert(item);
	}
	
	public int remove(){
		return queTree.removeMax().getId();
	}
	
	public int peek(){
		return queTree.peekMax().getId();
	}
	
	public boolean isEmpty(){
		return queTree.isEmpty();
	}
	
	public boolean isFull(){
		return false;
	}
	
	public void display(){
		queTree.traverse(2);
	}
}
