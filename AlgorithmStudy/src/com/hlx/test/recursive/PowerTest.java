package com.hlx.test.recursive;

import java.io.IOException;

import com.hlx.common.MyMethod;

public class PowerTest {
	
	private static int x;
	private static int y;
	
	public static void main(String[] args) throws IOException{

		while(true){
			
			System.out.print("Enter x: ");
			x = MyMethod.getInt();
			System.out.print("Enter y: ");
			y = MyMethod.getInt();
			int theAnswer1 = power1(x, y);
			int theAnswer2 = power2(x, y);
			
			System.out.println("theAnswer1=" + theAnswer1);
			System.out.println("theAnswer2=" + theAnswer2);
		}

	}
	
	public static int power1(int x, int y){
		if(y == 1){
			return x;
		} else {
			int temp = x * power1(x, y-1);
			return temp;
		}
	}
	
	public static int power2(int x, int y){ // programming work 6.3
		if(y == 1){
			return x;
		} else {
			
			int temp;
			if(y % 2 == 0){
				temp = power2(x*x, y/2);
			} else {
				temp = power2(x*x, y/2) * x;  // 返回过程中，如果  y 是一个奇数，那么就多乘以一个 x
			}
			
			return temp;
		}
	}
	
}
