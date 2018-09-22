package com.hlx.test.linklist;

import com.hlx.algorithm.linklist.CircleList;

public class RadixSortTest {  // programming work 7.5
	// ==============================================
	// ���������㷨
	// ==============================================
	// ��������:
	// ������ 8 12 22 15 20 7 25 18 212 ����Ϊ10
	// ���Ȱ���λ����
	// ����� (20)(12 22 212)(15 25)(7)(8 18)
	// Ȼ��ʮλ����
	// ����� (7 8) (12 212 15 18) (20 22 25)
	// Ȼ�󰴰�λ����
	// ����� (7 8 12 15 18 20 22 25) 212
	// �������
	// ==============================================
	// �˷����������ݴ�Ԫ��
	// ==============================================
	public static void main(String[] args) {
		int[] array = { 3, 2, 3, 2, 5, 333, 45566, 2345678, 78, 990, 12, 432, 56 };
		radixSort(array, 10, 7);
		for (int i = 0; i < array.length; i++) {
			System.out.print("  " + array[i]);
		}
	}
	
	private static void radixSort(int[] array, int radix, int distance) {
		// array Ϊ����������
		// radix �������
		// distance ��������Ԫ�ص�λ��  //���ڻ��������Ԫ�ص�λ��
		int length = array.length;
		CircleList[] temp = new CircleList[radix];// �����ݴ�Ԫ��
		for (int x = 0; x < radix; x++) { // ��ʼ������
			temp[x] = new CircleList();
		}
		int divide = 1;

		for (int i = 0; i < distance; i++) {
			// ���˾������û�������ʵ�ֻ���������ص���������Щ����
			for (int j = 0; j < length; j++) { // ����Ԫ����Ӧλ�ϵ����ַ���
				int tempindex = (int) (array[j] / divide) % radix;
				temp[tempindex].insert(array[j]);
			}
			int l = 0;
			for (int k = 0; k < temp.length; k++) { // �ѷֺ����Ԫ�ظ��ƻ�ԭ����
				while (!temp[k].isEmpty()) {
					array[l++] = temp[k].remove().getId();
				}
			}
			divide = divide * radix;
		}
	}
}
