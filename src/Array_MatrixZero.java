import java.util.HashSet;
import java.util.Set;

public class Array_MatrixZero {

	//1. 이차원배열
	//2. 0의 위치를 알아낸다. (좌표)
	//3. 그 좌표를 알아내서 row 1, col 1
	// Ds 고유한 좌표값 저장 = HashSet
	// For, while
	
	public static void main(String[] args) {
		int[][] grid = {
				{1,1,1},
				{1,0,1},
				{1,1,1}
		};
		
		new Array_MatrixZero().solve(grid);

	}

	public void solve(int[][] grid) {
		System.out.println("---------input-----");
		print(grid);
		
		//1. DS
		Set<Integer> rowSet = new HashSet<>();
		Set<Integer> colSet = new HashSet<>();
		
		//2.
		for (int i =0;  i <grid.length; i++) {
			for (int j =0; j<grid[i].length; j++) {
				if (grid[i][j]==0) {
					System.out.print("["+i+"]["+j+"] : "+grid[i][j] + " ");
					rowSet.add(i);
					colSet.add(j);
				}
			}
			System.out.println();
		}
		
		for (int i =0;  i <grid.length; i++) {
			for (int j =0; j<grid[i].length; j++) {
				if (rowSet.contains(i) || colSet.contains(j)) {
					grid[i][j]=0;
				}
			}
		}
		
		
		System.out.println("---------output-----");
		print(grid);
	}
	
	public void print(int[][] grid) {
		
		for (int i =0;  i <grid.length; i++) {
			for (int j =0; j<grid[i].length; j++) {
				System.out.print("["+i+"]["+j+"] : "+grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
