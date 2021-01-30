import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//1.
class Interval {
	int start;
	int end;
	
	Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}

public class Sort_Comparator {

	public static void main(String[] args) {
		// Comparator : 특정 객체값을 비교해서 sorting

		//2차원 배열에서 중복을 제거 (범위가 겹칠시 하나로 합친다.)
		// before.end >= curr.start
		// before.end = Math.max(curr.end, before.end);
		
		//1. 클래스(Interval)
		//2. 리스트화(자료)
		//3. Comparator(버전)
		//4. 현재 start < 이전 end, 새롭게 합친값을 만든다.
		
		
//		int[][] arr = {
//				{1,3},
//				{2,6},
//				{8,10},
//				{15,18}
//		};
		Interval in1 = new Interval(1,3);
		Interval in2 = new Interval(2,6);
		Interval in3 = new Interval(8,10);
		Interval in4 = new Interval(15,18);
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(in1);
		intervals.add(in2);
		intervals.add(in3);
		intervals.add(in4);
		Sort_Comparator a = new Sort_Comparator();
		List<Interval> list = a.merge(intervals);
		a.print(list);
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty()) {
			return intervals;
		}
		
		//1. input값이 순차적이지 않을 수 있으므로 sorting을 먼저 해준다.
//		Collections.sort(intervals, comp2); //older java
		Collections.sort(intervals, (a,b)-> a.start-b.start); //오름차순 . java 1.8 아래 Comparator와 동일 
		
		List<Interval> result = new ArrayList<>();
		Interval before = intervals.get(0); //for문에 넣고 비교할 수 없어서 최초값 1개를 꺼내놓고 비교한다.
		for (int i=1; i<intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (before.end >= curr.start) {
				before.end = Math.max(curr.end, before.end);
			} else {
				result.add(before);
				before = curr;
			}
		}
		if (!result.contains(before)) {
			result.add(before);
		}
		
		return result;
	}
	
	//older version1
	Comparator comp = new Comparator<Interval>() {//오름차순
		@Override
		public int compare(Interval a, Interval b) {
			return a.start-b.start; 
		}
	};
	//older version2
	Comparator comp2 = new Comparator<Interval>() {//오름차순
		@Override
		public int compare(Interval a, Interval b) {
			if (a.start < b.start) {
				return -1;
			} else if (a.start > b.start) { 
				return 1;
			} else {
				return 0;
			}
		}
	};
	
	void print(List<Interval> list) {
		for(int i=0; i<list.size(); i++) {
			Interval in = list.get(i);
			System.out.println(in.start + " " + in.end);
		}
	}

}

//Collection sort 3가지

	//1
	// Collections.sort(intervals, (a,b) -> a.start-b.start);
	
	
	
	//2
	// Collections.sort(intervals, comp2);
	
	//	Comparator<Interval> comp2 = new Comparator<Interval>() {
	//		@Override
	//		public int compare(Interval o1, Interval o2) {
	//			if (o1.start > o2.start) {
	//				return 1;
	//			} else if (o1.start < o2.start) {
	//				return -1;
	//			} else {
	//				return 0;
	//			}
	//		}
	//	};
	
	
	
	//3
	// Comparator comp = new Comparator<Interval>() {

	//	Comparator comp = new Comparator<Interval>() {
	//		public int com;pare(Interval a, Interval b) {
	//			return a.start - b.start;
	//		}
	//	}