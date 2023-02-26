package study;

import java.util.LinkedList;

public class TheFirstCache {
	
	// [1차] 캐시
	// LRU(Least Recently Used) : 가장 오랫동안 참조되지 않은 페이지를 교체하는 방식
	// 캐시가 가득 찼을 때, 가장 오랫동안 참조되지 않은 페이지를 찾아서 없애는 과정이 필요
	
	public static void linkedListTest() {
		
		// add, remove(실패 시 Exception 발생), element
		// offer, poll(실패 시 null 리턴), peek
		// LinkedList의 경우 add, remove, offer, poll을 (A)로 사용해 (A), (A)First, (A)Last가 가능하다.
		// remove의 경우 remove("A")와 같이 지정 삭제가 가능하지만, poll의 경우 poll("A")와 같이 지정 삭제가 불가능하다.
		
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
		
//		linkedList3.poll("C"); // 지정 삭제 불가
		
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
		
//		linkedList4.poll("C"); // 지정 삭제 불가
		
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
				cache.addFirst(city); // 제거 후 다시 추가하여 최신화
				answer += 1;
			} else { // cache miss
				
				if (cache.size() == cacheSize) {
					cache.removeLast(); // 가장 오래된 것 제거
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