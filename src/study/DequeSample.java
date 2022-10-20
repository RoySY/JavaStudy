package study;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DequeSample {
	
	// Stack, Queue, Deque

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> stack1 = new ArrayDeque<>(); // addFirst + removeFirst // ����
		
		stack1.addFirst(1);
		stack1.addFirst(2);
		stack1.addFirst(3);
		
//		stack1.add(4); // add�� addLast�� ���� // addFirst�� �װ� �־��µ� �� ����� �ݴ� ���⿡ �߰� 4, 1, 2, 3�� ��
//		stack1.addFirst(5); // 1, 2, 3�� ���� �������� �߰� // 4, 1, 2, 3, 5
//		stack1.addLast(6); // addFirst�� �ݴ� �������� �߰� // 6, 4, 1, 2, 3, 5
		
		System.out.println("stack1"); // stack1
		
		System.out.println(stack1.peekFirst()); // 3
		System.out.println(stack1.removeFirst()); // 3
		System.out.println(stack1.removeFirst()); // 2
		System.out.println(stack1.removeFirst()); // 1
		
		Deque<Integer> queue1 = new ArrayDeque<>(); // addFirst + removeLast // ť
		
		queue1.addFirst(1);
		queue1.addFirst(2);
		queue1.addFirst(3);
		
		System.out.println("queue1"); // queue1
		
		System.out.println(queue1.peekLast()); // 1
		System.out.println(queue1.removeLast()); // 1
		System.out.println(queue1.removeLast()); // 2
		System.out.println(queue1.removeLast()); // 3
		
		Deque<Integer> queue2 = new ArrayDeque<>(); // addLast + removeFirst // ť
		
		queue2.addLast(1);
		queue2.addLast(2);
		queue2.addLast(3);
		
		System.out.println("queue2"); // queue2
		
		System.out.println(queue2.peekFirst()); // 1
		System.out.println(queue2.removeFirst()); // 1
		System.out.println(queue2.removeFirst()); // 2
		System.out.println(queue2.removeFirst()); // 3
		
		Deque<Integer> stack2 = new ArrayDeque<>(); // addLast + removeLast // ����
		
		stack2.addLast(1);
		stack2.addLast(2);
		stack2.addLast(3);
		
		System.out.println("stack2"); // stack2
		
		System.out.println(stack2.peekLast()); // 3
		System.out.println(stack2.removeLast()); // 3
		System.out.println(stack2.removeLast()); // 2
		System.out.println(stack2.removeLast()); // 1
		
		// Deque �ڷᱸ������ Ȯ���� �� �ִ� ���
		// add(A) + peek(B) or remove(B)�� ���� �� // (A)�� (B)�� First �Ǵ� Last
		// (A)�� (B)�� ���ٸ� ����(Stack)ó�� ����
		// (A)�� (B)�� �ٸ��ٸ� ť(Queue)ó�� ����
		// First + First, Last + Last => ����(Stack)
		// First + Last, Last + First => ť(Queue)
		// addFirst�� �װ� �ִ� �������� ���� �տ� ���Ҹ� �߰��ϰ� �ʹٸ� addLast�� �߰�
		// addLast�� �װ� �ִ� �������� ���� �տ� ���Ҹ� �߰��ϰ� �ʹٸ� addFirst�� �߰�
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println("Original Stack"); // Original Stack
		System.out.println(stack.peek()); // 3
		System.out.println(stack.pop()); // 3
		System.out.println(stack.pop()); // 2
		System.out.println(stack.pop()); // 1
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		System.out.println("Original Queue"); // Original Queue
		System.out.println(queue.peek()); // 1
		System.out.println(queue.poll()); // 1
		System.out.println(queue.poll()); // 2
		System.out.println(queue.poll()); // 3
	}
}
