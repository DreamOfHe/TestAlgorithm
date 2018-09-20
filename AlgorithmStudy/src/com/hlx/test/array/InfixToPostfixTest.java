package com.hlx.test.array;

import java.io.IOException;

import com.hlx.algorithm.array.InfixToPostfix;
import com.hlx.common.MyMethod;

public class InfixToPostfixTest {
	public static void main(String[] args) throws IOException {
		String input, output;
		while(true){
			System.out.print("Enter infix: ");
			System.out.flush();
			input = MyMethod.getString();
			if(input.equals("")){
				break;	
			}
			
			InfixToPostfix theTrans = new InfixToPostfix(input);
			output = theTrans.doTrans();
			System.out.println("Postfix is " + output + "\n");
		}
	}
}
