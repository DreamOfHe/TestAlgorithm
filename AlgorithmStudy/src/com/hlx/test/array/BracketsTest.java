package com.hlx.test.array;

import java.io.IOException;

import com.hlx.algorithm.array.BracketChecker;
import com.hlx.common.MyMethod;

public class BracketsTest {
	public static void main(String[] args) throws IOException {
		String input;
		while(true){
			System.out.print("Enter string containing delimiters: ");
			System.out.flush();
			input = MyMethod.getString();
			if(input.equals("")){
				break;
			}
			BracketChecker theChecker = new BracketChecker(input);
			theChecker.check();
		}
	}
}
