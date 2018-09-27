package com.hlx.algorithm.tree;

public class Tree23 {
	private Tree23Node root = new Tree23Node();
	
	public int find(long key){
		Tree23Node curNode = root;
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
		Tree23Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		
		while(true){
			if(curNode.isLeaf()){                              // if node is leaf
				break;                                                // go insert
			} else {
				// node is not a leaf, so go to lower level
				curNode = getNextChild(curNode, dValue);
			}
		}
		
		if(curNode.isFull()){
			split1(curNode, tempItem);         // 只能分裂叶节点
			//split2(curNode, tempItem, null);   // 可以递归分裂
		} else {
			curNode.insertItem(tempItem);                                 // insert new DataItem
		}
	}
	
	// programming work 10.4
	// thisNode 当前要分裂的节点 ,只能为叶子这点
	// newItem 要插入的数据项
	public void split1(Tree23Node thisNode, DataItem newItem){                          // split the node
		// assumes node is full
		DataItem itemB, itemC;
		Tree23Node parent;
		int itemIndex;
		
		// 分裂当前节点
		// 根据新数据项与当前节点中两个数据项的比较，分三种情况：
		if (thisNode.getItem(0).getdData() > newItem.getdData()) { // 1.新数据项最小
			itemC = thisNode.removeItem();
			itemB = thisNode.removeItem();
			thisNode.insertItem(newItem);
		} else if (thisNode.getItem(1).getdData() < newItem.getdData()) {// 2.新数据项最大
			itemC = newItem;
			itemB = thisNode.removeItem();
		} else {// 3.新数据项在中间
			itemC = thisNode.removeItem();
			itemB = newItem;
		}
		// 新节点
		Tree23Node newRight = new Tree23Node();       // make new node
		newRight.insertItem(itemC);       // item C to newRight

		// 得到父节点
		if (thisNode != root) {
			parent = thisNode.getParent();
		} else {
			root = new Tree23Node();                // make new root
			parent = root;                    // root is our parent
			root.connectChild(0, thisNode);   // connect to parent
		}

		// 中间数据项插入到父节点
		if (parent.isFull()) {
			System.out.println("还未实现父节点分裂！！！");
		} else {
			itemIndex = parent.insertItem(itemB);
			int n = parent.getNumItems();         // total items?
			for (int j = n - 1; j > itemIndex; j--)          // move parent's
			{                                      // connections
				Tree23Node temp = parent.disconnectChild(j); // one child
				parent.connectChild(j + 1, temp);        // to the right
			}
			// connect newRight to parent
			parent.connectChild(itemIndex + 1, newRight);
		}
	}
	
	// programming work 10.5
	// thisNode 当前要分裂的节点
	// newItem 要插入的数据项
	// newNode 上次分裂(子节点分裂)得到的新节点，如果是第一次分裂(叶节点分裂)，则为null
	public void split2(Tree23Node thisNode, DataItem newItem, Tree23Node newNode) {
		// assumes node is full
		DataItem itemB, itemC; // itemB保存中间数据项,itemC保存最大数据项
		Tree23Node parent, child1, child2, newRight;
		int itemIndex;

		// 分裂当前节点
		// 根据新数据项与当前节点中两个数据项的比较，分三种情况：
		if (thisNode.getItem(0).getdData() > newItem.getdData()) { // 1.新数据项最小
			itemC = thisNode.removeItem();
			itemB = thisNode.removeItem();
			thisNode.insertItem(newItem);

			child1 = thisNode.disconnectChild(1);
			child2 = thisNode.disconnectChild(2);
			thisNode.connectChild(1, newNode);

			newRight = new Tree23Node();       // make new node
			newRight.insertItem(itemC);       // item C to newRight
			newRight.connectChild(0, child1);
			newRight.connectChild(1, child2);
		} else if (thisNode.getItem(1).getdData() < newItem.getdData()) { // 2.新数据项最大
			itemC = newItem;
			itemB = thisNode.removeItem();
			child2 = thisNode.disconnectChild(2);

			newRight = new Tree23Node();       // make new node
			newRight.insertItem(itemC);       // item C to newRight
			newRight.connectChild(0, child2);
			newRight.connectChild(1, newNode);
		} else { // 3.新数据项在中间
			itemC = thisNode.removeItem();
			itemB = newItem;
			child2 = thisNode.disconnectChild(2);

			newRight = new Tree23Node();       // make new node
			newRight.insertItem(itemC);       // item C to newRight
			newRight.connectChild(0, newNode);
			newRight.connectChild(1, child2);
		}

		// 得到父节点
		if (thisNode != root) { // 当前节点是非根节点
			parent = thisNode.getParent();
		} else {// 当前节点是根节点
			root = new Tree23Node();                // make new root
			parent = root;                    // root is our parent
			root.connectChild(0, thisNode);   // connect to parent
		}

		// 中间数据项插入到父节点
		if (parent.isFull()) { // 父节点是满，则递归分裂父节点
			split2(parent, itemB, newRight);
		} else { // 父节点不满，直接插入
			itemIndex = parent.insertItem(itemB);
			// 调整相应的子节点
			if (itemIndex == 0) {// 插入到第一个
				parent.connectChild(2, parent.disconnectChild(1));
				parent.connectChild(1, newRight);
			} else { // 插入到第二个
				parent.connectChild(2, newRight);
			}
		}
	}
	
	// get appropriate child of node during search for value
	public Tree23Node getNextChild(Tree23Node theNode, long theValue){
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
	
	private void recDisplayTree(Tree23Node thisNode, int level, int childNumber){
		System.out.print("level=" + level + " child=" + childNumber+ " ");
		thisNode.displayNode();
		
		// call ourselves for each child of this node
		int numItems = thisNode.getNumItems();
		for(int j=0; j<numItems+1; j++){
			Tree23Node nextNode = thisNode.getChild(j);
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
		Tree23Node parent = root;
		Tree23Node current = root;
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
	private void inOrder(Tree23Node root) {
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
		this.root = new Tree23Node();
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		inOrderForSort(array, root, 0);
	}
	
	private int inOrderForSort(long[] array, Tree23Node root, int arrayIndex) {
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
