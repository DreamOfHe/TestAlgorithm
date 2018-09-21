package com.hlx.test.recursive;

import java.io.IOException;

import com.hlx.common.MyMethod;

public class MultTest { // programming work 6.1
	
	private static int x;
	private static int y;
	
	public static void main(String[] args) throws IOException {
		
		while(true){
			
			System.out.print("Enter x: ");
			x = MyMethod.getInt();
			System.out.print("Enter y: ");
			y = MyMethod.getInt();
			int theAnswer = mult(x, y);
			
			System.out.println("theAnswer=" + theAnswer);
		}
	}
	
	public static int mult(int x, int y){
		
		if(y==1){
			return x;
		}
		
		return x + mult(x, y-1);
	}
}
