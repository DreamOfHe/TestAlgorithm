package com.hlx.linklist;

//programming work 5.4
// 这个题目有问题，题目要求实现的是栈，这里实现的是队列，栈用单向循环链表不好实现
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
