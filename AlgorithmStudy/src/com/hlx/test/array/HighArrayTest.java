package com.hlx.test.array;

import com.hlx.array.HighArray;

public class HighArrayTest {

	public static void main(String[] args){
		int maxSize = 100;
		HighArray arr = new HighArray(maxSize);
		
		arr.insert(888);
		arr.insert(22);
		arr.insert(489);
		arr.insert(123);
		arr.insert(55);
		arr.insert(123);
		arr.insert(123);
		arr.insert(687);
		arr.insert(156);
		arr.insert(156);
		arr.insert(156);
		arr.insert(88);
		arr.insert(88);
		arr.insert(88);
		arr.insert(88);
		arr.insert(321);
		
		arr.display();
		
		arr.noDup2();
		arr.display();
		
		// begin programming work 2.3
		HighArray reverseArr = new HighArray(maxSize);
		
		long deleteElem = -1;
		for(int j=0; j<maxSize; j++){
			deleteElem = arr.removeMax();
			if(deleteElem != -1){
				reverseArr.insert(deleteElem);
			} else {
				break;
			}
		}
		
		reverseArr.display();
		// end programming work 2.3
	}
}
