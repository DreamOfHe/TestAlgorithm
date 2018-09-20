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
			current = link;// ����Ԫ�أ�currentҪ�ƶ�Ҫ��Ԫ��
		}
		nItems++;
	}

	public Link remove() {
		// listΪ����û�п��ǣ��ڵ���remove֮ǰӦ���ж��Ƿ�Ϊ��
		Link temp = current.getNext();// ɾ��current����һ��Ԫ��
		if (current.getNext() == current) { // ֻ��һ��Ԫ��ʱ
			current = null;
		} else {
			current.setNext(current.getNext().getNext());
		}
		nItems--;
		return temp;
	}

	public int peek() { // ������������Ԫ��
		// ����ǰҪ�ж��Ƿ�Ϊ��
		return current.getNext().getId();
	}

	public Link find(int value) {
		Link temp = current; // ����ԭ����λ��
		Link result = null;
		if (current == null) {
			return result;
		}
		do {
			step(); // ��current����һ��Ԫ�ؿ�ʼ�Ƚ�
			if (current.getId() == value) {
				result = current;
				current = temp; // ��ԭcurrent��ԭ����λ��,�����Ͳ�����Ҳ����˳��currentָ���������Ԫ��
				return result;
			}
		} while (current != temp); // current����ԭ����λ��,һ��ѭ������
		return result;
	}

	// ������һ��
	public void step() { // ����step()������˳��ᱻ����
		if (current != null) {
			current = current.getNext();
		}
	}

	public void display() {
		if (current != null) {
			Link temp = current;
			do {
				step(); // ��current��һ�¸���ʼ��ʾ
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
