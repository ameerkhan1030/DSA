package com.dsa.queueandstack;

import java.util.EmptyStackException;

public class Stack {

	int[] stackArray;
	int top;

	public Stack() {
		stackArray = new int[10];
		top = -1;
	}

	public boolean isEmpty() {

		return top == -1;
	}

	public boolean isFull() {

		return top == stackArray.length - 1;
	}

	public void push(int x) {

		if (isFull()) {
			System.out.println("Overflow state");
			return;
		}

		top++;
		stackArray[top] = x;
	}

	public int pop() {

		if (isEmpty()) {
			System.out.println("Underflow state");
			throw new EmptyStackException();
		}

		int x = stackArray[top];
		top--;
		return x;

	}

	public int peek() {

		if (isEmpty()) {
			System.out.println("Underflow state");
			throw new EmptyStackException();
		}

		return stackArray[top];
	}

	public void displayList() {

		for (int i = top; i >= 0; i--) {
			System.out.println(stackArray[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Stack stack = new Stack();

		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(6);
		stack.push(5);

		stack.displayList();

		stack.pop();
		stack.pop();

		stack.displayList();
	}
}
