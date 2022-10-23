package study;

import java.util.*;

// 컴퓨터 공학에서 가장 기본이 되는 자료구조 2가지 Stack & Queue
public class StackAndQueue {
	
	// Stack (프링글스 과자 통) (Last In First Out) 한쪽만 뚫려있는 통
	// push(추가), pop(꺼내서 삭제), peek(꺼내지 않고 제일 마지막에 들어온 거 확인) // 배열, 링크드 리스트 중 배열이 더 효율적 why? 순차 저장, 순차 삭제
	Stack st = new Stack(); // Stack은 클래스가 있기 때문에 객체 생성 가능
	Stack<Integer> stack = new Stack<Integer>();
	
	// Queue (은행 창구) (First In First Out) 양쪽이 뚫려있는 통
	// offer(추가), poll(꺼내서 삭제) : 비어있으면 null 반환, peek(꺼내지 않고 제일 처음에 들어온 거 확인) // 배열, 링크드 리스트 중 링크드 리스트가 더 효율적 why? 저장은 문제되지 않지만 앞서 들어온 것을 삭제 시 뒤에 들어온 것들의 위치 조정 필요
	// add(추가) : 예외 발생, remove(꺼내서 삭제) : 예외 발생, element(꺼내지 않고 제일 처음에 들어온 거 확인) : 예외 발생
	// 링크드 리스트는 요소를 삭제해도 연결만 바꿔주면 되므로 자리 이동이 필요 없다.
	// 인터페이스로 정의가 되어있기 때문에 Queue q = new Queue(); 이렇게 객체 생성 불가 // Queue의 기능을 가진 객체를 쓰면 된다.
	Queue q = new LinkedList(); // Queue를 구현한 클래스 사용
	Queue<Integer> queue = new LinkedList<Integer>();
	
	public void exampleFunction() {
		stack.push(7); // 7
		stack.push(2); // 7 2
		stack.push(1); // 7 2 1
		stack.peek(); // 1 // 다음에 빠져나갈 숫자 확인 // stack은 7 2 1 그대로
		stack.peek(); // 1 // 다음에 빠져나갈 숫자 확인 // stack은 7 2 1 그대로
		stack.pop(); // 1 // 빼넨 숫자 확인 // stack은 7 2 남아
		
		queue.offer(7); // 7
		queue.offer(2); // 7 2
		queue.offer(1); // 7 2 1
		queue.peek(); // 7 // 다음에 빠져나갈 숫자 확인 // queue는 7 2 1 그대로
		queue.peek(); // 7 // 다음에 빠져나갈 숫자 확인 // queue는 7 2 1 그대로
		queue.poll(); // 7 // 빼넨 숫자 확인 // queue는 2 1 남아
		
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
	
	// 이렇게 외우자 !
	// stack은 팝콘 통이야 옥수수를 push해서 강하게 넣어주고 그 반동으로 팝콘을 pop으로 강하게 튀어나오게 한다.
	// queue는 두 사람의 거래야 한 사람이 offer로 제공하고 다른 사람이 poll(pull : 당기다)로 받는다.
	// 가장 먼저 나갈 숫자는 peek(peak : 꼭대기)로 확인한다.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
