package com.hlx.algorithm.hash;

import com.hlx.algorithm.tree.BinarySearchTree;
import com.hlx.algorithm.tree.TreeNode;

public class HashTree {
	private BinarySearchTree[] hashArray;
	private int arraySize;
	
	public HashTree(int size){
		arraySize = size;
		hashArray = new BinarySearchTree[arraySize];
		
		for(int j=0; j<arraySize; j++){
			hashArray[j] = new BinarySearchTree();
		}
	}
	
	public int hashFunc(int key){
		return key % arraySize;
	}
	
	public void displayTable(){
		System.out.print("Table: \n");
		for(int j=0; j<arraySize; j++){
			System.out.print(j + ". ");
			hashArray[j].traverse(2);
		}
		System.out.println("");
	}

	public void insert(int key){
		int hashVal = hashFunc(key);
		if(this.find(key) != null){
			return;
		}
		hashArray[hashVal].insert(key);
	}
	
	public void delete(int key){
		int hashVal = hashFunc(key);
		hashArray[hashVal].delete(key);
	}
	
	public TreeNode find(int key){
		int hashVal = hashFunc(key);
		TreeNode theNode = hashArray[hashVal].find(key);
		return theNode;
	}
}
