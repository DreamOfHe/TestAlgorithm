package com.hlx.algorithm.tree;

import java.util.Stack;

public class BinarySearchTree {
	private TreeNode root;            // first node of tree
	
	public BinarySearchTree(){
		root = null;
	}
	
	public TreeNode find(int key){    // find node with given key
		if(root == null){
			return null;
		}
		TreeNode current = root;
		while(current.getId() != key){
			if(key < current.getId()){
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
			if(current == null){      // if no child, didn't find it
				return null;
			}
		}
		return current;
	}
	
	public void insert(int key){
		TreeNode newNode = new TreeNode();
		newNode.setId(key);
		if(root == null){
			root = newNode;
		} else {
			TreeNode current = root;
			TreeNode parent;
			while(true){
				parent = current;
				if(key < current.getId()){     // go left ?
					current = current.getLeftChild();
					if(current == null){
						parent.setLeftChild(newNode);
						return;
					}
				} else {   // go right ?
					current = current.getRightChild();
					if(current == null){
						parent.setRightChild(newNode);
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int key){
		TreeNode current = root;
		TreeNode parent = root;
		boolean isLeftChild = true;
		
		// 1. search for node
		while(current.getId() != key){    
			parent = current;
			if(key < current.getId()){
				isLeftChild = true;
				current = current.getLeftChild();
			} else {
				isLeftChild = false;
				current = current.getRightChild();
			}
			if(current == null){      // if no child, didn't find it
				return false;
			}
		}
		
		// 2.1 if no children, simply delete it
		if(current.getLeftChild()==null && 
				current.getRightChild()==null){
			if(current == root){  // if root, tree is empty
				root = null;
			} else if(isLeftChild){
				parent.setLeftChild(null);  // disconnect from parent
			} else {
				parent.setRightChild(null);
			}
		}
		
		// 2.2 if no right child, replace with left subtree
		else if(current.getRightChild() == null){
			if(current == root){
				root = current.getLeftChild();
			} else if(isLeftChild){
				parent.setLeftChild(current.getLeftChild());
			} else {
				parent.setRightChild(current.getLeftChild());
			}
		}
		
		// 2.3 if no left child, replace with right subtree
		else if(current.getLeftChild() == null){
			if(current == root){
				root = current.getRightChild();
			} else if(isLeftChild){
				parent.setLeftChild(current.getRightChild());
			} else {
				parent.setRightChild(current.getRightChild());
			}
		}
		
		// 2.4 two children, so replace with inorder successor
		else {
			// get successor of node to delete (current)
			TreeNode successor = getSuccessor(current);
			
			// 3.2 connetc parent of current to successor instead
			if(current == root){
				root = successor;
			} else if(isLeftChild){
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
			
			// 3.4 connect successor to current's left child
			successor.setLeftChild(current.getLeftChild());
		}
		
		return true;
	}
	
	
	// returns node with next-highest value after delNode
	// goes to right child, then right child's left descendents
	private TreeNode getSuccessor(TreeNode delNode){
		TreeNode successorParent = delNode;
		TreeNode successor = delNode;
		TreeNode current = delNode.getRightChild();  // go to right child
		
		while(current != null){  // until no more left children
			successorParent = successor;
			successor = current;
			current = current.getLeftChild();  // go to left child
		}
		
		// 3.1 if successor not right child, make connections
		if(successor != delNode.getRightChild()){ 
			successorParent.setLeftChild(successor.getRightChild());
			successor.setRightChild(delNode.getRightChild());
		}
		return successor;
	}
	
	public void traverse(int traverseType){
		switch(traverseType){
		case 1:
			System.out.println("\nPreorder traversal: ");
			preOder(root);
			break;
		case 2:
			//System.out.println("\nInorder traversal: ");
			inOder(root);
			break;
		case 3:
			System.out.println("\nPostorder traversal: ");
			postOder(root);
			break;
		}
		System.out.println("");
	}
	
	private void preOder(TreeNode localRoot){
		if(localRoot != null){
			System.out.print(localRoot.getId() + " ");
			preOder(localRoot.getLeftChild());
			preOder(localRoot.getRightChild());
		}
	}
	
	private void inOder(TreeNode localRoot){
		if(localRoot != null){
			inOder(localRoot.getLeftChild());
			System.out.print(localRoot.getId() + " ");
			inOder(localRoot.getRightChild());
		}
	}
	
	private void postOder(TreeNode localRoot){
		if(localRoot != null){
			postOder(localRoot.getLeftChild());
			postOder(localRoot.getRightChild());
			System.out.print(localRoot.getId() + " ");
		}
	}
	
	public void displayTree(){
		Stack<TreeNode> globalStack = new Stack<TreeNode>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
				"..................................................................................................");
		while(isRowEmpty == false){
			Stack<TreeNode> localStack = new Stack<TreeNode>();
			isRowEmpty = true;
			
			for(int j=0; j<nBlanks; j++){
				System.out.print(' ');
			}
			
			while(globalStack.isEmpty()==false){
				TreeNode temp = globalStack.pop();
				if(temp != null){
					System.out.print(temp.getId());
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
}
