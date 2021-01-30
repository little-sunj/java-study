import java.util.*;

public class Map_getOrDefault {

	public static void main(String[] args) {
		//주어진 문자열에서 반복되지 않는 첫 번째 문자를 찾아서 index return
		//rule - 문자열에는 영문 소문자만 포함되어있음
		String s = "inflearninlove";
		System.out.println(solve(s));

	}
	
	public static int solve(String s) {
		
		//1. error check
		if (s==null || s.length()==0) return -1;
		
		//2. 담을 그릇 Data structure
		Map<Character, Integer> map = new HashMap<>();
		//문자열을 for문을 돌려서 각 문자별 개수를 파악
		//나오는 값이 처음 나온 문자면 1
		
		//3. for, while
		for (char ch : s.toCharArray()) {
			
		/*	
		 * if (!map.containsKey(ch)) {
				map.put(ch, 1); 
			} else {
				map.put(ch, map.get(ch)+1);
			}
			아래 getOrDefault 코드와 동일
			*/
			
			//ch라는 키가 존재하면 ch값 , 
			//ch라는 키가 존재하지 않는다면 0으로 빼낸 후 default value로 +1 해준다.
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		for (int i =0; i<s.length(); i++) {
			if(map.get(s.charAt(i))==1) {
				return i;
			}
		}
		return -1;
	}

}
