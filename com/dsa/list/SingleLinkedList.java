package com.dsa.list;

class Node<T> {

	T info;

	Node<T> link;

	public Node(T info) {
		this.info = info;
		this.link = null;
	}
}

public class SingleLinkedList<T> {

	Node<T> head;

	public void displayList() {

		Node<T> currentNode = head;

		while (currentNode != null) {

			System.out.print(currentNode.info);
			currentNode = currentNode.link;
		}
		System.out.println();
	}

	public void findIndex(T value) {

		Node<T> currentNode = head;

		int index = 0;

		while (currentNode != null) {

			if (currentNode.info.equals(value)) {
				break;
			}
			index++;
			currentNode = currentNode.link;
		}

		System.out.println(value + " present in index " + index);

	}

	// insertAtFirst
	public void insertAtFirst(T info) {

		Node<T> temp = new Node<T>(info);

		if (head == null) {
			head = temp;
			return;
		}
		temp.link = head;
		head = temp;
	}

	// insertAtLast
	public void insertAtLast(T info) {

		Node<T> temp = new Node<T>(info);

		if (head == null) {
			head = temp;
			return;
		}

		Node<T> currentNode = head;
		while (currentNode.link != null) {
			currentNode = currentNode.link;
		}
		currentNode.link = temp;
	}

	// InsertAtPosition
	public void insertAtPosition(int index, T info) {

		Node<T> temp = new Node<T>(info);
		if (index == 0) {
			temp.link = head;
			head = temp;
			return;
		}
		Node<T> currentNode = head;
		for (int i = 0; i < index - 1 && currentNode != null; i++) {
			currentNode = currentNode.link;
		}

		if (currentNode == null) {
			System.out.println("Cant find index " + index + " in this list");
		} else {
			temp.link = currentNode.link;
			currentNode.link = temp;
		}

	}

	// DeleteAtFirst
	public void deleteAtFirst() {

		if (head == null) {
			System.out.println("Nothing to delete");
			return;
		}

		head = head.link;
	}

	// DeleteAtLast
	public void deleteAtLast() {

		if (head == null) {
			System.out.println("Nothing to delete");
			return;
		}
		Node<T> currentNode = head;

		while (currentNode.link.link != null) {
			currentNode = currentNode.link;
		}

		currentNode.link = null;

	}

	// DeleteAtPosition
	public void deleteAtPosition(int index) {

		if (index == 0) {
			head = head.link;
			return;
		}

		Node<T> currentNode = head;
		for (int i = 0; i < index - 1 && currentNode.link != null; i++) {
			currentNode = currentNode.link;
		}

		if (currentNode.link == null) {
			System.out.println("Cant find index " + index + " in this list to delete");
		} else {
			currentNode.link = currentNode.link.link;
		}
	}

	public void deleteAtValue(int value) {

		Node<T> currentNode = head;

		if (value == (int) head.info) {
			head = head.link;
		}

		while (currentNode.link != null) {


			if ((int) currentNode.link.info == value) {
				System.out.println(value + " Deleted");
				break;
			}
			currentNode = currentNode.link;
		}

		if (currentNode.link == null) {
			System.out.println(value + " not found");
		} else {
			currentNode.link = currentNode.link.link;
		}

	}

	// Reverse List
	public void reverseList() {

		Node<T> prev = null, next = null;

		Node<T> currentNode = head;

		while (currentNode != null) { // 1,2,3

			next = currentNode.link;
			currentNode.link = prev;
			prev = currentNode;
			currentNode = next;
		}
		head = prev;
	}

	public void bubbleSortData() {

		Node<T> p = null, q, end;

		for (end = null; end != head; end = p) {

			for (p = head; p.link != end; p = p.link) {

				q = p.link;

				if ((int) p.info > (int) q.info) {

					T temp = p.info;
					p.info = q.info;
					q.info = temp;
				}

			}
		}
	}

	public SingleLinkedList<T> mergeByData(SingleLinkedList<T> list2) {

		SingleLinkedList<T> mergeList = new SingleLinkedList<T>();

		mergeList.head = mergingByData(head, list2.head);

		return mergeList;
	}

	public SingleLinkedList<T> mergeByRef(SingleLinkedList<T> list2) {

		SingleLinkedList<T> mergeList = new SingleLinkedList<T>();

		mergeList.head = mergingByRef(head, list2.head);

		return mergeList;
	}

	public Node<T> mergingByData(Node<T> a, Node<T> b) {

		Node<T> start = null;

		if ((int) a.info <= (int) b.info) {

			start = a;
			a = a.link;
		} else {
			start = b;
			b = b.link;
		}

		Node<T> newList = start;
		while (a != null && b != null) {

			if ((int) a.info <= (int) b.info) {

				newList.link = new Node<T>(a.info);
				a = a.link;

			} else {
				newList.link = new Node<T>(b.info);
				b = b.link;
			}
			newList = newList.link;
		}

		while (a != null) {

			newList.link = new Node<T>(a.info);
			newList = newList.link;
			a = a.link;

		}

		while (b != null) {
			newList.link = new Node<T>(b.info);
			newList = newList.link;
			b = b.link;
		}

		return start;

	}

	public Node<T> mergingByRef(Node<T> a, Node<T> b) {

		Node<T> start = null;

		if ((int) a.info <= (int) b.info) {

			start = a;
			a = a.link;
		} else {
			start = b;
			b = b.link;
		}

		Node<T> newList = start;
		while (a != null && b != null) {

			if ((int) a.info <= (int) b.info) {

				newList.link = a;
				a = a.link;

			} else {
				newList.link = b;
				b = b.link;
			}
			newList = newList.link;
		}

		if (a != null) {

			newList.link = a;

		}

		if (b != null) {
			newList.link = b;
		}

		return start;

	}

