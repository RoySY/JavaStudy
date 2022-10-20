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
		Deque<Integer> stack1 = new ArrayDeque<>(); // addFirst + removeFirst // 스택
		
		stack1.addFirst(1);
		stack1.addFirst(2);
		stack1.addFirst(3);
		
//		stack1.add(4); // add는 addLast와 같음 // addFirst로 쌓고 있었는데 그 방향과 반대 방향에 추가 4, 1, 2, 3이 됨
//		stack1.addFirst(5); // 1, 2, 3과 같은 방향으로 추가 // 4, 1, 2, 3, 5
//		stack1.addLast(6); // addFirst와 반대 방향으로 추가 // 6, 4, 1, 2, 3, 5
		
		System.out.println("stack1"); // stack1
		
		System.out.println(stack1.peekFirst()); // 3
		System.out.println(stack1.removeFirst()); // 3
		System.out.println(stack1.removeFirst()); // 2
		System.out.println(stack1.removeFirst()); // 1
		
		Deque<Integer> queue1 = new ArrayDeque<>(); // addFirst + removeLast // 큐
		
		queue1.addFirst(1);
		queue1.addFirst(2);
		queue1.addFirst(3);
		
		System.out.println("queue1"); // queue1
		
		System.out.println(queue1.peekLast()); // 1
		System.out.println(queue1.removeLast()); // 1
		System.out.println(queue1.removeLast()); // 2
		System.out.println(queue1.removeLast()); // 3
		
		Deque<Integer> queue2 = new ArrayDeque<>(); // addLast + removeFirst // 큐
		
		queue2.addLast(1);
		queue2.addLast(2);
		queue2.addLast(3);
		
		System.out.println("queue2"); // queue2
		
		System.out.println(queue2.peekFirst()); // 1
		System.out.println(queue2.removeFirst()); // 1
		System.out.println(queue2.removeFirst()); // 2
		System.out.println(queue2.removeFirst()); // 3
		
		Deque<Integer> stack2 = new ArrayDeque<>(); // addLast + removeLast // 스택
		
		stack2.addLast(1);
		stack2.addLast(2);
		stack2.addLast(3);
		
		System.out.println("stack2"); // stack2
		
		System.out.println(stack2.peekLast()); // 3
		System.out.println(stack2.removeLast()); // 3
		System.out.println(stack2.removeLast()); // 2
		System.out.println(stack2.removeLast()); // 1
		
		// Deque 자료구조에서 확인할 수 있는 사실
		// add(A) + peek(B) or remove(B)가 있을 때 // (A)와 (B)는 First 또는 Last
		// (A)와 (B)가 같다면 스택(Stack)처럼 동작
		// (A)와 (B)가 다르다면 큐(Queue)처럼 동작
		// First + First, Last + Last => 스택(Stack)
		// First + Last, Last + First => 큐(Queue)
		// addFirst로 쌓고 있는 구조에서 제일 앞에 원소를 추가하고 싶다면 addLast로 추가
		// addLast로 쌓고 있는 구조에서 제일 앞에 원소를 추가하고 싶다면 addFirst로 추가
		
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
