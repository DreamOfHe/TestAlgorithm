package com.hlx.test.recursive;

import java.io.IOException;

import com.hlx.algorithm.array.StackX;
import com.hlx.common.MyMethod;

public class TriangularNumber2Test {
	
	private static int theNumber;
	private static int theAnswer;
	private static StackX theStack;
	
	public static void main(String[] args) throws IOException{
		System.out.print("Enter a number: ");
		theNumber = MyMethod.getInt();
		stackTriangle();
		System.out.println("Triangle=" + theAnswer);
	}
	
	public static void stackTriangle(){
		theStack = new StackX(10000);
		theAnswer = 0;
		
		while(theNumber > 0){
			theStack.push(theNumber);
			--theNumber;
		}
		
		while(!theStack.isEmpty()){
			int newN = (Integer) theStack.pop();
			theAnswer += newN;
		}
	}
	
}
