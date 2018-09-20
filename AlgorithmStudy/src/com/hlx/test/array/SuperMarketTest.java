package com.hlx.test.array;

import java.io.IOException;

import com.hlx.array.Queue1;
import com.hlx.common.MyMethod;

public class SuperMarketTest { // programming work 4.5
	private Queue1[] queue = { null, new Queue1(20), new Queue1(20), new Queue1(20), new Queue1(20) }; // 4���˿Ͷ���

	// ģ������
	public void simulate() throws IOException {
		long id = 0; // �˿ͱ��
		boolean flag = true;
		while (flag) {
			System.out.println("��ѡ���¼���");
			System.out.print("0.�й˿ͽ���ĳ�����С�");
			System.out.print("1.�й˿��뿪��1��������");
			System.out.print("2.�й˿��뿪��2��������");
			System.out.print("3.�й˿��뿪��3��������");
			System.out.print("4.�й˿��뿪��4��������");
			System.out.println("q.��ʾ�����˳���");
			String s = MyMethod.getString();
			if (s.length() == 0) {// ֱ������س�
				continue;
			}
			char ch = s.charAt(0);
			switch (ch) {
			case '0':
				id++;
				insertQueue(id); // �˿ͽ������
				displayQueue(); // ��ʾ����
				break;
			case '1':
				removeQueue(1); // �˿��뿪����
				displayQueue(); // ��ʾ����
				break;
			case '2':
				removeQueue(2);
				displayQueue();
				break;
			case '3':
				removeQueue(3);
				displayQueue();
				break;
			case '4':
				removeQueue(4);
				displayQueue();
				break;
			case 'q': // �˳�����
				flag = false;
				System.out.println("byebye!");
				break;
			default:
				break;
			}
		}
	}

	// �Ӷ�����ɾ���˿�
	private void removeQueue(int queueId) {
		if (queue[queueId].size() == 0) {
			return;
		}
		long id = queue[queueId].remove();
		System.out.println("�˿�" + id + "�뿪��" + queueId + "�����У�");
	}

	// �ѹ˿Ͳ��뵽����
	public void insertQueue(long id) {
		int queueId = getMinQueueId();
		queue[queueId].insert(id);
		System.out.println("�˿�" + id + "�����" + queueId + "������");
	}

	// �õ���С���еı��
	private int getMinQueueId() {
		int min = 1;
		for (int i = 2; i < 5; i++) {
			if (queue[i].size() < queue[min].size()) {
				min = i;
			}
		}
		return min;
	}

	// ��ӡ��ʾ��������
	public void displayQueue() {
		for (int i = 1; i < 5; i++) {
			System.out.print("��" + i + "�����У�");
			queue[i].displayQueue();
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		SuperMarketTest sm = new SuperMarketTest();
		sm.simulate();
	}
}
