package com.hlx.linklist;

//programming work 5.4
// �����Ŀ�����⣬��ĿҪ��ʵ�ֵ���ջ������ʵ�ֵ��Ƕ��У�ջ�õ���ѭ��������ʵ��
public class CircleListQueue { 
	private CircleList circleList;

	// --------------------------------------------------------------
	public CircleListQueue(int s) // constructor
	{
		circleList = new CircleList();
	}

	// --------------------------------------------------------------
	public void insert(int value) // put item at rear of queue
	{
		circleList.insert(value);
	}

	// --------------------------------------------------------------
	public Link remove() // take item from front of queue
	{
		return circleList.remove();
	}

	// --------------------------------------------------------------
	public long peek() // peek at front of queue
	{
		return circleList.peek();
	}

	// --------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (circleList.size() == 0);
	}

	// --------------------------------------------------------------
	public int size() // number of items in queue
	{
		return circleList.size();
	}

	// --------------------------------------------------------------
	public void display() {
		circleList.display();
	}
}
