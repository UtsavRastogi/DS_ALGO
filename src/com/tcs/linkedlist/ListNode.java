package com.tcs.linkedlist;

import java.util.Objects;

public class ListNode {
private Object data;
private ListNode next;
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
public ListNode getNext() {
	return next;
}
public void setNext(ListNode next) {
	this.next = next;
}

public ListNode(Object data) {
	this.data=data;
	next=null;
}

public ListNode() {
	data=null;
	next=null;
}

public static int listLength(ListNode headNode) {
	ListNode current=headNode;
	int length=0;
	while(current!=null) {
		length++;
		current=current.getNext();
	}
	return length++;
}

@Override
public String toString() {
	return data.toString();
}
@Override
public int hashCode() {
	return Objects.hash(data);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ListNode other = (ListNode) obj;
	return Objects.equals(data, other.data);
}


}
