
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Map_01 {

	/*
	 * ** MAP ** 개념
	 * 
	 ** 1. Map + String(getOrDefault())
	 ** 2. Map + Array
	 ** 3. Map + Math.max
	 * 4. Map + Set
	 * 5. Map + Map
	 * 6. Set + Set
	 * 
	 * */
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		
		//1.keySet
		System.out.println("-------------1.keySet");
		for (Integer key : map.keySet()) { //key Set으로 받기
			System.out.println("key : " + key + "  value : " + map.get(key));
		}
		
		System.out.println();
		
		//2.entrySet
		System.out.println("-------------2.entrySet");
		for(Map.Entry<Integer, String> elem : map.entrySet()) { //entry Set으로 받기
			System.out.println("key : " + elem.getKey() + "  value : " + elem.getValue());
		}
		
		System.out.println();
		
		//3.Iterator
		System.out.println("-------------3.Iterator");
		Iterator<Integer> keys = map.keySet().iterator();
		while (keys.hasNext()) {
			Integer key = keys.next();
			System.out.println("key : " + key + "  value : " + map.get(key));
		}
		
	}

}



