
public class String_CharAt_01 {
	
	/*
	 *  charAt() / substring()
	 *  int num = str.charAt(i) = '0'
	 *  
	 *  1. int sum = n1 + n2 + carry;
	 *  2. carry = sum/10;
	 *  3. sb.append(sum%10);
	 *  
	 * */

	public static void main(String[] args) {
		String nums1 = "123";
		String nums2 = "888";
		System.out.println(new String_CharAt_01().solve(nums1, nums2));

	}
	
	public String solve(String num1, String num2) {
		//1 담을 그릇 정하기
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		int num1Length = num1.length()-1; //2
		int num2Length = num2.length()-1; //2
		
		//2
		while(num1Length >= 0 || num2Length >= 0) {
			int n1=0; 
			int n2=0;
			if (num1Length >= 0) {
				n1 = num1.charAt(num1Length) - '0'; //String => int
			}
			if (num2Length >= 0) {
				n2 = num2.charAt(num2Length) - '0'; //String => int
			}
			int sum = n1 + n2 + carry; //11
			carry = sum/10; //1
			sb.append(sum%10);
			num1Length--;
			num2Length--;
		}
		if (carry != 0) sb.append(carry);
		return sb.reverse().toString();
	}

}
