package com.hlx.test.recursive;

import java.io.IOException;

import com.hlx.common.MyMethod;

public class FactorialTest {
	
	private static int theNumber;
	
	public static void main(String[] args) throws IOException{
		System.out.print("Enter a number: ");
		theNumber = MyMethod.getInt();
		int theAnswer = factorial(theNumber);
		System.out.println("Factorial=" + theAnswer);
	}
	
	public static int factorial(int n){
		System.out.println("Entering: n=" + n);
		if(n == 0){
			System.out.println("Returning 1");
			return 1;
		} else {
			int temp = n * factorial(n-1);
			System.out.println("Returning " + temp);
			return temp;
		}
	}
	
}
