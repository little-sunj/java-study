import java.util.*;

public class Map_mapAndArray {

	//map + array
	public static void main(String[] args) {
		// 배열이 주어지면 가장 빈도수가 높은 k개의 요소를 return
		// k 값은 항상 주어짐
		int[] nums = {1,1,2,2,2,3,5,5,5,5};
		int k = 2; 

		System.out.println(new Map_mapAndArray().topFrequent(nums, k));
	}
	
	public List<Integer> topFrequent(int[] nums, int k) {
		//1. DS 담을그릇
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer>[] list = new List[nums.length+1];
		List<Integer> result = new ArrayList<>();
		
		//2. 맵에 getOrDefault
		for(int num:nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		//3. List
		for (int key:map.keySet()) {
			int topFrequent = map.get(key); //value를 가져온다.
			if (list[topFrequent] == null) {
				list[topFrequent] = new ArrayList<>();
			}
			list[topFrequent].add(key); //key를 넣는다.
		}
		
		//4. List에서 뽑아내기 k=2
		for(int lastIndex=list.length-1; lastIndex>=0; lastIndex--) {
			if(list[lastIndex] !=null ) {
				for(int i =0; i<list[lastIndex].size() && result.size() <k ; i++) {
					result.add(list[lastIndex].get(i));
				}
			}
		}

		return result;
	}
 
}
