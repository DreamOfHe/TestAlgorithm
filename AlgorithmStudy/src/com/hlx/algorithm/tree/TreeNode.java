package com.hlx.algorithm.tree;

public class TreeNode {
	private int id;                    // data item (key)
	private TreeNode leftChild;        // this node's left child
	private TreeNode rightChild;       // this node's right child
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public void displayNode(){        // display ourself
		System.out.print("{");
		System.out.print(id);
		System.out.print("}");
	}
}
