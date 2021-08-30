package com.dsa;

public class BinarySearchA {

	int[] array;

	int n;

	public BinarySearchA() {

		array = new int[10];
		n = 0;
	}

	public int search(int value) {

		int first = 0, last = n - 1;

		int mid;

		while (first <= last) {

			mid = (last + first) / 2;
			if (array[mid] == value) {
				return mid;
			} else if (array[mid] > value) {
				last = mid - 1;
			} else {
				first = mid + 1;
			}
		}

		return -1;

	}
}
