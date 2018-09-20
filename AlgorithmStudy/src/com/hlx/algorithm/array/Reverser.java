package com.hlx.algorithm.array;

public class Reverser {
	private String input;
	private String output;
	
	public Reverser(String in){
		input = in;
	}
	
	public String doRev(){
		int stackSize = input.length();
		StackX stack = new StackX(stackSize);
		for(int j=0; j<input.length(); j++){
			char ch = input.charAt(j);
			stack.push(ch);
		}
		
		output = "";
		while(!stack.isEmpty()){
			char ch = (Character) stack.pop();
			output = output + ch;
		}
		return output;
	}
}
