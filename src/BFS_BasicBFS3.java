import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_BasicBFS3 { //ctrl + shift + f 자동정렬

	public static void main(String[] args) {
//		char[][] grid = {
//				{'1','1','0','0','1'},
//				{'1','1','0','0','0'},
//				{'0','0','0','0','0'},
//				{'0','0','0','1','1'},
//		};
//		char[][] grid = {
//				{1,1,1,0},
//				{1,2,2,0},
//				{1,0,0,1},
//				{0,0,0,1},
//				{0,0,0,3},
//				{0,0,0,3}
//		};
		char[][] grid = { { 0, 0, 3, 3 }, { 1, 4, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 2, 2, 0 },
				{ 1, 1, 0, 0 } };

		BFS_BasicBFS3 a = new BFS_BasicBFS3();
		System.out.println(Arrays.toString(a.solve(grid)));

	}

	int m, n = 0;
	int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	boolean[][] visited;

	public int[] solve(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return new int[] {0,0};
		}

		int count = 0;
		int maxSize = 0;
		m = grid.length; // row 4
		n = grid[0].length; // col 5
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] || grid[i][j] == 0) {
					continue;
				}
				count++;
				int thisAreaSize = bfs(grid, i, j, visited);
				maxSize = Math.max(maxSize, thisAreaSize);
			}
		}
		
		int[] result = new int[2];
		result[0] = count;
		result[1] = maxSize;
		return result;
	}

	public int bfs(char[][] grid, int x, int y, boolean[][] visited) {
		// DS
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = true;
		int thisNumAreaSize = 0;

		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			thisNumAreaSize++;
			visited[x][y] = true;

			for (int[] dir : dirs) {
				int x1 = point[0] + dir[0];
				int y1 = point[1] + dir[1];

				if (x1 >= 0 && y1 >= 0 && x1 < m && y1 < n) {
					if (!visited[x1][y1] && grid[x][y] == grid[x1][y1]) {
						queue.add(new int[] { x1, y1 });
						visited[x1][y1] = true;
					}
				}
			}
		}

		return thisNumAreaSize;
	}
}
