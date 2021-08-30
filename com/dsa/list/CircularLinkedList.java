package com.dsa.list;

public class CircularLinkedList {

	Node last;

	class Node {

		Node next;
		int info;

		public Node(int info) {
			this.info = info;
		}
	}

	public void insertInEmptyList(int x) {

		Node node = new Node(x);
		last = node;
		last.next = last;
	}

	public void insertInBeg(int x) {

		if (last == null) {
			insertInEmptyList(x);
			return;
		}
		Node node = new Node(x);

		node.next = last.next;
		last.next = node;
	}

	public void insertInEnd(int x) {

		if (last == null) {
			insertInEmptyList(x);
			return;
		}
		Node node = new Node(x);
		node.next = last.next;
		last.next = node;
		last = node;
	}

	public void displayList() {

		if (last == null) {
			System.out.println("Nothing to display");
			return;
		}

		Node node = last.next;

		do {

			System.out.println(node.info);
			node = node.next;
		} while (node != last.next);
		System.out.println();

	}
	public static void main(String[] args) {

		CircularLinkedList circularLinkedList = new CircularLinkedList();

		Node node = circularLinkedList.new Node(2);
		node.next = node;
		circularLinkedList.last = node;

		circularLinkedList.insertInBeg(3);
		circularLinkedList.insertInEnd(5);
		circularLinkedList.displayList();
	}
}
