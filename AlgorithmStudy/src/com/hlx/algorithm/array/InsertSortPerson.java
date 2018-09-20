package com.hlx.algorithm.array;

public class InsertSortPerson{
	
	private Person[] person;
	private int nElems;
	
	public InsertSortPerson(int max) {
		person = new Person[max];
		nElems = 0;
	}
	
	public Person find(String searchName){
		int j;
		for(j=0; j<nElems; j++){
			if(person[j].getLast().equals(searchName)){
				break;
			}
		}
		return (j==nElems) ? null:person[j];
	}
	
	public void insert(String last, String first, int age){
		person[nElems] = new Person(last, first, age);
		nElems++;
	}
	
	public boolean delete(String searchName){
		int j;
		for(j=0; j<nElems; j++){
			if(person[j].getLast().equals(searchName)){
				break;
			}
		}
		if(j == nElems){
			return false;
		} else {
			for(int k=j; k<nElems-1; k++){
				person[k] = person[k+1];
			}
			nElems--;
			return true;
		}
	}
	
	public void displayArray(){
		for(int j=0; j<nElems; j++){
			person[j].displayPerson();
		}
	}
	
	public void insertSort(){
		int in, out;
		for(out=1; out<nElems; out++){
			Person temp = person[out];
			in = out;
			while(in>0 && person[in-1].getLast().compareTo(temp.getLast())>0){
				person[in]=person[in-1];
				--in;
			}
			person[in] = temp;
		}
	}
}
