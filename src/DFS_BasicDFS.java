
public class DFS_BasicDFS {

	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
				{'0','0','0','1','1'},
		};
		
		DFS_BasicDFS a = new DFS_BasicDFS();
		System.out.println(a.numsIslands(grid));

	}
	
	int m, n;
	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public int numsIslands(char[][] grid) {
		
		if (grid ==null || grid.length == 0 || grid[0].length ==0) {
			return 0;
		}
		int count = 0;
		m = grid.length; //row 4
		n = grid[0].length; //col 5
		
		for (int i =0; i< m; i++) {
			for(int j =0; j<n; j++) {
				
				if(grid[i][j]=='1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}
	
	public void dfs(char[][] grid, int i, int j) {
		
		//error check
		if (i<0 || j<0 || m<=i || n<=j || grid[i][j] != '1') {
			return;
		}
		
		grid[i][j] = 'X'; //다시 안돌아갈 곳
		
		//재귀 (사방으로)
		for (int[] dir : dirs) {
			dfs(grid, i+dir[0], j+dir[1]);
		}
//		재귀는 아래와 동일		
//		dfs(grid, i-1, j);
//		dfs(grid, i+1, j);
//		dfs(grid, i, j-1);
//		dfs(grid, i, j+1);
	}

}
