package com.dsa.queueandstack;

import java.util.NoSuchElementException;

public class PriorityQueue {

	Node front;

	class Node {

		int priority;
		int info;
		Node link;

		Node(int info, int pr) {
			this.info = info;
			this.priority = pr;
		}
	}

	public boolean isEmpty() {
		return front == null;
	}

	public void insert(int x, int priority) {

		Node temp = new Node(x, priority);

		if (isEmpty() || priority < front.priority) {
			temp.link = front;
			front = temp;
			return;
		}

		Node p = front;

		while (p.link != null && p.link.priority <= priority) {
			p = p.link;
		}
		temp.link = p.link;
		p.link = temp;
	}

	public int delete() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int x = front.info;
		front = front.link;
		return x;
	}

	public void displayList() {

		Node p = front;

		while (p != null) {

			System.out.println(p.info + " " + p.priority);
			p = p.link;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		PriorityQueue priorityQueue = new PriorityQueue();

		priorityQueue.insert(1, 1);
		priorityQueue.insert(2, 2);
		priorityQueue.insert(3, 3);
		priorityQueue.insert(5, 4);
		priorityQueue.insert(4, 5);

		priorityQueue.displayList();

	}
}
