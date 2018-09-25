package com.hlx.algorithm.array;

import com.hlx.algorithm.tree.CharTree;
import com.hlx.algorithm.tree.CharTreeNode;

public class ParsePostfix {
	private StackX theStack;
	private String input;
	
	public ParsePostfix(String s){
		input = s;
		theStack = new StackX(input.length());
	}
	
	public int doParse(){
		char ch;
		int j;
		int num1, num2, interAns;
		
		for(j=0; j<input.length(); j++){
			ch = input.charAt(j);
			theStack.displayStack("" + ch + " ");
			if(ch >= '0' && ch <= '9'){
				theStack.push((int)(ch - '0'));
			} else {
				num2 = (Integer) theStack.pop();
				num1 = (Integer) theStack.pop();
				switch(ch){
				case '+':
					interAns = num1 + num2;
					break;
				case '-':
					interAns = num1 - num2;
					break;
				case '*':
					interAns = num1 * num2;
					break;
				case '/':
					interAns = num1 / num2;
					break;
				default:
					interAns = 0;
				}
				theStack.push(interAns);
			}
		}

		return (Integer) theStack.pop();
	}
	
	// programming work 8.4
	public CharTree doParseByTree(){
		theStack = new StackX(20);
		char ch;
		int j;
		
		CharTree num1, num2;
		
		for(j=0; j<input.length(); j++){
			ch = input.charAt(j);
			theStack.displayStack("" + ch + " ");
			if(ch >= '0' && ch <= '9'){
				CharTree temp = new CharTree();
				temp.setRoot(new CharTreeNode(ch));
				theStack.push(temp);
			} else {
				num2 = (CharTree) theStack.pop();
				num1 = (CharTree) theStack.pop();
				CharTree temp;
				switch(ch){
				case '+':
					temp = new CharTree();
					temp.setRoot(new CharTreeNode('+'));
					temp.getRoot().setLeftChild(num1.getRoot());
					temp.getRoot().setRightChild(num2.getRoot());
					theStack.push(temp);
					break;
				case '-':
					temp = new CharTree();
					temp.setRoot(new CharTreeNode('-'));
					temp.getRoot().setLeftChild(num1.getRoot());
					temp.getRoot().setRightChild(num2.getRoot());
					theStack.push(temp);
					break;
				case '*':
					temp = new CharTree();
					temp.setRoot(new CharTreeNode('*'));
					temp.getRoot().setLeftChild(num1.getRoot());
					temp.getRoot().setRightChild(num2.getRoot());
					theStack.push(temp);
					break;
				case '/':
					temp = new CharTree();
					temp.setRoot(new CharTreeNode('/'));
					temp.getRoot().setLeftChild(num1.getRoot());
					temp.getRoot().setRightChild(num2.getRoot());
					theStack.push(temp);
					break;
				}
			}
		}
		
		return (CharTree) theStack.pop();
	}
}
