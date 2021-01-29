import java.util.ArrayList;
import java.util.List;

public class Array_convert2DArray {

	/*2차원배열 리스트변환*/
	/*
	 * 1.Array -> List
	 * 2. List -> Array
	 * 3. 2차원 Array -> List<List<Integer>>
	 * 4. List<List<integer>> -> 2차원 array
	 * */
	public static void main(String[] args) throws Exception {
		int[][] A = {
				{1,2,3},
				{4,5,6,10,11},
				{7,8,9}
		};
		
		//1. 2DArray => List
		List<List<Integer>> list = convert(A);
		System.out.println("--------------list ---");
		System.out.println(list);
		
		//2. list => 2DArray
		int[][] arr2 = convert2(list);
		System.out.println("--------------arr2 ---");
		print(arr2);

	}
	
	//1. 2DArray => List  for문 두번
	public static List<List<Integer>> convert(int[][] a) {
		//1 resultYtpe
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i =0; i<a.length; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j =0;j<a[i].length;j++) {
				list.add(a[i][j]);
			}
			result.add(list);
		}
		return result;
	}
	
	//2. list => 2DArray
	public static int[][] convert2(List<List<Integer>> list) {
		//1. array는 fixed라 크기를 무조건 만들어두어야한다.
		int[][] result = new int[list.size()][];
		for (int i =0; i<result.length; i++) {
			result[i] = new int[list.get(i).size()]; //열의 크기는 달라질수 있다. 이부분을 알아내서 사이즈를 fix시킨다.
		}
		for (int i=0; i<list.size(); i++) {
			for(int j=0; j<list.get(i).size();j++) {
				result[i][j] = list.get(i).get(j);
			}
		}
		return result;
	}
	
	public static void print(int[][] grid) {
		for(int i =0; i <grid.length; i++) {
			for(int j =0; j<grid[i].length;j++ ) {
				System.out.print("["+i+"]["+j+"] : "+grid[i][j] + " ");
			}
			System.out.println();
		}
	}

}
