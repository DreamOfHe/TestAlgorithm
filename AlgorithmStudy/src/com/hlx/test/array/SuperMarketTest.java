package com.hlx.test.array;

import java.io.IOException;

import com.hlx.array.Queue1;
import com.hlx.common.MyMethod;

public class SuperMarketTest { // programming work 4.5
	private Queue1[] queue = { null, new Queue1(20), new Queue1(20), new Queue1(20), new Queue1(20) }; // 4个顾客队列

	// 模拟收银
	public void simulate() throws IOException {
		long id = 0; // 顾客编号
		boolean flag = true;
		while (flag) {
			System.out.println("请选择事件：");
			System.out.print("0.有顾客进入某个队列。");
			System.out.print("1.有顾客离开第1个队例。");
			System.out.print("2.有顾客离开第2个队例。");
			System.out.print("3.有顾客离开第3个队例。");
			System.out.print("4.有顾客离开第4个队例。");
			System.out.println("q.表示程序退出！");
			String s = MyMethod.getString();
			if (s.length() == 0) {// 直接输入回车
				continue;
			}
			char ch = s.charAt(0);
			switch (ch) {
			case '0':
				id++;
				insertQueue(id); // 顾客进入队列
				displayQueue(); // 显示队列
				break;
			case '1':
				removeQueue(1); // 顾客离开队列
				displayQueue(); // 显示队列
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
			case 'q': // 退出程序
				flag = false;
				System.out.println("byebye!");
				break;
			default:
				break;
			}
		}
	}

	// 从队列中删除顾客
	private void removeQueue(int queueId) {
		if (queue[queueId].size() == 0) {
			return;
		}
		long id = queue[queueId].remove();
		System.out.println("顾客" + id + "离开第" + queueId + "个队列！");
	}

	// 把顾客插入到队列
	public void insertQueue(long id) {
		int queueId = getMinQueueId();
		queue[queueId].insert(id);
		System.out.println("顾客" + id + "进入第" + queueId + "个队例");
	}

	// 得到最小队列的编号
	private int getMinQueueId() {
		int min = 1;
		for (int i = 2; i < 5; i++) {
			if (queue[i].size() < queue[min].size()) {
				min = i;
			}
		}
		return min;
	}

	// 打印显示四条队列
	public void displayQueue() {
		for (int i = 1; i < 5; i++) {
			System.out.print("第" + i + "个队列：");
			queue[i].displayQueue();
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		SuperMarketTest sm = new SuperMarketTest();
		sm.simulate();
	}
}
