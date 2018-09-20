package com.hlx.algorithm.array;

public class InfixToPostfix {
	private StackX theStack;
	private String input;
	private String output="";
	
	public InfixToPostfix(String in){
		input = in;
		int stackSize = input.length();
		theStack = new StackX(stackSize);
	}
	
	public String doTrans(){ // do translation to postfix
		for(int j=0; j<input.length(); j++){
			char ch = input.charAt(j);
			theStack.displayStack("For " + ch + " ");
			switch(ch){
			case '+':  
			case '-':
				gotOper(ch, 1); // got pop operators
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				theStack.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				output = output + ch;
				break;
			}
			System.out.print("    output is ["+ output +"]\n");
		}
		
		while(!theStack.isEmpty()){  // pop remaining opers
			theStack.displayStack("While ");
			output = output + theStack.pop();
		}
		theStack.displayStack("End  ");
		
		return output;
	}
	
	public void gotOper(char opThis, int prec1){ // got operator from input
		while(!theStack.isEmpty()){
			char opTop = (Character) theStack.pop();
			if(opTop == '('){
				theStack.push(opTop);
				break;
			} else {
				int prec2;  // precedence of new op
				
				if(opTop=='+' || opTop=='-'){
					prec2 = 1;
				} else {
					prec2 = 2;
				}
				
				if(prec2 < prec1){
					theStack.push(opTop);
					break;
				} else {
					output = output + opTop;
				}
			}
		}
		theStack.push(opThis);
	}
	
	public void gotParen(char ch){  // got right paren from input
		while(!theStack.isEmpty()){
			char chx = (Character) theStack.pop();
			if(chx == '('){
				break;
			} else {
				output = output + chx;
			}
		}
	}
}
