package com.hlx.test.array;

import com.hlx.algorithm.array.ShellArray;

public class ShellArrayTest {

	public static void main(String[] args){
		int maxSize = 20;
		ShellArray arr = new ShellArray(maxSize);
		
		for(int j=0; j<maxSize; j++){
			long n = (int)(Math.random()*99);
			arr.insert(n);
		}
	
		arr.display();
		arr.shellSort();
		arr.display();
	}
}
