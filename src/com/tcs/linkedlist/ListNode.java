package com.tcs;

import java.util.Objects;

public class ListNode {
	
//Attributes of this class	
private ListNode next;
private Object data;

public ListNode getNext() {
	return next;
}
public void setNext(ListNode next) {
	this.next = next;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}

//Overriding the toString method
@Override
public String toString() {
	return data.toString();
}

//Only parameterized constructor of this class
public ListNode(Object data) {
	this.data = data;
}




}
