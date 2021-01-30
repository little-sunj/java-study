
public class Sort_01 {

	public static void main(String[] args) {
		
		/*
		 * *sort
		 * 
		 * 1. compareTo()
		 * 
		 * 		public int compareTo() {
		 * 			return A.compareTo(B);
		 * 		}
		 * 		- A와 B가 같으면 0
		 * 		- A > B 면 1
		 * 		- A < B면 -1 오름차순 (ex 1 2 3 이라면 2-3은 -1 음수)
		 * 
		 * 
		 * 2. Comparator
		 * 
		 * 		//1
		 * 		Comparator<Interval> Comp2 = new Comparator<Interval>() {
		 * 			@Override
		 * 			public int compare(Interval o1, Interval o2) {
		 * 				//
		 * 				return o1.end - o2.end;
		 * 			}
		 * 		};
		 * 
		 * 		//2
		 * 		Comparator<Interval> comp = new Comparator<Interval>() {
		 * 			@Override
		 * 			public int compar(Interval o1, Interval o2) {
		 * 				if(o1.end > o2.end) {
		 * 					return 1;
		 * 				} else if (o1.end < o2.end) {
		 * 					return -1;
		 * 				} else {
		 * 					return 0;
		 * 				}
		 * 			}
		 * 		};
		 * 
		 * 
		 * 3. PriorityQueue 시간 복잡도 (O(longn))
		 * 4. Binary Search 시간 복잡도 (O(longn))
		 * 
		 * */

	}

}
