package com.dsa.queueandstack;

import java.util.NoSuchElementException;

public class CircularQueue {

	int queueArray[];
	int front;
	int rear;

	public CircularQueue() {

		queueArray = new int[10];
		front = -1;
		rear = -1;
	}

	public boolean isEmpty() {

		return front == -1;
	}

	public boolean isFull() {

		return (front == 0 && rear == queueArray.length - 1) || front == rear + 1;
	}

	public void enqueue(int x) {

		if (isFull()) {
			System.out.println("Overflow state");
			return;
		}

		if (front == -1) {
			front = 0;
		}

		if (rear == queueArray.length - 1) {
			rear = 0;
		} else {
			rear++;
		}
		queueArray[rear] = x;
	}

	public int dequeue() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int x = queueArray[front];

		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == queueArray.length - 1) {
			front = 0;
		} else {
			front++;
		}
		return x;
	}

	public void displayList() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int i = front;

		if (front <= rear) {

			while (i <= rear) {
				System.out.print(queueArray[i++] + " ");
			}

		} else {

			while (i <= queueArray.length - 1) {
				System.out.print(queueArray[i++] + " ");
			}
			i = 0;
			while (i <= rear) {
				System.out.print(queueArray[i++] + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		CircularQueue circularQueue = new CircularQueue();
		circularQueue.enqueue(2);
		circularQueue.enqueue(4);
		circularQueue.enqueue(5);
		circularQueue.enqueue(3);
		circularQueue.enqueue(1);

		circularQueue.displayList();

		circularQueue.dequeue();
		circularQueue.dequeue();
		circularQueue.dequeue();
		circularQueue.dequeue();
		circularQueue.dequeue();
		circularQueue.dequeue();
		circularQueue.displayList();
	}
}
