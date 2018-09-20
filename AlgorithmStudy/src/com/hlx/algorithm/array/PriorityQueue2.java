package com.hlx.algorithm.array;

public class PriorityQueue2 {
	private int maxSize;
	private long[] queArray;
	private int nItems;
	
	public PriorityQueue2(int max){
		maxSize = max;
		queArray = new long[maxSize];
		nItems = 0;
	}
	
	public void insert(long item){ // programming work 4.4
		queArray[nItems++] = item;
	}
	
	public long remove(){ // programming work 4.4, remove minimum item
		int highPriority = 0;
		for (int i = 1; i < nItems; i++) {
			if (queArray[i] < queArray[highPriority]) {
				highPriority = i;
			}
		}
		long temp = queArray[highPriority];
		for (int i = highPriority; i < nItems - 1; i++) { // 数组后面部份往前移
			queArray[i] = queArray[i + 1];
		}
		nItems--;
		return temp;
	}
	
	// begin programming work 4.4
	// 方法一 ：如果按插入的顺序显示
	public void display() {
		System.out.print("队列为：");
		for (int i = 0; i < nItems; i++) {
			System.out.print(queArray[i] + " ");
		}
		System.out.println();
	}

	// 方法二：如果按按优先级顺序显示
	public void display1() {
		long[] temp = new long[nItems];// 临时表
		System.arraycopy(queArray, 0, temp, 0, nItems); // 复制到临时表
		int out, in;
		for (out = 1; out < nItems; out++) { // 插入排序
			in = out;
			long t = temp[out];
			while (in > 0 && t < temp[in - 1]) {
				temp[in] = temp[in - 1];
				in--;
			}
			temp[in] = t;
		}
		System.out.print("队列为：");
		for (int i = 0; i < nItems; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}
	// end programming work 4.4
	
	public long peekMin(){
		return queArray[nItems-1];
	}
	
	public boolean isEmpty(){
		return (nItems==0);
	}
	
	public boolean isFull(){
		return (nItems==maxSize);
	}
}
