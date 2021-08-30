package com.dsa;

public class BinarySearchTree {

	Node root;

	class Node {

		Node lChild;

		int info;

		Node rChild;

		public Node(int info) {
			this.info = info;
		}
	}

	public boolean searchI(int x) {

		Node p = root;

		while (p != null) {

			if (p.info == x) {
				return true;
			} else if (p.info > x) {
				p = p.lChild;
			} else {
				p = p.rChild;
			}
		}
		return false;
	}

	public Node searchR(Node p, int x) {

		if (p == null) {
			return null;
		}

		if (p.info > x) {
			return searchR(p.lChild, x);
		}
		if (p.info < x) {
			return searchR(p.rChild, x);
		}

		return p;
	}

	public int min() {

		Node p = root;

		while (p.lChild != null) {
			p = p.lChild;
		}

		int x = p.info;
		return x;
	}

	public int max() {

		Node p = root;

		while (p.rChild != null) {
			p = p.rChild;
		}

		int x = p.info;
		return x;
	}

	public void insertI(int x) {

		Node p = root;
		Node parent = null;
		while (p != null) {
			parent = p;
			if (p.info > x) {
				p = p.lChild;
			} else if (p.info < x) {
				p = p.rChild;
			} else {
				System.out.println(x + " is already present");
				return;
			}
		}

		Node temp = new Node(x);

		if (parent == null) {
			root = temp; // empty tree
		} else if (parent.info > x) {
			parent.lChild = temp;
		} else {
			parent.rChild = temp;
		}
	}

	public Node insertR(Node p, int x) {

		if (p == null) {
			p = new Node(x);
		} else if (x < p.info) {
			p.lChild = insertR(p.lChild, x);
		} else if (x > p.info) {
			p.rChild = insertR(p.rChild, x);
		} else {
			System.out.println(x + " is already present");
		}
		return p;
	}

	public void insertR(int x) {

		root = insertR(root, x);
	}

	public void delete(int x) {
		
		Node p, parent = null;
		
		p=root;
		
		while(p != null) {
			
			if(p.info == x) {
				break;
			}
			parent = p;
			
			if(p.info > x) {
				p=p.lChild;
			}else if (p.info < x) {
				p=p.rChild;
			}
		}
		
		Node s,ps;
		if (p.rChild != null && p.lChild != null) { // case c
			
			ps=p;
			s=p.rChild;
			
			while(s.lChild != null) {
				ps=s;
				s=s.lChild;
			}
			
			p.info = s.info;
			p=s;
			parent=ps;
		}
		
		Node ch = null; // case A or case B
		if(p.lChild != null) {
			ch=p.lChild;
		} else if (p.rChild != null) {
			ch=p.rChild;
		}
		
		
		if (parent == null) {
			root = ch;
		} else if (p == parent.lChild) {
			parent.lChild = ch;
		} else {
			parent.rChild = ch;
		}
	}

	public void inOrder(Node p) {

		if (p == null) {
			return;
		}
		inOrder(p.lChild);
		System.out.print(p.info + " ");
		inOrder(p.rChild);
	}

	public static void main(String[] args) {

		BinarySearchTree binaryTree = new BinarySearchTree();
		Node node1 = binaryTree.new Node(2);
		binaryTree.root = node1;
		Node node2 = binaryTree.new Node(1);
		node1.lChild = node2;
		Node node3 = binaryTree.new Node(3);
		node1.rChild = node3;
		Node node5 = binaryTree.new Node(4);
		Node node6 = binaryTree.new Node(6);

		node3.rChild = node5;
		node5.rChild = node6;
		
		System.out.println(binaryTree.searchI(4));
		System.out.println(binaryTree.searchR(binaryTree.root, 4).info);

		binaryTree.insertR(7);
		binaryTree.insertR(7);

		binaryTree.insertR(0);

		System.out.println("Min " + binaryTree.min() + " Max " + binaryTree.max());

		binaryTree.inOrder(binaryTree.root);

		binaryTree.delete(3);
		System.out.println();
		binaryTree.inOrder(binaryTree.root);

	}
}
