package com.hlx.test.linklist;

import java.io.IOException;

import com.hlx.algorithm.linklist.LinkList2;
import com.hlx.algorithm.linklist.LinkListIterator;
import com.hlx.common.MyMethod;

public class LinkListIteratorTest {
	public static void main(String[] args) throws IOException {
		LinkList2 theList = new LinkList2();
		LinkListIterator iter1 = theList.getIterator();
		
		int value;
		iter1.insertAfter(20);
		iter1.insertAfter(40);
		iter1.insertAfter(60);
		iter1.insertAfter(80);
		
		while(true){
			System.out.print("Enter first letter of show, reset, ");
			System.out.print("next, get, before, after, delete: ");
			System.out.flush();
			int choice = MyMethod.getChar(); // get user's option
			switch(choice){
			case 's': // show list
				if(!theList.isEmpty()){
					theList.displayList();
				}else{
					System.out.println("List is empty");
				}
				break;
			case 'r': // reset (to first)
				iter1.reset();
				break;
			case 'n': // advance to next item
				if(!theList.isEmpty() && !iter1.atEnd()){
					iter1.nextLink();
				} else {
					System.out.println("Can't go to next link");
				}
				break;
			case 'g': // get current item
				if(!theList.isEmpty()){
					value = iter1.getCurrent().getId();
					System.out.println("Returned " + value);
				} else {
					System.out.println("List is empty");
				}
				break;
			case 'b': // insert before current
				System.out.print("Enter value to insert: ");
				System.out.flush();
				value = MyMethod.getInt();
				iter1.insertBefore(value);
				break;
			case 'a': // insert after current
				System.out.print("Enter value to insert: ");
				System.out.flush();
				value = MyMethod.getInt();
				iter1.insertAfter(value);
				break;
			case 'd': // delete current item
				if(!theList.isEmpty()){
					value = iter1.deleteCurrent();
					System.out.println("Deleted " + value);
				} else {
					System.out.println("Can't delete");
				}
				break;
			default:
				System.out.println("Invalid entry");
			}
		}
	}
	
	
}
