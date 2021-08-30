package com.dsa.queueandstack;

import java.util.NoSuchElementException;

public class QueueA {


	int[] queueArray;

	int front;
	int rear;

	public QueueA() {
		queueArray = new int[10];
		front = -1;
		rear = -1;
	}

	public boolean isFull() {

		return rear == queueArray.length - 1;
	}

	public boolean isEmpty() {

		return front == -1 || front == rear + 1;
	}

	public void enqueue(int x) {

		if (isFull()) {
			System.out.println("Overflow state");
			return;
		}

		if (front == -1) {
			front = 0;
		}
		rear++;
		queueArray[rear] = x;
	}

	public int dequeue() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int x = queueArray[front];
		front++;
		return x;
	}

	public void displayList() {

		for (int i = front; i <= rear; i++) {
			System.out.print(queueArray[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		QueueA queueA = new QueueA();

		queueA.enqueue(2);
		queueA.enqueue(4);
		queueA.enqueue(1);
		queueA.enqueue(3);
		queueA.enqueue(6);

		queueA.displayList();

		queueA.dequeue();
		queueA.dequeue();
		queueA.dequeue();

		queueA.displayList();

		queueA.dequeue();
		queueA.dequeue();
		queueA.dequeue();


	}
}
