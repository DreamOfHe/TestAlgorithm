package com.hlx.test;

import java.io.IOException;

import com.hlx.array.ParsePostfix;
import com.hlx.common.MyMethod;

public class ParsePostfixTest {
	public static void main(String[] args) throws IOException {
		String input;
		int output;
		while(true){
			System.out.print("Enter postfix: ");
			System.out.flush();
			input = MyMethod.getString();
			if(input.equals("")){
				break;	
			}
			
			ParsePostfix aParser = new ParsePostfix(input);
			output = aParser.doParse();
			System.out.println("Evaluates to " + output + "\n");
		}
	}
}
