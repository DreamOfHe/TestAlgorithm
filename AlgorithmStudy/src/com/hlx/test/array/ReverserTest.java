package com.hlx.test.array;

import java.io.IOException;

import com.hlx.array.Reverser;
import com.hlx.common.MyMethod;

public class ReverserTest {

	public static void main(String[] args) throws IOException {

		String input, output;
		while(true){
			System.out.print("Enter a string: ");
			System.out.flush();
			input = MyMethod.getString();
			if(input.equals("")){
				break;	
			}
			Reverser rever = new Reverser(input);
			output = rever.doRev();
			System.out.println("Reversed: " + output);
		}
	}
}
