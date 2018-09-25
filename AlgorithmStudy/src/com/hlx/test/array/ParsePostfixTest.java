package com.hlx.test.array;

import java.io.IOException;

import com.hlx.algorithm.array.ParsePostfix;
import com.hlx.algorithm.tree.CharTree;
import com.hlx.common.MyMethod;

public class ParsePostfixTest {
	
	public static void test_1() throws IOException{
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
	
	// programming work 8.4
	public static void test_2() throws IOException{
		String input;
		CharTree output;
		while(true){
			System.out.print("Enter postfix: ");
			System.out.flush();
			input = MyMethod.getString();
			if(input.equals("")){
				break;	
			}
			
			ParsePostfix aParser = new ParsePostfix(input);
			output = aParser.doParseByTree();
			
			output.displayTree();
			
			output.traverse(1);
			output.traverse(2);
			output.traverse(3);
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		//test_1();
		test_2();
	}
}
