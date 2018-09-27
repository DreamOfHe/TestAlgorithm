package com.hlx.algorithm.tree;

public class Tree234 {
	private Tree234Node root = new Tree234Node();
	
	public int find(long key){
		Tree234Node curNode = root;
		int childNumber;
		while(true){
			if((childNumber=curNode.findItem(key))!=-1){
				return childNumber;                                   // found it
			} else if(curNode.isLeaf()){
				return -1;                                            // can't find it
			} else {                                                  // search deeper
				curNode = getNextChild(curNode, key);
			}
		}
	}
	
	// insert a DataItem
	public void insert(long dValue){
		Tree234Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		
		while(true){
			if(curNode.isFull()){                                     // if node full
				split(curNode);                                       // split it
				curNode = curNode.getParent();                        // back up
				curNode = getNextChild(curNode, dValue);              // search once
			} else if(curNode.isLeaf()){                              // if node is leaf
				break;                                                // go insert
			} else {
				// node is not full, not a leaf; so go to lower level
				curNode = getNextChild(curNode, dValue);
			}
		}
		curNode.insertItem(tempItem);                                 // insert new DataItem
	}
	
	public void split(Tree234Node thisNode){                          // split the node
		// assumes node is full
		DataItem itemB, itemC;
		Tree234Node parent, child2, child3;
		int itemIndex;
		
		itemC = thisNode.removeItem();                                // remove items from
		itemB = thisNode.removeItem();                                // this node
		
		child2 = thisNode.disconnectChild(2);                         // remove children from
		child3 = thisNode.disconnectChild(3);                         // this node
		
		Tree234Node newRight = new Tree234Node();
		
		if(thisNode == root){
			root = new Tree234Node();
			parent = root;                                            // root is our parent
			root.connectChild(0, thisNode);                           // connect parent
		} else {
			parent = thisNode.getParent();                            // get parent
		}
		
		// deal with parent
		itemIndex = parent.insertItem(itemB);                         // item B to parent
		int n = parent.getNumItems();
		
		// move parent's connections one child to the right
		for(int j=n-1; j>itemIndex; j--){
			Tree234Node temp = parent.disconnectChild(j);
			parent.connectChild(j+1, temp);
		}
		
		// connect newRight to parent
		parent.connectChild(itemIndex+1, newRight);
		
		// deal with newRight
		newRight.insertItem(itemC);                                   // item C to newRight
		newRight.connectChild(0, child2);                             // connect to 0 and 1
		newRight.connectChild(1, child3);                             // on newRight
	}
	
	// get appropriate child of node during search for value
	public Tree234Node getNextChild(Tree234Node theNode, long theValue){
		int j;
		// assumes node is not empty, not full, not a leaf
		int numItems = theNode.getNumItems();
		for(j=0; j<numItems; j++){
			if(theValue < theNode.getItem(j).getdData()){
				return theNode.getChild(j);                           // return left child
			}
		}
		return theNode.getChild(j);                                   // return right child
	}
	
	public void displayTree(){
		recDisplayTree(root, 0, 0);
	}
	
	private void recDisplayTree(Tree234Node thisNode, int level, int childNumber){
		System.out.print("level=" + level + " child=" + childNumber+ " ");
		thisNode.displayNode();
		
		// call ourselves for each child of this node
		int numItems = thisNode.getNumItems();
		for(int j=0; j<numItems+1; j++){
			Tree234Node nextNode = thisNode.getChild(j);
			if(nextNode != null){
				recDisplayTree(nextNode, level+1, j);
			} else {
				return;
			}
		}
	}
	
	// programming work 10.1
	// 这里没有考虑空树的情况，调用前确保树不为空
	public long getMinValue() {
		Tree234Node parent = root;
		Tree234Node current = root;
		while (current != null) {
			parent = current;
			current = current.getChild(0);
		}
		return parent.getItem(0).getdData();
	}
	
	public void traverse(int traverseType) {
		switch (traverseType) {
		case 1:
			System.out.print("\nPreorder traversal: ");
			// preOrder(root);
			break;
		case 2:
			System.out.print("\nInorder traversal: ");
			inOrder(root);
			break;
		case 3:
			System.out.print("\nPostorder traversal: ");
			// postOrder(root);
			break;
		}
		System.out.println();
	}
	
	// programming work 10.2
	private void inOrder(Tree234Node root) {
		if (root == null) {
			return;
		}
		int i = 0;
		for (; i < root.getNumItems(); i++) {
			inOrder(root.getChild(i));
			System.out.print(root.getItem(i).getdData() + " ");
		}
		if (i != 0) {
			inOrder(root.getChild(i));
		}
	}
	
	// programming work 10.3
	public void sort(long[] array) {
		this.root = new Tree234Node();
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		inOrderForSort(array, root, 0);
	}
	
	private int inOrderForSort(long[] array, Tree234Node root, int arrayIndex) {
		if (root == null) {
			return arrayIndex;
		}
		int i = 0;
		for (; i < root.getNumItems(); i++) {
			arrayIndex = inOrderForSort(array, root.getChild(i), arrayIndex);
			array[arrayIndex++] = root.getItem(i).getdData(); // arrayIndex只在这里增加
		}
		if (i != 0) {
			arrayIndex = inOrderForSort(array, root.getChild(i), arrayIndex);
		}
		return arrayIndex;
	}
}
