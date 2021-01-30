import java.util.PriorityQueue;

public class Sort_PriorityQueue {

	public static void main(String[] args) {
		// 두 막대기를 연결. 하나만 남을 때까지 모든 스틱을 연결하는 최소 비용 반환.

		Sort_PriorityQueue a = new Sort_PriorityQueue();
		int[] sticks = {1,8,2,5};
		
		System.out.println(a.pgSticks(sticks));
	}
	
	public int pgSticks(int[] sticks) {
		PriorityQueue<Integer> pg = new PriorityQueue<>(); //minHeap (맨 꼭대기 작은값)
		for (int i: sticks) {
			pg.offer(i);
		}
		
		int sum = 0;
		while(pg.size() > 1) {
			int twoSum = pg.poll() + pg.poll();
			sum += twoSum;
			pg.offer(twoSum);
		}
		
		
		return sum;
	}

}


/*
//int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

//int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

//String형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<String> priorityQueue = new PriorityQueue<>(); 

//String형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<String> priorityQueue = new PriorityQueue<>(Collections.reverseOrder())
 * 
 * 참고 : https://coding-factory.tistory.com/603
 * 
 * 
 * 값 추가 : 즉시 정렬된다.
 * 1. add(value) 
 * 		- 삽입 성공시 true 반환
 *  	- 큐에 여유공간이 없어 삽입에 실패하면 Exception 발생 (IllegalStateException)
 * 2. offer(value)
 * 		
 *  
 * 값 삭제 : 우선 순위가 가장 높은 값이 제거된다.
 * 1. poll()
 * 		- 우선순위 큐가 비어있으면 null반환
 * 2. remove()
 * 		
 * - pop을 하면 가장 앞쪽에 있는 원소의 값이 제거된다.
 * 
 * 모든 요소 제거
 * clear()
 * 
 * 우선 순위가 가장 높은 값을 참조하고 싶은 경우
 * peek()
 * 
 */