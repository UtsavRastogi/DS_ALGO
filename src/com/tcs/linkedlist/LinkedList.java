package com.tcs.linkedlist;

public class LinkedList {
	//This is the only variable of ListNode class, used to store the head
	private ListNode head;
	
	//Only variable of this class to store the length
	private int length;
	
	//Returns the node at the head of the list
	public ListNode getHead() {
	return head;
	}
	
	public int length() {
	return length;
	}
	
	public synchronized void setHead(ListNode head) {
		this.head = head;
	}
	
	//Default constructor of this class
	public LinkedList() {
		head=null;
		length=0;
	}

	//Insert a node at the beginning of the list
	public synchronized void insertAtBegin(Object data) {
		ListNode newNode=new ListNode(data);
		newNode.setNext(head);
		head=newNode;
		length++;
	}
	
	//Insert a node at the end of the list
	public synchronized void insertAtEnd(Object data) {
		ListNode newNode=new ListNode(data), p=null, q=null;
		if(head==null) {
			head=newNode;
		}
		else {
			for(p=head;(q=p.getNext())!=null;p=q);
			p.setNext(newNode);
		}
		length+=1;
	}


	//Insert a node at a given position
	//All the nodes at that position till tail node move over to make the room
	public synchronized void insert(Object data, int position) {
		ListNode newNode =new ListNode(data), current=head;
		//fix the position
		if(position<0) {
			position=0;
		}
		if(position>length) {
			position=length;
		}
		if(head==null) {
			head=newNode;
		}
		else if(position==0) {
			newNode.setNext(head);
			head=newNode;
		}else {
			for(int i=1;i<position;i++) {
				current=current.getNext();
			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
		length++;
	}
	
	//Remove a node at the head of the list
	public synchronized ListNode removeFromBegin() {
		ListNode temp=head;
		if(head!=null) {
			head=head.getNext();
			temp.setNext(null);
			length-=1;
		}
		return temp;
		
	}
	
	//Remove the tail node of the list
	public synchronized ListNode removeFromEnd() {
		ListNode current=head, previous=null;
		if(head==null) {
			return null;
		}
		else if(head.getNext()==null) {
			head=null;
			length-=1;
			return current;
		}else {
			current=current.getNext();
			while(current.getNext()!=null) {
				previous=current;
				current=current.getNext();
			}
			previous.setNext(null);
			length-=1;
			return current;
		}
	}
	
	//Remove a node at a specified position
	public synchronized ListNode remove(int position) {
		ListNode current=head;
		//fix the position
		if(position<0) {
			position=0;
		}
		if(position>length) {
			position=position-1;
		}
		
		if(head==null) {
			return null;
		}
		if(position==0) {
			head=head.getNext();
			length-=1;
			return current;
		}
		else {
			for(int i=1;i<position;i++) {
				current=current.getNext();
			}
			ListNode temp=current.getNext();
			current.setNext(current.getNext().getNext());
			length-=1;
			return temp;
		}
	}

	//Returns the string representation of this collection in the form ["str1","str2"...]
	@Override
	public String toString() {
		String result="[";
		if(head==null) {
			return result+"]";
		}
		result+=head.getData();
		ListNode current=head.getNext();
		while(current!=null) {
			result+=","+current.getData();
			current=current.getNext();
		}
		return result+"]";
	}
	
	//Returns the last node in the list
	public synchronized ListNode getLast() {
		ListNode current=head;
		if(head!=null)
		{
			while(current.getNext()!=null) {
				current=current.getNext();
			}
		}
		return current;
	}
	
	//Remove the matched node from the list
	public synchronized ListNode removeMatched(Object data) {
		ListNode current=head, previous=null;
		if(head==null)
			return null;
		if(head.getData()==data) {
			head=head.getNext();
			length-=1;
			return current;
			}
		else {
			while(current.getNext()!=null) {
				previous=current;
				current=current.getNext();
				if(current.getData()==data) {
					previous.setNext(current.getNext());
					length-=1;
					return current;
				}
			}
		}
		return null;
			
	}
	
	//Returns the first index position of an element
	public synchronized int getPosition(Object data) {
		ListNode current=head;
		int index=0;
		if(head!=null) {
			while(current!=null) {
				if(current.getData()==data) {
					return index;
				}
				index+=1;
				current=current.getNext();
			}
		}
		return Integer.MIN_VALUE;
}
	//Clears the list
	public void clearList() {
		head=null;
		length=0;
	}

}
