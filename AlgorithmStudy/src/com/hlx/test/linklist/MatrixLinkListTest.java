package com.hlx.test.linklist;

import com.hlx.algorithm.linklist.MatrixLinkList;

public class MatrixLinkListTest {
	public static void main(String[] args) {
		
		MatrixLinkList list = new MatrixLinkList(5, 5);
		
		list.display();
		System.out.println("------------");
		
		list.addRow(1);
		list.addColumn(1);
		list.deleteColumn(1);
		list.deleteRow(1);
		list.insert(1, 1, 5);
		list.insert(2, 2, 6);
		list.insert(3, 3, 7);
		list.insert(4, 4, 8);
		list.insert(5, 5, 9);
		list.display();
	}
}
