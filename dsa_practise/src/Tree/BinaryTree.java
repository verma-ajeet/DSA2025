package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	int idx = -1;

	public static void main(String args[]) {
		int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
		BinaryTree tree = new BinaryTree();

		TreeNode root = tree.buildTree(nodes);
		System.out.println(root.data);
		System.out.println("pre order");
		printPreorder(root);
		System.out.println("\npost order");
		printPostorder(root);
		System.out.println("\nin order");
		printInorder(root);
		System.out.println("\n level order");
		List<List<Integer>> levelOrder = levelOrder(root);
		System.out.println(levelOrder);
	}

	private static List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		q.offer(root);
		while (!q.isEmpty()) {
			int level = q.size();
			List<Integer> l = new ArrayList<>();
			for(int i=0;i<level;i++) {
				if(q.peek().left!=null) {
					q.offer(q.peek().left);
				}
				if(q.peek().right!=null) {
					q.offer(q.peek().right);
				}
				System.out.println(q);
				l.add(q.poll().data);
			}
			result.add(l);
		}
		return result;
	}

	public TreeNode buildTree(int nodes[]) {
		idx++;
		if (nodes[idx] == -1) {
			return null;
		}
		TreeNode newNode = new TreeNode(nodes[idx]);
		newNode.left = buildTree(nodes);
		newNode.right = buildTree(nodes);
		return newNode;
	}

	public static void printPreorder(TreeNode root) {
		if (root == null) {
//	           System.out.print(-1+" ");
			return;
		}
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}

	private static void printPostorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.data + " ");
	}

	private static void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}
}
