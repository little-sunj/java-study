import java.util.*;

class TreeNode {
	int val;
	TreeNode left, right;
	
	TreeNode(int x) {
		this.val = x;
	}
}

public class BFS_BasicDFS2 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		System.out.println(solve(root));
	}

	public static List<List<Integer>> solve(TreeNode root) {
		// DS
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean check = true;
		
		//2
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			
			for (int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				if (check) {
					list.add(node.val);
				} else {
					list.add(0, node.val); //지그재그로 들어갈 수 있게
				}
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			check = !check;
			result.add(list);
		}
		
		
		
		return result;
	}
}
