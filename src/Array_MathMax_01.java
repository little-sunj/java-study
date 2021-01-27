
public class Array_MathMax_01 {

	public static void main(String[] args) {
		
		int[] prices = {8,2,6,5,1,7,5};
		System.out.println(maxProfit(prices));
		
	}
	
	public static int maxProfit(int[] nums) {
		//1
		if (nums.length==0) return 0;
		
		//2 그릇 생성
		int max = 0;
		int sofaMin = nums[0];
		
		//3. for or while
		for (int i =0; i<nums.length; i++) {
			if (sofaMin > nums[i]) {
				sofaMin = nums[i]; // 제일 작은 값으로 변경해준다.
			} else {
				max = Math.max(max, nums[i]-sofaMin);
			}
		}
		return max;
	}

}
