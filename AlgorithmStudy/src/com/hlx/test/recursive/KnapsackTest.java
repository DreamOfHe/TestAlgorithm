package com.hlx.test.recursive;

public class KnapsackTest { // programming work 6.4
	private int[] weights; // 可供选择的重量
	private boolean[] selects; // 记录是否被选择

	public KnapsackTest(int[] weights) {
		this.weights = weights;
		selects = new boolean[weights.length];
	}

	// 找所有可能的解
	// total总重量
	// index可供选择的重量
	public void knapsack(int total, int index) {
		if (total < 0 || total > 0 && index >= weights.length) {// 基值,没找到解
			return;
		}
		if (total == 0) { // 基值，找到解
			for (int i = 0; i < index; i++) {
				if (selects[i] == true) {
					System.out.print(weights[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		selects[index] = true;
		knapsack(total - weights[index], index + 1);
		selects[index] = false;
		knapsack(total, index + 1);
	}

	public static void main(String[] args) {
		KnapsackTest knapsack = new KnapsackTest(new int[] { 11, 8, 7, 6, 5, 4, 3 });
		knapsack.knapsack(20, 0);
	}
}
