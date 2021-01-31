import java.util.*;

public class Stack_Basic {

	public static void main(String[] args) {
		//1. stack에 숫자넣기
		//2. 문자 넣기
		//3. [ 일때
		//4. ] 일때 숫자스택에서 빼내어 넣기
		
		String s = "12[a]2[bc]2[d]";
		Stack_Basic a = new Stack_Basic();
		System.out.println(a.solve(s));
	}

	public String solve(String s) {
		//1
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();
		StringBuilder result = new StringBuilder();
		int k = 0;
		
		//2
		for(char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				k = k*10 + c-'0'; //char에서 0을 빼면 int로 변환
			} else if (c=='[') {
				countStack.push(k);
				stringStack.push(result);
				
				result = new StringBuilder(); //작업 후 초기화
				k = 0; //작업 후 초기화
			} else if (c==']') { //핵심
				StringBuilder str = stringStack.pop();
				
				for (int i = countStack.pop(); i>0; i--) {
					str.append(result);
				}
				result = str;
				
			} else {
				result.append(c); //real char
			}
		}
		
		return result.toString();
	}
}
