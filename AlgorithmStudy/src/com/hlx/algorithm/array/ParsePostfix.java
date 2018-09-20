package com.hlx.algorithm.array;

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
}
