package com.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	Node root;

	class Node {

		Node lChild;

		int info;

		Node rChild;

		public Node(int info) {
			this.info = info;
		}
	}

	public void preOrder(Node p) {

		if (p == null) {
			return;
		}
		System.out.print(p.info + " ");
		preOrder(p.lChild);
		preOrder(p.rChild);
	}

	public void inOrder(Node p) {

		if (p == null) {
			return;
		}
		inOrder(p.lChild);
		System.out.print(p.info + " ");
		inOrder(p.rChild);
	}

	public void postOrder(Node p) {
		if (p == null) {
			return;
		}

		postOrder(p.lChild);
		postOrder(p.rChild);
		System.out.print(p.info + " ");

	}

	public void levelOrder() {

		Queue<Node> queueA = new LinkedList<BinaryTree.Node>();

		queueA.add(root);

		while (!queueA.isEmpty()) {

			Node node = queueA.poll();
			System.out.print(node.info + " ");

			if (node.lChild != null) {
				queueA.add(node.lChild);
			}
			if (node.rChild != null) {
				queueA.add(node.rChild);
			}

		}
		System.out.println();
	}

	public int height(Node p) {

		if (p == null) {
			return 0;
		}

		int hL = height(p.lChild);
		int hR = height(p.rChild);

		if (hL > hR) {
			return 1 + hL;
		} else {
			return 1 + hR;
		}

	}
	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();

		Node node1 = binaryTree.new Node(2);
		binaryTree.root = node1;
		Node node2 = binaryTree.new Node(1);
		node1.lChild = node2;
		Node node3 = binaryTree.new Node(3);
		node1.rChild = node3;
		Node node5 = binaryTree.new Node(4);
		Node node6 = binaryTree.new Node(6);

		node2.lChild = node5;
		node2.rChild = node6;

		binaryTree.preOrder(binaryTree.root);
		System.out.println();
		binaryTree.inOrder(binaryTree.root);
		System.out.println();
		binaryTree.postOrder(binaryTree.root);
		System.out.println();

		binaryTree.levelOrder();
		
		System.out.println(binaryTree.height(binaryTree.root));


	}
}