	public void bubbleSortRef() {

		Node<T> p = null, q, end, r;

		for (end = null; end != head.link; end = p) {

			for (r = p = head; p.link != end; r = p, p = p.link) {

				q = p.link;

				if ((int) p.info > (int) q.info) {

					p.link = q.link;
					q.link = p;

					if (p != head) {
						r.link = q;
					} else {
						head = q;
					}
					Node<T> temp = p;
					p = q;
					q = temp;
				}

			}
		}
	}

	public void mergeSort() {

		head = mergeSortList(head);
	}

	private Node<T> mergeSortList(Node<T> start) {

		if (start == null || start.link == null) {
			return start;
		}

		Node<T> head = start;
		Node<T> head2 = divideList(start);

		head = mergeSortList(head);
		head2 = mergeSortList(head2);
		return mergingByRef(head, head2);
	}

	private Node<T> divideList(Node<T> head) {

		Node<T> q = head.link.link;

		while (q != null && q.link != null) {

			head = head.link;
			q = q.link.link;
		}
		Node<T> start2 = head.link;
		head.link = null;
		return start2;

	}

	public void insertCycle(int x) {
		
		Node<T> p, cycle = null, prev = null;
		
		p = head;
		while(p != null) {
			
			if((int)p.info == x) {
				cycle = p;
			}
			prev = p;
			p=p.link;
		}
		
		if (cycle != null) {
			prev.link = cycle;
		} else {
			System.out.println(x + " value is not present in the list to form a cycle");
		}

	}

	public Node<T> findCycle() {

		if (head == null || head.link == null) {
			return null;
		}
		Node<T> h, t; // hare and tortoise

		h = head;
		t = head;
		while (h != null && h.link != null) {

			t = t.link;
			h = h.link.link;
			if (t == h) {
				return t;
			}
		}
		return null;
	}

	public void removeCycle() {

		Node<T> cycle = findCycle();

		if (cycle == null) {
			System.out.println("There is No cylcle to remove");
			return;
		}

		Node<T> p = cycle, q = cycle;

		int lengthOfTheCycle = 0;

		do {
			p = p.link;
			lengthOfTheCycle++;
		} while (p != q);

		int lengthOfRemainingList = 0;

		p = head;

		while (p != q) {

			p = p.link;
			q = q.link;
			lengthOfRemainingList++;
		}

		int lengthOfTheList = lengthOfRemainingList + lengthOfTheCycle;

		p = head;

		for (int i = 0; i < lengthOfTheList - 1; i++) {
			p = p.link;
		}
		p.link = null;
	}

	public void insertInOrder(int x) {

		Node<T> temp = new Node(x);
		if (head == null) {
			head = temp;
			return;
		}

		if ((int) head.info > x) {
			temp.link = head;
			head = temp;
			return;
		}

		Node<T> p = head;

		while (p.link != null && (int) p.link.info <= x) {
			p = p.link;
		}
		temp.link = p.link;
		p.link = temp;

	}

	public void search(int x) {

		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		Node<T> p = head;
		int index = 0;
		while (p != null && (int) p.info <= x) {

			if ((int) p.info == x) {
				break;
			}
			index++;
			p = p.link;
		}

		if (p == null || (int) p.info != x) {
			System.out.println(x + " is not present in the list");
		} else {
			System.out.println("Present in the " + index + " index in the list");
		}

	}

	public void printList(SingleLinkedList<Integer> list) {

		Node<Integer> start = list.head;
		while (start.link != null) {

			System.out.println(start.info);
			start = start.link;
		}
	}
	public static void main(String[] args) {

		SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

		Node<Integer> head = new Node<Integer>(2);
		linkedList.head = head;
		Node<Integer> element1 = new Node<Integer>(3);
		head.link = element1;
		Node<Integer> element2 = new Node<Integer>(1);
		element1.link = element2;
		linkedList.findIndex(1);

		linkedList.insertAtFirst(10);
		linkedList.insertAtLast(20);
		linkedList.insertAtPosition(1, 30);
		linkedList.displayList();
//		linkedList.deleteAtFirst();
//		linkedList.deleteAtLast();
//		linkedList.displayList();
//		linkedList.deleteAtPosition(0);
//		linkedList.displayList();
//		linkedList.reverseList();
//		linkedList.displayList();
//		linkedList.bubbleSortRef();
//		linkedList.displayList();

//		SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<Integer>();
//		Node<Integer> head2 = new Node<Integer>(12);
//		linkedList2.head = head2;
//		Node<Integer> element3 = new Node<Integer>(3);
//		head2.link = element3;
//		Node<Integer> element4 = new Node<Integer>(11);
//		element3.link = element4;
		linkedList.bubbleSortRef();
//		linkedList2.displayList();
//		SingleLinkedList<Integer> mergedList = linkedList.mergeByRef(linkedList2);
//		linkedList.printList(mergedList);

//		linkedList.mergeSort();
//		linkedList.displayList();
//
//		linkedList.insertCycle(3);
//
//		linkedList.removeCycle();
//		linkedList.insertInOrder(12);
//		linkedList.insertInOrder(50);
		linkedList.displayList();

//		linkedList.search(12);


	}
}
