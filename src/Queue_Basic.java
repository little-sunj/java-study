import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Treenode1 {
	int val;
	Treenode1 left, right;
	Treenode1(int x) {
		this.val = x;
	}
}

public class Queue_Basic {

	public static void main(String[] args) {
		Treenode1 root = new Treenode1(1);
		root.left = new Treenode1(2);
		root.right = new Treenode1(3);
		root.left.left = new Treenode1(4);
		root.left.right = new Treenode1(5);

		System.out.println(solve(root));
	}

	public static List<List<Integer>> solve(Treenode1 root) {
		//1
		List<List<Integer>> result = new ArrayList<>();
		Queue<Treenode1> queue = new LinkedList<>();
		queue.offer(root);
		boolean zigzag = true;
		
		//2
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			
			for(int i=0; i<size; i++) {
				Treenode1 node = queue.poll();
				if (zigzag) {
					list.add(node.val);
				} else {
					list.add(0, node.val);
				}
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			zigzag = !zigzag;
			result.add(list);
		}
		return result;
	}
}
