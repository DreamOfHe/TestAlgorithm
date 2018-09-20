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
		for (int i = highPriority; i < nItems - 1; i++) { // ������沿����ǰ��
			queArray[i] = queArray[i + 1];
		}
		nItems--;
		return temp;
	}
	
	// begin programming work 4.4
	// ����һ ������������˳����ʾ
	public void display() {
		System.out.print("����Ϊ��");
		for (int i = 0; i < nItems; i++) {
			System.out.print(queArray[i] + " ");
		}
		System.out.println();
	}

	// ������������������ȼ�˳����ʾ
	public void display1() {
		long[] temp = new long[nItems];// ��ʱ��
		System.arraycopy(queArray, 0, temp, 0, nItems); // ���Ƶ���ʱ��
		int out, in;
		for (out = 1; out < nItems; out++) { // ��������
			in = out;
			long t = temp[out];
			while (in > 0 && t < temp[in - 1]) {
				temp[in] = temp[in - 1];
				in--;
			}
			temp[in] = t;
		}
		System.out.print("����Ϊ��");
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
