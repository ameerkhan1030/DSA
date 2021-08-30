package com.dsa.queueandstack;

public class Paranthesis {

	Node[] paranthesisArrays;

	{
		paranthesisArrays = new Node[3];

		paranthesisArrays[0] = new Node(')', '(');
		paranthesisArrays[1] = new Node('}', '{');
		paranthesisArrays[2] = new Node(']', '[');
	}

	class Node {

		char leftParanthesis;

		char rightParanthesis;

		public Node(char right, char left) {
			this.rightParanthesis = right;
			this.leftParanthesis = left;
		}

	}

	public boolean isValid(String str) {
	

		Stack stack = new Stack();

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {

				stack.push(str.charAt(i));

			}

			if (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {

				if(stack.isEmpty()) {
					System.out.println("Right paranthesis more than left paranthesis");
					return false;
				}else {
					
					char ch = (char) stack.pop();
					
					if (!matchParanthesis(ch, str.charAt(i))) {
						System.out.println("Paranthesis are mismatched");
						return false;
					}
				}
				

			}

		}

		if (stack.isEmpty()) {
			return true;
		} else {
			System.out.println("Left paranthesis are more than right paranthesis");
			return false;
		}

	}

	public boolean matchParanthesis(char left, char right) {

		for (int i = 0; i < paranthesisArrays.length; i++) {

			if (paranthesisArrays[i].rightParanthesis == right && paranthesisArrays[i].leftParanthesis != left) {
				return false;
			} else if (paranthesisArrays[i].rightParanthesis == right && paranthesisArrays[i].leftParanthesis == left) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		String str = "{()[}";

		System.out.println(new Paranthesis().isValid(str));
	}
}
