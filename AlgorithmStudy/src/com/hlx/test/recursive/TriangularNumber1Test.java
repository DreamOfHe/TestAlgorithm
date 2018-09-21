package com.hlx.test.recursive;

import java.io.IOException;

import com.hlx.common.MyMethod;

public class TriangularNumber1Test {
	
	private static int theNumber;
	
	public static void main(String[] args) throws IOException{
		System.out.print("Enter a number: ");
		theNumber = MyMethod.getInt();
		int theAnswer = triangle(theNumber);
		System.out.println("Triangle=" + theAnswer);
	}
	
	public static int triangle(int n){
		System.out.println("Entering: n=" + n);
		if(n == 1){
			System.out.println("Returning 1");
			return 1;
		} else {
			int temp = n + triangle(n-1);
			System.out.println("Returning " + temp);
			return temp;
		}
	}
	
}
