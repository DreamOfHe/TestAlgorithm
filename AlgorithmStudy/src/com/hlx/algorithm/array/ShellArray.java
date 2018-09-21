package com.hlx.algorithm.array;

public class ShellArray {

	private long[] array;
	private int nElems;
	
	public ShellArray(int max){
		array = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		array[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(int j=0; j<nElems; j++){
			System.out.print(array[j] + " ");
		}
		System.out.println("");
	}
	
	public void shellSort(){
		int inner, outer;
		long temp;
		
		int h = 1;
		while(h <= nElems / 3){
			h = h*3 + 1;    // (1, 4, 13, 40, 121 ...)
		}
		
		while(h>0){  // decreasing h, until h = 1
			
			for(outer=h; outer<nElems; outer++){
				temp = array[outer];
				inner = outer;
				
				while(inner > h-1 && array[inner-h] >= temp){
					array[inner] = array[inner-h];
					inner -= h;
				}
				array[inner] = temp;
			}
			h = (h-1)/3;
		}
	}
}
