package com.dsa.queueandstack;

import java.util.Stack;

public class Postfix {
		
		// A utility function to return
		// precedence of a given operator
		// Higher returned value means
		// higher precedence
		static int Prec(char ch)
		{
			switch (ch)
			{
			case '+':
			case '-':
				return 1;
		
			case '*':
			case '/':
				return 2;
		
			case '^':
				return 3;
			}
			return -1;
		}
		
		// The main method that converts
		// given infix expression
		// to postfix expression.
		static String infixToPostfix(String exp)
		{
			// initializing empty String for result
			String result = new String("");
			
			// initializing empty stack
			java.util.Stack<Character> stack = new java.util.Stack<Character>();
			
			for (int i = 0; i<exp.length(); ++i)
			{
				char c = exp.charAt(i);
				
				// If the scanned character is an
				// operand, add it to output.
				if (Character.isLetterOrDigit(c))
					result += c;
				
				// If the scanned character is an '(',
				// push it to the stack.
				else if (c == '(')
					stack.push(c);
				
				// If the scanned character is an ')',
				// pop and output from the stack
				// until an '(' is encountered.
				else if (c == ')')
				{
					while (!stack.isEmpty() &&
							stack.peek() != '(')
						result += stack.pop();
					
						stack.pop();
				}
				else // an operator is encountered
				{
					while (!stack.isEmpty() && Prec(c)
							<= Prec(stack.peek())) {
					
						result += stack.pop();
				}
					stack.push(c);
				}
		
			}
		
			// pop all the operators from the stack
			while (!stack.isEmpty()){
				if(stack.peek() == '(')
					return "Invalid Expression";
				result += stack.pop();
			}
			return result;
		}

		static int evaluatePostfix(String exp) {
			// create a stack
			java.util.Stack<Integer> stack = new Stack<Integer>();

			// Scan all characters one by one
			for (int i = 0; i < exp.length(); i++) { // scan all one by one from rear position for prefix evaluation
				char c = exp.charAt(i);

				// If the scanned character is an operand (number here),
				// push it to the stack.
				if (Character.isDigit(c))
					stack.push(Character.getNumericValue(c));

				// If the scanned character is an operator, pop two
				// elements from stack apply the operator
				else {
					int val1 = stack.pop();
					int val2 = stack.pop();

					switch (c) {
					case '+':
						stack.push(val2 + val1);
						break;

					case '-':
						stack.push(val2 - val1);
						break;

					case '/':
						stack.push(val2 / val1);
						break;

					case '*':
						stack.push(val2 * val1);
						break;
					case '%':
						stack.push(val2 % val1);
						break;
					case '^':
						stack.push((int) Math.pow(val2, val1));
						break;
					}
				}
			}
			return stack.pop();
		}

		// prefix
		public static void reverse(char[] str, int start, int end) {

			while (start < end) {

				char temp = str[start];
				str[start] = str[end];
				str[end] = temp;
				start++;
				end--;
			}

			for (int i = 0; i < str.length; i++) {
				System.out.print(str[i]);
			}
			System.out.println();
		}

		public static int evaluateInfix(String exp) {

			Stack<Character> characters = new Stack<Character>();

			Stack<Integer> numbers = new Stack<Integer>();

			for (int i = 0; i < exp.length(); i++) {

				char c = exp.charAt(i);

				if (Character.isDigit(c)) {
					numbers.add(c - '0');
				} else {

					if (c == '(') {
						characters.add(c);
					} else if (c == ')') {

						while (!characters.isEmpty() && characters.peek() != '(') {

							applyOperation(numbers.pop(), numbers.pop(), characters.pop(), numbers);
						}
						characters.pop();
					} else {

						while (!characters.isEmpty() && precendence(c) <= precendence(characters.peek())) {
							applyOperation(numbers.pop(), numbers.pop(), characters.pop(), numbers);
						}
						characters.add(c);
					}
				}
			}

			while (!characters.isEmpty()) {

				applyOperation(numbers.pop(), numbers.pop(), characters.pop(), numbers);
			}
			return numbers.pop();
		}

		public static int precendence(char ch) {

			switch (ch) {
			case '+':
			case '-':
				return 1;

			case '*':
			case '/':
				return 2;

			case '^':
				return 3;
			}
			return -1;
		}

		public static void applyOperation(int val2, int val1, char c, Stack<Integer> stack) {

			switch (c) {
			case '+':
				stack.push(val1 + val2);
				break;

			case '-':
				stack.push(val1 - val2);
				break;

			case '/':
				stack.push(val1 / val2);
				break;

			case '*':
				stack.push(val1 * val2);
				break;
			case '%':
				stack.push(val1 % val2);
				break;
			case '^':
				stack.push((int) Math.pow(val1, val2));
				break;
			}
		}

		// Driver method
		public static void main(String[] args)
		{
			String exp = "3+3+(4/2)";

			System.out.println(evaluateInfix(exp));
			String postfix = infixToPostfix(exp);
			System.out.println(postfix);
			reverse(postfix.toCharArray(), 0, postfix.length() - 1);

			System.out.println(Math.pow(2, 3));
		}

}
