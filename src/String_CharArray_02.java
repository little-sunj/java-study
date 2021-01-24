
public class String_CharArray_02 {

	public static void main(String[] args) {
		
		String s = "(a(b(c)d)";
//		String s = "in(f(lea)r)n)";
//		String s = "a)b(c)d";
		
		System.out.println(new String_CharArray_02().solve(s));
		

	}
	
	public String solve(String s) {
		//1 담을그릇
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int count = 0; // '(' left count
		
		//2 count파악
		for (char c : s.toCharArray()) {
			if(c=='(') {
				count++;
			} else if (c==')') {
				if (count==0) continue;
				count--;
			}
			sb.append(c); //그대로 저장이 되어있다.
		}

		//3 파악한 것 기준으로 전체에서 제외 할 대상 빼고 그대로 저장
		for (int i = sb.length()-1; i >= 0 ; i--) {
			if (sb.charAt(i)=='(' && count--> 0) continue;
			result.append(sb.charAt(i));
		}
		
		
		return result.reverse().toString();
	}

}
