package study;

import java.util.*;

public class Map3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap hm = new HashMap();
		
		hm.put("김자바", new Integer(90));
		hm.put("이자바", new Integer(100));
		hm.put("강자바", new Integer(80));
		hm.put("최자바", new Integer(90));
		
		Set set = hm.entrySet();
		// 모든 컬렉션 인터페이스를 구현하고 있는 클래스들이 공통적으로 가진 API(인터페이스) 중 Iterator // List, Set 등(컬렉션 인터페이스를 구현)에서 사용 가능
		Iterator it = set.iterator(); // 반복자 // 컨테이너에 담겨져있는 값들을 하나하나 꺼내서 하나하나 어떠한 처리를 할 수 있도록 해줌
		// Iterator는 인터페이스이며, 3개의 메소드를 가진다. hasNext(), next(), remove()
		
		System.out.println(set); // [김자바=90, 강자바=80, 최자바=90, 이자바=100]
		
		while(it.hasNext()) {
			// 여기서 it는 가상의 컨테이너이며 next를 할 때마다 it에서 하나씩 사라진다.
			System.out.println(it.next()); // 김자바=90 // 강자바=80 // 최자바=90 // 이자바=100
		}
		
		Collection values = hm.values();
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			int i = (int)it.next();
			total += i;
		}
		
		System.out.println("총점 : " + total); // 총점 : 360
		
		// 컬렉션 프레임워크
		ArrayList<Integer> A = new ArrayList<Integer>(); // 우변이 같거나 더 디테일해야함
		HashSet<Integer> B = new HashSet<Integer>(); // 우변이 같거나 더 디테일해야함
		Collection<Integer> C = new ArrayList<Integer>(); // 우변이 같거나 더 디테일해야함
		Collection<Integer> D = new HashSet<Integer>(); // 우변이 같거나 더 디테일해야함
		
		Iterator itA = A.iterator();
		Iterator itB = B.iterator();
		Iterator itC = C.iterator();
		Iterator itD = D.iterator();
	}
}