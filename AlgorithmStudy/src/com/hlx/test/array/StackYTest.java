package com.hlx.test.array;

import com.hlx.array.StackY;

public class StackYTest {
	public static void main(String[] args) {
		StackY stack = new StackY(10);
		stack.push('a');
		stack.push('b');
		stack.push('c');
		stack.push('d');
		stack.push('e');
		stack.push('f');
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println("");
	}
}
