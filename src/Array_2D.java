
public class Array_2D {

	//필수 숙지 개념
	public static void main(String[] args) {
		Array_2D a = new Array_2D();
		
		//1. 2차원배열의 크기가 같다.
		int[][] grid = new int[3][4]; //초기화 모두 0으로 들어간다.
		System.out.println("-----1번----");
		a.print(grid);
		grid[0][1] = 10;
		System.out.println("-----1번 -2 ----");
		a.print(grid);
		
		//2. 2차원 배열의 크기가 다른 경우
		int[][] grid2 = new int[3][];
		grid2[0] = new int[1];
		grid2[1] = new int[2];
		grid2[2] = new int[7];
		System.out.println("------2번------");
		a.print(grid2);
		
		//3. 직접 넣는 방법 (가장 많이 사용)
		int[][] grid3 = {{1,2},{2,3},{3,5}};
		System.out.println("-----3번-----");
		a.print(grid3);

	}
	
	public void print(int[][] grid) {
		for(int i =0; i <grid.length; i++) {
			for(int j =0; j<grid[i].length;j++ ) {
				System.out.print("["+i+"]["+j+"] : "+grid[i][j] + " ");
			}
			System.out.println();
		}
	}

}
