package com.dsa.list;

public class DoublyLinkedList {

	Node head;

	class Node {

		Node prev;
		int info;
		Node next;

		public Node(int info) {
			this.info = info;
		}
	}

	public void insertInEmptyList(int x) {

		Node temp = new Node(x);
		head = temp;
	}

	public void insertInTheBeginning(int x) {

		if (head == null) {
			insertInEmptyList(x);
			return;
		}
		Node temp = new Node(x);
		temp.next = head;
		head.prev = temp;
		head = temp;
	}

	public void insertInTheEnd(int x) {

		Node temp = new Node(x);

		Node node = head;
		while (node.next != null) {

			node = node.next;
		}

		node.next = temp;
		temp.prev = node;

	}

	public void insertBeforeTheNode(int x, int nodeValue) {

		Node temp = new Node(x);

		Node node = head;

		while (node != null) {

			if (node.info == nodeValue) {
				break;
			}
			node = node.next;

		}
		if (node == null) {
			System.out.println("Not able to find the value " + nodeValue + " in the list");
		} else {

			temp.next = node;
			temp.prev = node.prev;
			node.prev.next = temp;
			node.prev = temp;
		}

	}

	public void insertAfterTheNode(int x, int nodeValue) {

		Node temp = new Node(x);

		Node node = head;

		while (node != null) {

			if (node.info == nodeValue) {
				break;
			}
			node = node.next;

		}

		if (node == null) {

			System.out.println("Not able to find the value " + nodeValue + " in the list");
		} else {

			temp.next = node.next;
			temp.prev = node;
			node.next.prev = temp;
			node.next = temp;
		}

	}

	public void deleteFirstNode() {

		if (head.next == null) {
			head = null;
			return;
		}
		head = head.next;
		head.prev = null;
	}

	public void deleteLastNode() {

		if (head.next == null) {
			head = null;
			return;
		}

		Node node = head;

		while (node.next != null) {

			node = node.next;
		}

		node.prev.next = null;
	}

	public void deleteBWTheList(int nodeValue) {

		if (head.next == null) {

			if (head.info == nodeValue) {
				head = null;
				return;
			} else {
				System.out.println("Not able to find the value " + nodeValue + " in the list");
			}

		}

		Node node = head;

		while (node != null) {

			if (node.info == nodeValue) {
				break;
			}
		}

		node.next.prev = node.prev;
		node.prev.next = node.next;
	}

	public void reverseList() {

		Node p1 = head;

		Node p2 = head.next;

		p1.next = null;
		p1.prev = p2;

		while (p2 != null) {

			p2.prev = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p2.prev;
		}
		head = p1;
	}

	public void displayList() {

		Node p = head;

		while (p != null) {

			System.out.println(p.info);
			p = p.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {

		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
//		Node head = doublyLinkedList.new Node(1);
//		doublyLinkedList.head = head;
		doublyLinkedList.insertInEmptyList(2);
		doublyLinkedList.insertInTheBeginning(3);
		doublyLinkedList.insertInTheEnd(4);
		doublyLinkedList.insertBeforeTheNode(5, 2);
		doublyLinkedList.insertAfterTheNode(6, 2);
		doublyLinkedList.reverseList();
		doublyLinkedList.displayList();
	}
}
