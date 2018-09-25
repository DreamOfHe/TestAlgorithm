package com.hlx.algorithm.tree;

import java.util.Stack;

public class CharTree implements Comparable<Object> {
	private CharTreeNode root;            // first node of tree
	private int weight;                   // 权重
	
	public CharTree(){
		root = null;
	}
	
	public CharTreeNode getRoot() {
		return root;
	}

	public void setRoot(CharTreeNode root) {
		this.root = root;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String toString(){
		return root.getCchar() + "";
	}

	public void traverse(int traverseType){
		switch(traverseType){
		case 1:
			System.out.println("\nPreorder traversal: ");
			preOder(root);
			break;
		case 2:
			System.out.println("\nInorder traversal: ");
			inOder(root);
			break;
		case 3:
			System.out.println("\nPostorder traversal: ");
			postOder(root);
			break;
		}
		System.out.println("");
	}
	
	private void preOder(CharTreeNode localRoot){
		if(localRoot != null){
			System.out.print(localRoot.getCchar() + " ");
			preOder(localRoot.getLeftChild());
			preOder(localRoot.getRightChild());
		}
	}
	
	private void inOder(CharTreeNode localRoot){
		if(localRoot != null){
			System.out.print("(");
			inOder(localRoot.getLeftChild());
			System.out.print(localRoot.getCchar() + " ");
			inOder(localRoot.getRightChild());
			System.out.print(")");
		}
	}
	
	private void postOder(CharTreeNode localRoot){
		if(localRoot != null){
			postOder(localRoot.getLeftChild());
			postOder(localRoot.getRightChild());
			System.out.print(localRoot.getCchar() + " ");
		}
	}
	
	public void displayTree(){
		Stack<CharTreeNode> globalStack = new Stack<CharTreeNode>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
				"..................................................................................................");
		while(isRowEmpty == false){
			Stack<CharTreeNode> localStack = new Stack<CharTreeNode>();
			isRowEmpty = true;
			
			for(int j=0; j<nBlanks; j++){
				System.out.print(' ');
			}
			
			while(globalStack.isEmpty()==false){
				CharTreeNode temp = globalStack.pop();
				if(temp != null){
					System.out.print(temp.getCchar());
					localStack.push(temp.getLeftChild());
					localStack.push(temp.getRightChild());
					
					if(temp.getLeftChild() != null || temp.getRightChild() != null){
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++){
					System.out.print(' ');
				}
			}
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false){
				globalStack.push(localStack.pop());
			}
		}
		System.out.println(
				"..................................................................................................");
	}
	
	@Override
	public int compareTo(Object o) {
		if (o == null) {
			return -1;
		}
		return weight - ((CharTree) o).weight;
	}
}
