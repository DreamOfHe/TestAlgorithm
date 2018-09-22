package com.hlx.test.linklist;

import com.hlx.algorithm.linklist.CircleList;

public class RadixSortTest {  // programming work 7.5
	// ==============================================
	// 基数排序算法
	// ==============================================
	// 过程如下:
	// 初数组 8 12 22 15 20 7 25 18 212 基数为10
	// 首先按个位排序
	// 结果是 (20)(12 22 212)(15 25)(7)(8 18)
	// 然后按十位排序
	// 结果是 (7 8) (12 212 15 18) (20 22 25)
	// 然后按百位排序
	// 结果是 (7 8 12 15 18 20 22 25) 212
	// 排序结束
	// ==============================================
	// 此方法用链表暂存元素
	// ==============================================
	public static void main(String[] args) {
		int[] array = { 3, 2, 3, 2, 5, 333, 45566, 2345678, 78, 990, 12, 432, 56 };
		radixSort(array, 10, 7);
		for (int i = 0; i < array.length; i++) {
			System.out.print("  " + array[i]);
		}
	}
	
	private static void radixSort(int[] array, int radix, int distance) {
		// array 为待排序数组
		// radix 代表基数
		// distance 代表排序元素的位数  //大于或等于最大的元素的位数
		int length = array.length;
		CircleList[] temp = new CircleList[radix];// 用于暂存元素
		for (int x = 0; x < radix; x++) { // 初始化数组
			temp[x] = new CircleList();
		}
		int divide = 1;

		for (int i = 0; i < distance; i++) {
			// 个人觉的运用基数排序实现基数排序的重点在下面这些代码
			for (int j = 0; j < length; j++) { // 按各元素相应位上的数字分组
				int tempindex = (int) (array[j] / divide) % radix;
				temp[tempindex].insert(array[j]);
			}
			int l = 0;
			for (int k = 0; k < temp.length; k++) { // 把分好组的元素复制回原数组
				while (!temp[k].isEmpty()) {
					array[l++] = temp[k].remove().getId();
				}
			}
			divide = divide * radix;
		}
	}
}
