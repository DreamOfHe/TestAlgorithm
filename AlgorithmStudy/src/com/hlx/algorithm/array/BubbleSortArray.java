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
	// ��ż����Ĺ�������
	// ��ʼ���� 4 3 2 1
	// ��1��
	// iΪż���Ƚ� (4,3)��(2,1)��
	// ���Ϊ 3 4 1 2
	// iΪ�����Ƚ� (4,1)��
	// ���Ϊ 3 1 4 2
	// ��2��
	// iΪż���Ƚ� (3,1)��(4,2)��
	// ���Ϊ1 3 2 4
	// iΪ�����Ƚ� (3,2)��
	// ���Ϊ1 2 3 4
	// ��3��
	// iΪż���Ƚ� (1,2)��(3,4)��
	// ���Ϊ1 2 3 4
	// iΪ�����Ƚ�(2,3)
	// ���Ϊ1 2 3 4
	// �˴αȽ�û�н����������������
 
	public void oddEvenSort() {
		boolean change = true;
		while (change) {// �������н���ʱ���������
			change = false;
			for (int i = 0; i < nElems - 1; i += 2) { // iΪż��
				if (array[i] > array[i + 1]) {
					swap(i, i + 1);
					change = true;
				}
			}
			for (int i = 1; i < nElems - 1; i += 2) { // iΪ����
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
