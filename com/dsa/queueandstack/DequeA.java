package com.dsa.queueandstack;

import java.util.NoSuchElementException;

public class DequeA {

	int[] queueArray;
	int front;
	int rear;

	public DequeA() {

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

	public void inserAtFront(int x) {
		
		if(isFull()) {
			System.out.println("Overflow");
			return;
		}
		
		if(front == -1) {
			front = 0;
			rear = 0;
		}else if (front ==0) {
			front = queueArray.length - 1;
		}else {
			front=front-1;
		}
		queueArray[front]=x;
	}

	public void insertAtRear(int x) {
		if (isFull()) {
			System.out.println("Overflow");
			return;
		}

		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (rear == queueArray.length - 1) {
			rear = 0;
		} else {
			rear++;
		}
		queueArray[rear] = x;

	}

	public int deleteAtFront() {

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

	public int deleteAtRear() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int x = queueArray[rear];

		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (rear == 0) {
			rear = queueArray.length - 1;
		} else {
			rear--;
		}

		return x;

	}

	public void displayList() {

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

		DequeA a = new DequeA();
		a.inserAtFront(2);
		a.inserAtFront(4);
		a.insertAtRear(3);
		a.insertAtRear(1);

		a.displayList();
		
		a.deleteAtFront();
		a.deleteAtRear();
		
		a.displayList();
	}
}
