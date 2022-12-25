package study;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �켱����ť�� ť�� �޸� �켱������� ���ĵǾ� �� // ��, ���� ������ �ʿ䰡 ����.
		PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(); // ���� �������� : 1, 2, 3, 4
		
		PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());// ���� �������� : 4, 3, 2, 1
		
		PriorityQueue<String> priorityQueue3 = new PriorityQueue<>(); // ���� �������� : A, B, C, D
		
		PriorityQueue<String> priorityQueue4 = new PriorityQueue<>(Collections.reverseOrder()); // ���� �������� : D, C, B, A
		
		priorityQueue1.offer(2);
		priorityQueue1.offer(1);
		priorityQueue1.offer(3); // �̹� ���ĵ� ����
		
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