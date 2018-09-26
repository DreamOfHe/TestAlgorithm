package com.hlx.algorithm.tree;

public class Tree234Node {
	private static final int ORDER = 4;
	private int numItems;
	private Tree234Node parent;
	private Tree234Node childArray[] = new Tree234Node[ORDER];
	private DataItem itemArray[] = new DataItem[ORDER-1];
	
	// connect child to this node
	public void connectChild(int childNum, Tree234Node child){
		childArray[childNum] = child;
		if(child != null){
			child.parent = this;
		}
	}
	
	// disconnect child from this node, return it
	public Tree234Node disconnectChild(int childNum){
		Tree234Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}
	
	public Tree234Node getChild(int childNum){
		return childArray[childNum];
	}
	
	public Tree234Node getParent(){
		return parent;
	}
	
	public boolean isLeaf(){
		return (childArray[0] == null) ? true : false;
	}
	
	public int getNumItems(){
		return numItems;
	}
	
	public DataItem getItem(int index){   // get DataItem at index
		return itemArray[index];
	}
	
	public boolean isFull(){
		return (numItems == ORDER - 1) ? true : false;
	}
	
	public int findItem(long key){     // return index of item (within node)
		for(int j=0; j<ORDER-1; j++){  // if found, otherwise return -1
			if(itemArray[j] == null){
				break;
			} else if (itemArray[j].getdData() == key){
				return j;
			}
		}
		return -1;
	}
	
	public int insertItem(DataItem newItem){
		// assumes node is not null
		numItems++;                                     // will add new item
		long newKey = newItem.getdData();               // key of new item
		
		for(int j=ORDER-2; j>=0; j--){                  // start on right, examine items
			if(itemArray[j] == null){        		    // if item null, go left one cell
				continue;
			} else {                        			// not null, get its key
				long itsKey = itemArray[j].getdData();
				if(newKey < itsKey){          			// if it's bigger
					itemArray[j+1] = itemArray[j];      // shift it right
				} else {
					itemArray[j+1] = newItem;           // insert new item
					return j+1;                         // return index to new item
				}
			}
		}                                               // shifted all items
		itemArray[0] = newItem;                         // insert new item
		return 0;
	}
	
	public DataItem removeItem(){                       // remove largest item
		// assumes node not empty
		DataItem temp = itemArray[numItems-1];          // save item
		itemArray[numItems-1] = null;                   // disconnect it
		numItems--;                                     // one less item
		return temp;                                    // return item
	}
	
	public void displayNode(){                          // format "/24/56/74/"
		for(int j=0; j<numItems; j++){
			itemArray[j].displayItem();
		}
		System.out.println("/");
	}
}
