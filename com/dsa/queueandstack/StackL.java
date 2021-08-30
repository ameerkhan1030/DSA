package com.dsa.queueandstack;

import java.util.EmptyStackException;

public class StackL {

	Node top;

	class Node {

		int info;

		Node link;

		public Node(int x) {

			this.info = x;
		}
	}

	public int size() {
		int size = 0;

		Node p = top;

		while (p != null) {

			size++;
			p = p.link;
		}

		return size;
	}

	public boolean isEmpty() {

		return top == null;
	}

	public void push(int x) {

		Node temp = new Node(x);

		temp.link = top;
		top = temp;
	}

	public int pop() {

		if (isEmpty()) {
			throw new EmptyStackException();
		}

		int x = top.info;
		top = top.link;
		return x;
	}

	public int peek() {

		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return top.info;
	}

	public void displayList() {

		Node p = top;
		while (p != null) {
			System.out.println(p.info);
			p = p.link;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		StackL stackL = new StackL();
//		stackL.push(2);
//		stackL.push(4);
//		stackL.push(1);
//		stackL.push(3);
//		stackL.push(6);

		stackL.displayList();

		stackL.pop();
		stackL.pop();

		stackL.displayList();
	}
}
