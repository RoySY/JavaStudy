package study;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 우선순위큐는 큐와 달리 우선순위대로 정렬되어 들어감 // 즉, 따로 정렬할 필요가 없다.
		PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(); // 숫자 오름차순 : 1, 2, 3, 4
		
		PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());// 숫자 내림차순 : 4, 3, 2, 1
		
		PriorityQueue<String> priorityQueue3 = new PriorityQueue<>(); // 문자 오름차순 : A, B, C, D
		
		PriorityQueue<String> priorityQueue4 = new PriorityQueue<>(Collections.reverseOrder()); // 문자 내림차순 : D, C, B, A
		
		priorityQueue1.offer(2);
		priorityQueue1.offer(1);
		priorityQueue1.offer(3); // 이미 정렬된 상태
		
		System.out.println(priorityQueue1.peek()); // 1
		System.out.println(priorityQueue1.poll()); // 1
		System.out.println(priorityQueue1.poll()); // 2
		
		priorityQueue2.offer(2);
		priorityQueue2.offer(1);
		priorityQueue2.offer(3);
		
		System.out.println(priorityQueue2.peek()); // 3
		System.out.println(priorityQueue2.poll()); // 3
		System.out.println(priorityQueue2.poll()); // 2
		
		priorityQueue3.offer("ABC");
		priorityQueue3.offer("ACE");
		priorityQueue3.offer("BCD");
		
		System.out.println(priorityQueue3.peek()); // ABC
		System.out.println(priorityQueue3.poll()); // ABC
		System.out.println(priorityQueue3.poll()); // ACE
		
		
		priorityQueue4.offer("ABC");
		priorityQueue4.offer("ACE");
		priorityQueue4.offer("BCD");
		
		System.out.println(priorityQueue4.peek()); // BCD
		System.out.println(priorityQueue4.poll()); // BCD
		System.out.println(priorityQueue4.poll()); // ACE
	}
}