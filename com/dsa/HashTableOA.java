package com.dsa;

public class HashTableOA {

	Student[] array;

	int m;

	int n;

	public HashTableOA() {

		m = 11;
		array = new Student[m];
		n = 0;
	}

	public HashTableOA(int size) {

		m = size;
		array = new Student[m];
		n = 0;
	}
	static class Node{
		
		public Student student;
		
		public Node link;
		
		public Node(Student student) {
			this.student=student;
		}
		
	}
	
	class Student {

		int id;

		String name;

		public Student(int id, String name) {

			this.id = id;
			this.name = name;
		}

		public int getID() {
			return id;
		}

		public String getName() {
			return name;
		}
	}

	public void insertSC(Student x) {
		
		
	}
	public void insert(Student x) {

		if (n >= m / 2) {

			rehash(nextPrime(2 * m));
			System.out.println("New table size is " + m);
		}

		int key = x.getID();

		int h = hash(key);
		int location = h;

		for (int i = 1; i < m; i++) {

			if (array[location] == null || array[location].getID() == -1) {
				array[location] = x;
				n++;
				return;
			}

			if (array[location].getID() == key) {
				System.out.println("Duplicate Key");
				return;
			}
			location = (h + i) % m;
		}

	}


	public Student search(Student x) {

		int key = x.getID();

		int h = hash(key);
		int location = h;

		for (int i = 1; i < m; i++) {

			if (array[location] == null) {
				return null;
			}

			if (array[location].getID() == key) {
				return array[location];
			}
			location = (h + i) % m;
		}
		return null;
	}

	public void delete(Student x) {

		int key = x.getID();

		int h = hash(key);
		int location = h;

		for (int i = 1; i < m; i++) {

			if (array[location] == null) {
				return;
			}

			if (array[location].getID() == key) {
				array[location] = new Student(-1, null);
				n--;
				return;
			}
			location = (h + i) % m;
		}

	}

	public int hash(int x) {
		return x % m;
	}

	public int nextPrime(int x) {

		if (!isPrime(x)) {
			x++;
		}
		return x;
	}

	public boolean isPrime(int x) {

		for (int i = 2; i < m; i++) {

			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public void rehash(int m) {

		HashTableOA temp = new HashTableOA(m);
		for (int i = 0; i < this.m; i++) {

			if (array[i] != null && array[i].getID() != -1) {
				temp.insert(array[i]);
				n++;
			}
		}
		this.m = m;
		this.array = temp.array;
	}

	public static void main(String[] args) {

		HashTableOA hahTable = new HashTableOA();

		hahTable.insert(hahTable.new Student(1, "ameer"));

		hahTable.insert(hahTable.new Student(2, "ameer"));

		hahTable.insert(hahTable.new Student(3, "ameer"));

		System.out.println(hahTable.search(hahTable.new Student(2, "ameer")).name);

		hahTable.delete(hahTable.new Student(2, "ameer"));

		System.out.println(hahTable.search(hahTable.new Student(2, "ameer")) == null ? "Not exist" : "exist");
	}

}
