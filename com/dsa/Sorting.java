package com.dsa;

public class Sorting {

	public static void selectionSort(int[] array) {

		int n = array.length;
		for (int i = 0; i < n - 1; i++) {

			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {

				if (array[j] < array[minIndex]) {
					minIndex = j;
				}

				if (i != minIndex) {

					int temp = array[i];

					array[i] = array[minIndex];

					array[minIndex] = temp;
				}
			}
		}
	}

	public static void bubbleSort(int array[]) {

		int n = array.length;

		for (int i = n - 2; i >= 0; i--) {

			int swaps = 0;
			for (int j = 0; j <= i; j++) {

				if (array[j] > array[j + 1]) {

					int temp = array[j];

					array[j] = array[j + 1];

					array[j + 1] = temp;
					swaps++;
				}
			}
			if (swaps == 0) {
				break;
			}
		}
	}

	public static void insertionSort(int[] array) {

		int n = array.length;

		for (int i = 1; i < n; i++) {

			int temp = array[i];
			int placeToBeFilled = 0;
			boolean haveToReplace = false;
			for (int j = i - 1; j >= 0 && array[j] > temp; j--) {
				array[j + 1] = array[j];
				placeToBeFilled = j;
				haveToReplace = true;
			}

			if (haveToReplace)
				array[placeToBeFilled] = temp;
		}
	}

	public static void shellSort(int array[]) {

		int h = 5;

		int n = array.length;
		while (1 <= h) {

			for (int i = h; i < n; i++) {

				int temp = array[i];
				int placeToBeFilled = 0;
				boolean haveToReplace = false;
				for (int j = i - h; j >= 0 && array[j] > temp; j = j - h) {
					array[j + h] = array[j];
					placeToBeFilled = j;
					haveToReplace = true;
				}

				if (haveToReplace)
					array[placeToBeFilled] = temp;
			}
			h = h - 2;
		}
	}

	// merge two different array
	public static void merge(int[] array, int[] array1, int temp[]) {

		int n = array.length;
		int m = array1.length;
		int i = 0, j = 0, k = 0;
		while (i <= n - 1 && j <= m - 1) {

			if (array[i] < array1[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array1[j++];
			}
		}

		while (i <= n - 1) {
			temp[k++] = array[i++];
		}

		while (j <= m - 1) {
			temp[k++] = array1[j++];
		}
	}

	public static void mergeSort(int array[], int temp[], int low, int high) {

		if (low == high) {
			return;
		}

		int mid = (high + low) / 2;

		mergeSort(array, temp, low, mid);
		mergeSort(array, temp, mid + 1, high);

		merge(array, temp, low, mid, mid + 1, high);

	}
	// merge sorted part of same array into another array
	public static void merge(int[] array, int temp[], int low1, int up1, int low2, int up2) {

		int i = low1, j = low2, k = low1;
		while (i <= up1 && j <= up2) {

			if (array[i] < array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}

		while (i <= up1) {
			temp[k++] = array[i++];
		}

		while (j <= up2) {
			temp[k++] = array[j++];
		}
	}

	public static void quickSort(int array[], int low, int up) {

		if (low >= up) {
			return;
		}

		int partition = partition(array, low, up);
		quickSort(array, low, partition - 1);
		quickSort(array, partition + 1, up);
	}

	public static int partition(int array[], int low, int up) {

		int pivot = array[low];
		int i = low + 1, j = up;
		while (i <= j) {

			while (array[i] < pivot && i < up) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}

			if (i < j) {

				int temp = array[i];

				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			} else {
				break;
			}
		}
		array[low] = array[j];
		array[j] = pivot;
		return j;
	}

	public static void binaryTreeSort(int array[]) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		for (int i = 0; i < array.length; i++) {
			binarySearchTree.insertR(array[i]);
		}
		binarySearchTree.inOrder(binarySearchTree.root);
	}

	public static void heapSort(int array[]) {

		Heap heap = new Heap(array);

		int n = array.length - 1;
		heap.topDown(array, n);

		while (n > 1) {

			int max = array[1];
			array[1] = array[n];
			array[n] = max;
			n--;
			heap.restoreDown(1, array, n);
		}
	}
	public static void displayList(int array[]) {

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] array = { 99999, 2, 3, 4, 1, 6, 5 };

		// selectionSort(array);

		// bubbleSort(array);

		// insertionSort(array);

		// shellSort(array);

//		int[] array1 = { 2, 3, 4, 5, 6 };
//
//		int[] array2 = { 1, 4, 7, 8, 9 };
//
//		int[] finalArray = new int[array1.length + array2.length];
//
//		merge(array1, array2, finalArray);

//		int[] array1 = { 2, 3, 4, 5, 6, 1, 3, 4, 7, 8 };
//
		int temp[] = new int[array.length];
//
//		merge(array1, temp, 0, 4, 5, 9);

		// mergeSort(array, temp, 0, array.length - 1);
		// quickSort(array, 0, array.length - 1);
		// binaryTreeSort(array);
		// displayList(array);

		heapSort(array);
		displayList(array);
	}
}
