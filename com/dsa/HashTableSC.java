package com.dsa;

import com.dsa.list.SingleLinkedList;

public class HashTableSC {

	SingleLinkedList<Integer>[] array;
	int m;
	int n;

	static class Node {

		public int info;

		public Node link;

		public Node(int info) {
			this.info = info;
		}

	}

	HashTableSC(int size) {

		array = new SingleLinkedList[size];
		m = size;
		n = 0;
	}

	HashTableSC() {
		this(11);
	}

	public int hash(int x) {
		return x % m;
	}

	public void insert(int i) {

		int key = i;

		int h = hash(key);

		if (array[h] == null) {
			array[h] = new SingleLinkedList<Integer>();
		}
		array[h].insertAtFirst(i);
		n++;
	}

	public void search(int i) {

		int key = i;

		int h = hash(key);

		if (array[h] != null) {
			array[h].search(i);
		}

	}

	public void delete(int i) {

		int key = i;

		int h = hash(key);

		if (array[h] != null) {
			array[h].deleteAtValue(i);
			n--;
		}

	}

	public void displayList() {

		for (int i = 0; i < m; i++) {

			if (array[i] != null) {
				array[i].displayList();
			}
		}
	}
	public static void main(String[] args) {

		HashTableSC hashTableSC = new HashTableSC();

		hashTableSC.insert(1);
		hashTableSC.insert(2);
		hashTableSC.insert(3);
		hashTableSC.insert(4);
		hashTableSC.insert(5);

		hashTableSC.displayList();

		System.out.println(Math.abs(3.0 / 4.0));
	}



}
