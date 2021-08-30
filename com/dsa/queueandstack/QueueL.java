package com.dsa.queueandstack;

import java.util.NoSuchElementException;

public class QueueL {

	Node rear;

	Node front;

	class Node {

		int info;

		Node link;

		public Node(int x) {
			this.info = x;
		}
	}

	public boolean isEmpty() {

		return front == null || front == rear.link;
	}
	public void enqueue(int x) {

		Node temp = new Node(x);

		if (front == null) {
			front = temp;
		} else {
			rear.link = temp;
		}
		rear = temp;
	}

	public int dequeue() {

		if (isEmpty()) {
			System.out.println("UnderFlow state");
			throw new NoSuchElementException();
		}
		int x = front.info;
		front = front.link;
		return x;
	}

	public void displayList() {

		Node p = front;

		while (p != null) {

			System.out.print(p.info + " ");
			p = p.link;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		QueueL l = new QueueL();
		l.enqueue(2);
		l.enqueue(4);
		l.enqueue(5);
		l.enqueue(3);
		l.enqueue(1);

		l.displayList();

		l.dequeue();
		l.dequeue();

		l.displayList();
	}
}
