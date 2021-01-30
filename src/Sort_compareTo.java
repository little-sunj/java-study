
public class Sort_compareTo {

	public static void main(String[] args) {
		// version1와 version2를 비교한다.
		//version 1 < version2 일시 반환 -1
		//version 1 > version2 일시 반환 1
		//그렇지 않은 경우 0 반환

//		String version1 = "8.5.2.4";
//		String version2 = "8.5.3";
		String version1 = "1.0.1";
		String version2 = "1";
		System.out.println(solve(version1, version2));
//		compareToTest();
		//1.앞자리를 비교한다.
		//2. .을 처리한다
		//3. 2,3을 비교하면 결정된다.
	}

	public static void compareToTest() {
		Integer a=1, b=3; //오름차순 -1, 오른쪽 큰값
		System.out.println(a.compareTo(b));
	}
	
	public static int solve(String v1, String v2) {
		
		//1. DataStructure
		String[] v1StrArray = v1.split("\\.");
		String[] v2StrArray = v2.split("\\.");
		
		//2
		int length = Math.max(v1StrArray.length, v2StrArray.length);
		for (int i=0; i<length; i++) {
			//compareTo가 Integer타입이기때문에 Int가 아닌 Integer로 받는다.***
			Integer v1Int = i<v1StrArray.length ? Integer.parseInt(v1StrArray[i]) : 0;
			Integer v2Int = i<v2StrArray.length ? Integer.parseInt(v2StrArray[i]) : 0;
			
			int comp = v1Int.compareTo(v2Int);
			if(comp != 0) {
				return comp;
			}
		}
		
		return 0;
	}
}
