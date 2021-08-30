package com.dsa;

public class Recursion {

	public void nTo1(int n) {

		if (n == 0) {
			return;
		}

		System.out.print(n + " ");
		nTo1(n - 1);

	}

	public void oneToN(int n) {

		if (n == 0) {
			return;
		}
		oneToN(n - 1);
		System.out.print(n + " ");
	}

	public int factorial(int n) {

		// base case
		if (n == 0) {
			return 1;
		}

		// recursive case
		int result = n * factorial(n - 1);

		return result;
	}

	public int sumOfDigits(int n) {

		if (n / 10 == 0) {
			return n;
		}

		return sumOfDigits(n / 10) + (n % 10);
	}

	public void converBase(int n, int base) {

		if (n == 0) {
			return;
		}
		converBase(n / base, base);
		int rem = n % base;
		if (rem < 10) {
			System.out.print(rem);
		} else {
			System.out.print((char) (rem - 10 + 'A'));
		}
	}

	public int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		return x * power(x, n - 1);

	}

	// Greatest common divisor // Largest number divides both integer
	public int gcd(int a, int b) {

		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);

	}

	public int fibonacci(int n) {

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public void towerOfHanoi(int n, char source, char temp, char destination) {

		if (n == 1) {
			System.out.println("Move disk  1 from " + source + " to " + destination);
			return;
		}

		towerOfHanoi(n - 1, source, destination, temp);
		System.out.println("Move disk " + n + " from " + source + " to " + destination);
		towerOfHanoi(n - 1, temp, source, destination);
	}

	public static void main(String[] args) {

		Recursion recursion = new Recursion();
		System.out.println(recursion.factorial(5));

		recursion.nTo1(3);
		System.out.println();
		recursion.oneToN(3);

		System.out.println(recursion.sumOfDigits(12345));
		
		recursion.converBase(2, 2);
		System.out.println();
		System.out.println(recursion.power(2, 3));

		System.out.println(recursion.gcd(5, 25));

		for (int i = 0; i < 7; i++) {
			System.out.print(recursion.fibonacci(i) + " ");
		}
		System.out.println();

		recursion.towerOfHanoi(3, 'A', 'B', 'C');

		int sd = 0;

		int j;

		for (j = -1; j <= 5; j += 2) {

			switch (j) {

			case 1:
				sd++;
				break;

			case 2:
				sd += 2;
				break;
			case 4:
				sd %= 2;
				j = -1;
				continue;
			default:
				sd--;
				continue;
			}
		}

		System.out.println(sd);

	}
}
