package com.dsa;

public class Heap {

	int arr[];
	int n;

	public Heap() {

		arr = new int[16];
		n = 0;
		arr[0] = 99999;
	}

	public Heap(int arr[]) {

		this.arr = arr;
		n = 0;
		arr[0] = 99999;
	}

	public void insert(int x) {

		n++;
		arr[n] = x;
		restoreUp(n);
	}

	public void restoreUp(int n) {

		int k = arr[n];

		int iParent = n / 2;

		while (k > arr[iParent]) {

			arr[n] = arr[iParent];
			n = iParent;
			iParent = n / 2;
		}
		arr[n] = k;

	}

	public int deleteRoot() {

		int maxValue = arr[1];

		arr[1] = arr[n];
		n--;
		restoreDown(1);

		return maxValue;

	}

	public void restoreDown(int i) {
		restoreDown(i, arr, n);
	}

	public void restoreDown(int i, int[] arr, int n) {

		int k = arr[i];

		int lChild = 2 * i;
		int rChild = lChild + 1;

		while (rChild <= n) {

			if (k >= arr[rChild] && k >= arr[lChild]) {
				arr[i] = k;
				return;
			} else if (arr[rChild] > arr[lChild]) {
				arr[i] = arr[rChild];
				i = rChild;
			} else {
				arr[i] = arr[lChild];
				i = lChild;
			}
			lChild = 2 * i;
			rChild = lChild + 1;
		}

		// if number of nodes is even ,then there is no right child
		if (lChild == n && k < arr[lChild]) {
			arr[i] = arr[lChild];
			i = lChild;
		}
		arr[i] = k;
	}

	public void topDown(int[] arr, int n) {

		for (int i = 2; i <= n; i++) {
			restoreUp(i);
		}
	}

	public void bottomUp(int[] arr, int n) {

		for (int i = n / 2; i <= 1; i--) {
			restoreDown(i);
		}
	}

	public static void displayList(int array[]) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Heap heap = new Heap();

		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(1);
		heap.insert(6);
		heap.insert(5);

		heap.topDown(heap.arr, heap.n);
		displayList(heap.arr);

	}
}
