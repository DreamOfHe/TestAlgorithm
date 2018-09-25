package com.hlx.test.tree;

import java.io.IOException;

import com.hlx.algorithm.tree.CharTree;
import com.hlx.algorithm.tree.CharTreeNode;
import com.hlx.common.MyMethod;

public class CharTreeTest {
	
	// programming work 8.1
	public static void work_8_1() throws IOException{
		System.out.println("请输入至少字符串（至少两个字符）:");
		String str = MyMethod.getString();
		CharTree[] array = new CharTree[str.length()];
		
		for(int i=0; i<str.length(); i++){ // 建立单节点树数组
			CharTree temp = new CharTree();
			temp.setRoot(new CharTreeNode(str.charAt(i)));
			array[i] = temp;
		}
		
		for(int i=1; i<str.length(); i++){
			CharTree temp = new CharTree();
			temp.setRoot(new CharTreeNode('+'));
			temp.getRoot().setLeftChild(array[i-1].getRoot());
			temp.getRoot().setRightChild(array[i].getRoot());
			array[i] = temp;
		}
		
		CharTree lastTree = array[str.length()-1];
		lastTree.displayTree();
	}
	
	// programming work 8.2 method 1
	public static void work_8_2_1() throws IOException{
		System.out.println("请输入至少字符串（至少两个字符）:");
		String str = MyMethod.getString();
		CharTree[] array = new CharTree[str.length()];
		for (int i = 0; i < array.length; i++) {// 建立单节点树数组
			CharTree temp = new CharTree();
			temp.setRoot(new CharTreeNode(str.charAt(i)));
			array[i] = temp;
		}

		CharTree[] tempArray;
		while (array.length > 1) {
			tempArray = new CharTree[(array.length - 1) / 2 + 1];
			int j = -1;
			int i = 0;
			for (; i + 1 < array.length; i += 2) {
				CharTree temp = new CharTree();
				temp.setRoot(new CharTreeNode('+'));
				temp.getRoot().setLeftChild(array[i].getRoot());
				temp.getRoot().setRightChild(array[i + 1].getRoot());
				tempArray[++j] = temp;
			}
			if (i < array.length) {
				CharTree temp = new CharTree();
				temp.setRoot(new CharTreeNode('+'));
				temp.getRoot().setLeftChild(array[array.length - 1].getRoot());
				tempArray[++j] = temp;
				// tempArray[++j] = array[i];
			}
			array = tempArray;
		}
		CharTree lastTree = array[array.length - 1];
		lastTree.displayTree();
	}
	
	// programming work 8.2 method 2
	public static void work_8_2_2() throws IOException{
		System.out.println("请输入至少字符串（至少两个字符）:");
		String str = MyMethod.getString();
		CharTree[] array = new CharTree[str.length()];
		for (int i = 0; i < array.length; i++) {// 建立单节点树数组
			CharTree temp = new CharTree();
			temp.setRoot(new CharTreeNode(str.charAt(i)));
			array[i] = temp;
		}

		CharTree lastTree = connectTree_1(array, 0, array.length-1);
		lastTree.displayTree();
	}
	
	private static CharTree connectTree_1(CharTree[] array, int left, int right){
		if(left == right){
			return array[left];
		} else {
			CharTree tempTree = new CharTree();
			tempTree.setRoot(new CharTreeNode('+'));
			tempTree.getRoot().setLeftChild(connectTree_1(array, left, (right+left)/2).getRoot());
			tempTree.getRoot().setRightChild(connectTree_1(array, (right+left)/2 + 1, right).getRoot());
			return tempTree;
		}
	}
	
	// programming work 8.3
	public static void work_8_3() throws IOException{
		System.out.println("请输入至少字符串（至少两个字符）:");
		String str = MyMethod.getString();
		CharTree[] array = new CharTree[str.length()];
		for (int i = 0; i < array.length; i++) {// 建立单节点树数组
			CharTree temp = new CharTree();
			temp.setRoot(new CharTreeNode(str.charAt(i)));
			array[i] = temp;
		}

		CharTree lastTree = connectTree_2(array, 0);
		lastTree.displayTree();
	}
	
	private static CharTree connectTree_2(CharTree[] array, int index){
		if(index * 2 + 1 > array.length - 1){  // 没有子树
			return array[index];
		} else if (index * 2 + 2 > array.length - 1){ // 有左子树
			CharTree temp = array[index];
			temp.getRoot().setLeftChild(connectTree_2(array, index*2 + 1).getRoot());
			return temp;
		} else { // 有左右子树
			CharTree temp = array[index];
			temp.getRoot().setLeftChild(connectTree_2(array, index*2 + 1).getRoot());
			temp.getRoot().setRightChild(connectTree_2(array, index*2 + 2).getRoot());
			return temp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		//work_8_1();
		//work_8_2_1();
		//work_8_2_2();
		work_8_3();
	}
}
