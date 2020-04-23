package com.tcs.linkedlist;



public class LinkedList {
	//This is the only variable of the ListNode class, stores the head of the list
	private ListNode head;
	
	//This variable stores the length of the list
	private int length;
	
	//Returns the first node in the list
	public synchronized ListNode getHead() {
		return head;
	}
	
	//Returns the length of the  list
	public int length() {
		return length;
	}
	
	//The default constructor for this class
	public LinkedList() {
		length=0;
		head=null;
	}
	
	//Removes all the elements and disposes the list
	public void clearList() {
		length=0;
		head=null;
	}
	
	//Returns the string representation of this collection, in the form ["str1", "str2"...]
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
	
	//Insert a node at the beginning of the list
	public synchronized void insertAtBegin(Object data) {
		ListNode newNode=new ListNode(data);
		newNode.setNext(head);
		head=newNode;
		length++;
	}
	
	//Insert a new node at the end of the list
	public synchronized void insertAtEnd(Object data) {
		ListNode newNode =new ListNode(data), p, q;
		if(head==null) {
			head=newNode;
		}else {
			for(p=head;(q=p.getNext())!=null;p=q);
			p.setNext(newNode);
		}
		length++;
	}
	
	//Insert a node at a specified location
	//All the nodes to that position till last move over to make the room
	public synchronized void insert(Object data, int position) {
		ListNode newNode=new ListNode(data), current=head;
		//fix the position
		if(position<0) {
			position=0;
		}
		if(position>length) {
			position=length;
		}
		//If the list is empty,make it be the only node
		if(head==null) {
			head=newNode;
		}else
		//If adding at the front of the list
		if(position==0) {
			newNode.setNext(head);
			head=newNode;
		}else
			//find the location and insert the node
		{
			for(int i=1;i<position;i++) {
				current=current.getNext();
			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
		length++;
		
	}
	
	//Remove the node at the head of the list
	public synchronized ListNode removeFromBegin() {
		ListNode temp=head;
		if(temp!=null) {
			head=temp.getNext();
			temp.setNext(null);
			length-=1;
		}
		return temp;
	}
	
	//Remove the node at the end of the list
	public synchronized ListNode removeFromEnd() {
		ListNode current=head, previous=null;
		if(current==null) 
			return null;
		if(current.getNext()==null) {
			head=null;
			length-=1;
			return head;
		}
		current=current.getNext();
		while(current.getNext()!=null) {
			previous=current;
			current=current.getNext();
		}
		previous.setNext(null);
		length-=1;
		return current;
			
	}
	
	//Remove the node at a given position
	public synchronized ListNode remove(int position) {
		//fix the position
		if(position<0) {
			position=0;
		}
		if(position>length) {
			position=length-1;
		}
		if(head==null)
			return null;
		if(position==0) {
			ListNode current=head;
			head=current.getNext();
			length-=1;
			return current;
		}
		ListNode current=head;
		for(int i=1;i<position;i++) {
			current=current.getNext();
		}
		ListNode removedNode=current.getNext();
		current.setNext(current.getNext().getNext());
		length-=1;
		return removedNode;
	}
	
	//Remove the matched node from the list
	public synchronized ListNode removeMatched(Object data) {
		ListNode current=head, previous;
		if(head==null)
			return null;
		if(head.getData()==data){
			head=current.getNext();
			length-=1;
			return current;
		}
		while(current.getNext()!=null) {
			previous=current;
			current=current.getNext();
			if(current.getData()==data) {
				previous.setNext(current.getNext());
				length-=1;
				return current;
			}
			
		}
		return null;
		
	}
	

	// Find the position of the first value that is equal to a given value.
	// The equals method us used to determine equality.
	public int getPosition(Object data) {
		// go looking for the data
		ListNode temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data) {
				// return the position if found
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		// else return -1
		return Integer.MIN_VALUE;
	}
	
	// Size of the list.
	public boolean isEmpty(){
		return length==0;
	}
}
