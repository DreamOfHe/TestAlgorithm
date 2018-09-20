package com.hlx.test.linklist;

import com.hlx.linklist.CircleList;

public class JosephusTest { // programming work 5.5

	public static int getJosephus(int number) {
		CircleList circleList = new CircleList();
		for (int i = 1; i <= number; i++) { // number�����ųɻ�
			circleList.insert(i);
		}
		System.out.print("ԭʼȦ�ӣ�");
		circleList.display();
		System.out.print("��Ȧ˳��");
		for (int i = 1; i < number; i++) { // Ҫɾ��number-1����
			for (int j = 1; j < 4; j++) { //���������ģ���Ϊremove()����ɾ��������һ��
				circleList.step();
			}
			System.out.print(circleList.remove().getId() + " ");
		}
		System.out.println();
		return circleList.peek();
	}

	public static void main(String[] args) {
		int number = JosephusTest.getJosephus(7);
		System.out.println("Josephus�ı����:" + number);
	}

}
