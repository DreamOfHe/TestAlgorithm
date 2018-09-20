package com.hlx.algorithm.array;

public class BubbleSortArray {

	private long[] array;
	private int nElems;
	
	public BubbleSortArray(int max){
		array = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		array[nElems] = value;
		nElems++;
	}
	
	public int find(long value){
		int j;
		for(j=0; j<nElems ; j++){
			if(array[j] == value){
				break;
			}
		}
		return (j==nElems) ? -1 : j;
	}
	
	public int delete(long value){
		int j = find(value);
		if(j != -1){
			for(int k=j; k<nElems-1; k++){
				array[k] = array[k+1];
			}
			nElems--;
		}
		return j;
	}
	
	public void display(){
		for(int j=0; j<nElems; j++){
			System.out.print(array[j] + " ");
		}
		System.out.println("");
	}
	
	public void bubbleSort(){
		int in, out;
		for(out=nElems-1; out>1; out--){
			for(in=0; in<out; in++){
				if(array[in]>array[in+1]){
					swap(in, in+1);
				}
			}
		}
	}
	
	// programming work 3.4
	// 奇偶排序的过程如下
	// 初始序列 4 3 2 1
	// 第1次
	// i为偶数比较 (4,3)和(2,1)对
	// 结果为 3 4 1 2
	// i为奇数比较 (4,1)对
	// 结果为 3 1 4 2
	// 第2次
	// i为偶数比较 (3,1)和(4,2)对
	// 结果为1 3 2 4
	// i为奇数比较 (3,2)对
	// 结果为1 2 3 4
	// 第3次
	// i为偶数比较 (1,2)和(3,4)对
	// 结果为1 2 3 4
	// i为奇数比较(2,3)
	// 结果为1 2 3 4
	// 此次比较没有交换，所以排序结束
 
	public void oddEvenSort() {
		boolean change = true;
		while (change) {// 当不再有交换时，排序完成
			change = false;
			for (int i = 0; i < nElems - 1; i += 2) { // i为偶数
				if (array[i] > array[i + 1]) {
					swap(i, i + 1);
					change = true;
				}
			}
			for (int i = 1; i < nElems - 1; i += 2) { // i为奇数
				if (array[i] > array[i + 1]) {
					swap(i, i + 1);
					change = true;
				}
			}
		}
	}

	
	private void swap(int one, int two){
		long temp = array[one];
		array[one] = array[two];
		array[two] = temp;
	}
	
	public void doubleSidebubbleSort(){  // programming work 3.1
		int in, out, min;
		for(min=0, out=nElems-1; out>min; out--, min++){
			for(in=min; in<out; in++){
				if(array[in]>array[in+1]){
					swap(in, in+1);
				}
			}
			for(in=out-1; in>0; in--){
				if(array[in]<array[in-1]){
					swap(in, in-1);
				}
			}
		}
	}
}
