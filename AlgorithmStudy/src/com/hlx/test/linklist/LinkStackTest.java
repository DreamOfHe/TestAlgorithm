package com.hlx.test.linklist;

import com.hlx.linklist.LinkStack;

public class LinkStackTest {
	public static void main(String[] args) {
		LinkStack theList = new LinkStack();
		theList.push(22);
		theList.push(33);
		theList.displayStack();
		
		theList.push(44);
		theList.push(55);
		
		theList.displayStack();
		
		theList.pop();
		theList.pop();
		
		
		theList.displayStack();
	}
}
