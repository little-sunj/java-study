import java.util.HashMap;
import java.util.Map;

public class Array_SubArraySum {

	public static void main(String[] args) {
		

		int[] nums = {3,4,7,2,-3,1,4,2};
		int k = 7;
		//System.out.println(subarraySum(nums, k)); //for문 방식
		System.out.println(subarraySum_map(nums, k)); //for문 방식
	}
	
	// for문으로 접근하는 방법
	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		
		for(int i =0; i <nums.length; i ++) {
			int sum = 0;
			for(int j =i; j<nums.length;j++) {
				sum = sum+nums[j];
				//System.out.println("nums[" +j+"] : " + nums[j] + "  , sum : "+sum);
				if(sum==k) {
					count ++;
				}
			}
		}
		
		return count;
	}

	// map으로 접근하는 방법
	public static int subarraySum_map(int[] nums, int k) {
		//1.
		int count=0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1); //map의 기준점을 0,1로 잡고 누적시키면서 넣어준다.
		int sum = 0;
		
		//2.
		for(int i =0; i<nums.length;i++) {
			 sum+=nums[i];
			 System.out.println("nums[" +i+"] : " + nums[i] + "  , sum : "+sum);
			 System.out.println("sum-k : " + (sum-k));
			 if(map.containsKey(sum-k)) {
				 count += map.get(sum-k);
				 System.out.println("map.get(sum-k) : " + map.get(sum-k));
			 }
			 map.put(sum, map.getOrDefault(sum, 0) + 1);
			 System.out.println("map.getOrDefault(sum, 0) : " + map.getOrDefault(sum, 0));
		}
		
		
		return count;
	}
}
