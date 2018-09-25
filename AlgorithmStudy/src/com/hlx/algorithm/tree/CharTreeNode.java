package com.hlx.algorithm.tree;

public class CharTreeNode {
	private char cchar;                    // data item (key)
	private CharTreeNode leftChild;        // this node's left child
	private CharTreeNode rightChild;       // this node's right child
	
	public CharTreeNode(){
		
	}
	
	public CharTreeNode(char c){
		cchar = c;
	}
	
	public char getCchar() {
		return cchar;
	}

	public void setCchar(char cchar) {
		this.cchar = cchar;
	}

	public CharTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(CharTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public CharTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(CharTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public void displayNode(){        // display ourself
		System.out.print("{" + cchar + "}");
	}
}
