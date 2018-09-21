package com.hlx.test.recursive;

public class BinaryTreeShow { // programming work 6.2
	private char[][] lines;

	// number 一行最大显示字符数
	public BinaryTreeShow(int number) {
		int rows = 1;
		int numberDivide = number;// 不要直接用number去除，后面还有用到number
		while ((numberDivide = numberDivide / 2) != 0) {// 行数 number和row的关系
			rows++;							// 2^(row-1) = number 2^(5-1)=16
		}									// 当number=16时，row=5
		lines = new char[rows][number];
		for (int i = 0; i < rows; i++) { // 初始化数组
			for (int j = 0; j < number; j++) {
				lines[i][j] = '-';
			}
		}
	}

	public void display() {
		for (int i = 0; i < lines.length; i++) { // 初始化数组
			for (int j = 0; j < lines[i].length; j++) {
				System.out.print(lines[i][j]);
			}
			System.out.println();
		}
	}

	public void makeBranches(int left, int right) {
		int number = right - left + 1;
		int row = 0;
		int muberDivide = number; // 不要直接用number去除，后面还有用到number
		while ((muberDivide = muberDivide * 2) <= lines[0].length) {
			row++;// 计算当前行号
		}
		if (number == 1) {// 基值条件
			lines[row][left] = 'X';
			return;
		} else {
			int mid = (left + right) / 2 + 1;
			lines[row][mid] = 'X';
			makeBranches(left, mid - 1);
			makeBranches(mid, right);
		}
	}

	public void makeTree() {
		makeBranches(0, lines[0].length - 1);
	}

	public static void main(String[] args) {
		BinaryTreeShow binaryTreeShow = new BinaryTreeShow(16);
		binaryTreeShow.makeTree();
		binaryTreeShow.display();
	}
}
