package Tree;

import java.util.Scanner;

public class TreeOperation {
	private TreeNode root;

	public static void main(String[] args) {
		TreeOperation bst = new TreeOperation();

		// Insert nodes into the BST
		int[] values = { 5, 3, 2, 4, 7, 6, 8 };
		for (int value : values) {
			bst.insert(value);
		}
		// Print the tree structure
		bst.printTree();
		// Perform preorder traversal
		bst.preorderTraversal();
	}

	public void insert(int value) {
		root = insertNode(root, value);
	}

	private TreeNode insertNode(TreeNode node, int value) {
		if (node == null) {
			return new TreeNode(value);
		}

		if (value < node.data) {
			node.left = insertNode(node.left, value);
		} else if (value > node.data) {
			node.right = insertNode(node.right, value);
		}

		return node;
	}

	public void preorderTraversal() {
		System.out.println("Preorder Traversal:");
		performPreorderTraversal(root);
		System.out.println();
	}

	private void performPreorderTraversal(TreeNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			performPreorderTraversal(node.left);
			performPreorderTraversal(node.right);
		}
	}

	public void printTree() {
		System.out.println("Binary Search Tree Structure:");
		printTree(root, "", false);
		System.out.println();
	}

	private void printTree(TreeNode node, String prefix, boolean isLeft) {
		if (node != null) {
			System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
			if (node.left != null || node.right != null) {
				printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
				printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
			}
		}
	}
}
