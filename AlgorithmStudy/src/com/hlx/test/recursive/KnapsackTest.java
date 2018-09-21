package com.hlx.test.recursive;

public class KnapsackTest { // programming work 6.4
	private int[] weights; // �ɹ�ѡ�������
	private boolean[] selects; // ��¼�Ƿ�ѡ��

	public KnapsackTest(int[] weights) {
		this.weights = weights;
		selects = new boolean[weights.length];
	}

	// �����п��ܵĽ�
	// total������
	// index�ɹ�ѡ�������
	public void knapsack(int total, int index) {
		if (total < 0 || total > 0 && index >= weights.length) {// ��ֵ,û�ҵ���
			return;
		}
		if (total == 0) { // ��ֵ���ҵ���
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
