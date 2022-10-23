package study;

import java.util.*;

// ��ǻ�� ���п��� ���� �⺻�� �Ǵ� �ڷᱸ�� 2���� Stack & Queue
public class StackAndQueue {
	
	// Stack (�����۽� ���� ��) (Last In First Out) ���ʸ� �շ��ִ� ��
	// push(�߰�), pop(������ ����), peek(������ �ʰ� ���� �������� ���� �� Ȯ��) // �迭, ��ũ�� ����Ʈ �� �迭�� �� ȿ���� why? ���� ����, ���� ����
	Stack st = new Stack(); // Stack�� Ŭ������ �ֱ� ������ ��ü ���� ����
	Stack<Integer> stack = new Stack<Integer>();
	
	// Queue (���� â��) (First In First Out) ������ �շ��ִ� ��
	// offer(�߰�), poll(������ ����) : ��������� null ��ȯ, peek(������ �ʰ� ���� ó���� ���� �� Ȯ��) // �迭, ��ũ�� ����Ʈ �� ��ũ�� ����Ʈ�� �� ȿ���� why? ������ �������� ������ �ռ� ���� ���� ���� �� �ڿ� ���� �͵��� ��ġ ���� �ʿ�
	// add(�߰�) : ���� �߻�, remove(������ ����) : ���� �߻�, element(������ �ʰ� ���� ó���� ���� �� Ȯ��) : ���� �߻�
	// ��ũ�� ����Ʈ�� ��Ҹ� �����ص� ���Ḹ �ٲ��ָ� �ǹǷ� �ڸ� �̵��� �ʿ� ����.
	// �������̽��� ���ǰ� �Ǿ��ֱ� ������ Queue q = new Queue(); �̷��� ��ü ���� �Ұ� // Queue�� ����� ���� ��ü�� ���� �ȴ�.
	Queue q = new LinkedList(); // Queue�� ������ Ŭ���� ���
	Queue<Integer> queue = new LinkedList<Integer>();
	
	public void exampleFunction() {
		stack.push(7); // 7
		stack.push(2); // 7 2
		stack.push(1); // 7 2 1
		stack.peek(); // 1 // ������ �������� ���� Ȯ�� // stack�� 7 2 1 �״��
		stack.peek(); // 1 // ������ �������� ���� Ȯ�� // stack�� 7 2 1 �״��
		stack.pop(); // 1 // ���� ���� Ȯ�� // stack�� 7 2 ����
		
		queue.offer(7); // 7
		queue.offer(2); // 7 2
		queue.offer(1); // 7 2 1
		queue.peek(); // 7 // ������ �������� ���� Ȯ�� // queue�� 7 2 1 �״��
		queue.peek(); // 7 // ������ �������� ���� Ȯ�� // queue�� 7 2 1 �״��
		queue.poll(); // 7 // ���� ���� Ȯ�� // queue�� 2 1 ����
		
		System.out.println(stack); // 7, 2
		System.out.println(stack.peek()); // 2
		System.out.println(stack); // 7, 2
		System.out.println(stack.pop()); // 2
		System.out.println(stack); // 7
		
		System.out.println(queue); // 2, 1
		System.out.println(queue.peek()); // 2
		System.out.println(queue); // 2, 1
		System.out.println(queue.poll()); // 2
		System.out.println(queue); // 1
	}
	
	// �̷��� �ܿ��� !
	// stack�� ���� ���̾� �������� push�ؼ� ���ϰ� �־��ְ� �� �ݵ����� ������ pop���� ���ϰ� Ƣ����� �Ѵ�.
	// queue�� �� ����� �ŷ��� �� ����� offer�� �����ϰ� �ٸ� ����� poll(pull : ����)�� �޴´�.
	// ���� ���� ���� ���ڴ� peek(peak : �����)�� Ȯ���Ѵ�.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
