package study;

import java.util.LinkedList;

public class TheFirstCache {
	
	// [1��] ĳ��
	// LRU(Least Recently Used) : ���� �������� �������� ���� �������� ��ü�ϴ� ���
	// ĳ�ð� ���� á�� ��, ���� �������� �������� ���� �������� ã�Ƽ� ���ִ� ������ �ʿ�
	
	public static void linkedListTest() {
		
		// add, remove(���� �� Exception �߻�), element
		// offer, poll(���� �� null ����), peek
		// LinkedList�� ��� add, remove, offer, poll�� (A)�� ����� (A), (A)First, (A)Last�� �����ϴ�.
		// remove�� ��� remove("A")�� ���� ���� ������ ����������, poll�� ��� poll("A")�� ���� ���� ������ �Ұ����ϴ�.
		
		// 1. add & remove & element
		LinkedList<String> linkedList1 = new LinkedList<>();
		
		linkedList1.add("A"); // linkedList1.element() => A
		linkedList1.add("B"); // linkedList1.element() => A
		linkedList1.add("C"); // linkedList1.element() => A
		linkedList1.add("D"); // linkedList1.element() => A
		
		System.out.println(linkedList1.element()); // A
		
		linkedList1.remove(); // A
		
		System.out.println(linkedList1.element()); // B
		
		linkedList1.remove("C"); // C
		
		System.out.println(linkedList1.element()); // B
		
		// 2. add, addFirst, addLast & remove, removeFirst, removeLast & element
		LinkedList<String> linkedList2 = new LinkedList<>();
		
		linkedList2.add("A"); // linkedList2.element() => A
		linkedList2.addFirst("B"); // linkedList2.element() => B
		linkedList2.add("C"); // linkedList2.element() => B
		linkedList2.addLast("D"); // linkedList2.element() => B
		linkedList2.add("E"); // linkedList2.element() => B
		
		System.out.println(linkedList2.element()); // B
		
		linkedList2.removeFirst(); // B
		
		System.out.println(linkedList2.element()); // A
		
		linkedList2.removeLast(); // E
		
		linkedList2.remove("C"); // C
		
		System.out.println(linkedList2.element()); // A
		
		// 3. offer & poll & peek
		LinkedList<String> linkedList3 = new LinkedList<>();
		
		linkedList3.offer("A"); // linkedList3.peek() => A
		linkedList3.offer("B"); // linkedList3.peek() => A
		linkedList3.offer("C"); // linkedList3.peek() => A
		linkedList3.offer("D"); // linkedList3.peek() => A
		
		System.out.println(linkedList3.peek()); // A
		
		linkedList3.poll(); // A
		
		System.out.println(linkedList3.peek()); // B
		
//		linkedList3.poll("C"); // ���� ���� �Ұ�
		
		// 4. offer, offerFirst, offerLast & poll, pollFirst, pollLast & peek
		LinkedList<String> linkedList4 = new LinkedList<>();
		
		linkedList4.offer("A"); // linkedList4.peek() => A
		linkedList4.offerFirst("B"); // linkedList4.peek() => B
		linkedList4.offer("C"); // linkedList4.peek() => B
		linkedList4.offerLast("D"); // linkedList4.peek() => B
		linkedList4.offer("E"); // linkedList4.peek() => B
		
		System.out.println(linkedList4.peek()); // B
		
		linkedList4.pollFirst(); // B
		
		System.out.println(linkedList4.peek()); // A
		
		linkedList4.pollLast(); // E
		
//		linkedList4.poll("C"); // ���� ���� �Ұ�
		
		System.out.println(linkedList4.peek()); // A
	}
	
	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		String city = "";
		
		LinkedList<String> cache = new LinkedList<>();
		
		if (cacheSize == 0) {
			return cities.length * 5;
		}
		
		for (int i = 0; i < cities.length; i++) {
			
			city = cities[i].toLowerCase();
			
			if (cache.remove(city)) { // cache hit
				cache.addFirst(city); // ���� �� �ٽ� �߰��Ͽ� �ֽ�ȭ
				answer += 1;
			} else { // cache miss
				
				if (cache.size() == cacheSize) {
					cache.removeLast(); // ���� ������ �� ����
				}
				
				cache.addFirst(city);
				answer += 5;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		
		System.out.println(solution(cacheSize, cities));
	}
}