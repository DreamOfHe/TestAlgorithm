package com.hlx.test.linklist;

import com.hlx.algorithm.linklist.CircleList;

public class JosephusTest { // programming work 5.5

	public static int getJosephus(int number) {
		CircleList circleList = new CircleList();
		for (int i = 1; i <= number; i++) { // number个人排成环
			circleList.insert(i);
		}
		System.out.print("原始圈子：");
		circleList.display();
		System.out.print("出圈顺序：");
		for (int i = 1; i < number; i++) { // 要删掉number-1个人
			for (int j = 1; j < 4; j++) { //不能数到四，因为remove()方法删掉的是下一个
				circleList.step();
			}
			System.out.print(circleList.remove().getId() + " ");
		}
		System.out.println();
		return circleList.peek();
	}

	public static void main(String[] args) {
		int number = JosephusTest.getJosephus(7);
		System.out.println("Josephus的编号是:" + number);
	}

}
