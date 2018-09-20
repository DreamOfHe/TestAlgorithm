package com.hlx.algorithm.linklist;

public class CircleList { // programming work 5.3
	private Link current;
	private int nItems;

	public CircleList() {
		current = null;
		nItems = 0;
	}

	public void insert(int value) {
		Link link = new Link(value);
		if (current == null) {
			current = link;
			link.setNext(link);
		} else {
			link.setNext(current.getNext());
			current.setNext(link);
			current = link;// 插入元素，current要移动要新元素
		}
		nItems++;
	}

	public Link remove() {
		// list为空是没有考虑，在调用remove之前应该判断是否为空
		Link temp = current.getNext();// 删掉current的下一个元素
		if (current.getNext() == current) { // 只有一个元素时
			current = null;
		} else {
			current.setNext(current.getNext().getNext());
		}
		nItems--;
		return temp;
	}

	public int peek() { // 返回最早插入的元素
		// 调用前要判断是否为空
		return current.getNext().getId();
	}

	public Link find(int value) {
		Link temp = current; // 保存原来的位置
		Link result = null;
		if (current == null) {
			return result;
		}
		do {
			step(); // 从current的下一个元素开始比较
			if (current.getId() == value) {
				result = current;
				current = temp; // 还原current到原来的位置,这样就不会打乱插入的顺序，current指向最后插入的元素
				return result;
			}
		} while (current != temp); // current到达原来的位置,一周循环结束
		return result;
	}

	// 往下移一步
	public void step() { // 调用step()方法后，顺序会被打乱
		if (current != null) {
			current = current.getNext();
		}
	}

	public void display() {
		if (current != null) {
			Link temp = current;
			do {
				step(); // 从current的一下个开始显示
				System.out.print(current.getId() + " ");
			} while (current != temp);
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return current == null;
	}

	public int size() {
		return nItems;
	}
}
