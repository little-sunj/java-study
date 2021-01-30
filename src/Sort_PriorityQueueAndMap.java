import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Sort_PriorityQueueAndMap {

	public static void main(String[] args) {
		// 주어진 숫자와 같은 빈도로 출현하는 값을 리턴
		// 개수가 동일할 경우 알파벳 순으로 비교
		
		/*
		 * 1. Value가 내림차순 (descend) 이어야 한다.
		 * b.getValue() - a.getValue()
		 * b.getValue.compareTo(a.getValue())
		 * 
		 * 2. Value가 동일하면 key가 알파벳 순 (오름차순)
		 * a.getValue() == b.getValue()
		 * a.getKey().compareTo(b.getKey())
		 * 
		 * 결과
		 * a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey());
		 * a.getValue()-b.getValue()
		 * */
		
		int k = 2;
		String[] words = {"a", "b", "c", "a", "b", "c", "a"}; 
		Sort_PriorityQueueAndMap a = new Sort_PriorityQueueAndMap();
		
		System.out.println(a.solve(words, k));
	}
	
	public List<String> solve(String[] words, int k) {
		//1. DS
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		
		// map에 넣기
		for(String w : words) {
			map.put(w, map.getOrDefault(w, 0)+1);
		}
		
		// PQ 람다 java 1.8
		Queue<Map.Entry<String, Integer>> pg = new PriorityQueue<>(
				(a,b)-> a.getValue() == b.getValue() ?  a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
		);
		
		// older than 1.8 java  pg comparator
//		Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>() {
//			@Override
//			public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
//				if (a.getValue() == b.getValue()) {
//					return a.getKey().compareTo(b.getKey());
//				}
//				return b.getValue() - a.getValue();
//			}
//		};
//		Queue<Map.Entry<String, Integer>> pg = new PriorityQueue<>(comp);
		
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			pg.offer(entry);
		}
		
		while(k>0) {
			result.add(pg.poll().getKey());
			k--;
		}
		
		return result;
	}

}
