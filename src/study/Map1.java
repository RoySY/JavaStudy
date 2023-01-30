package study;

import java.util.HashMap;

public class Map1 {
	
	// Map(Collections framework)
	// Key와 Value로 구성되며, 시간 복잡도는 O(1)
	// Key & Value 형식은 주민등록번호 & 사람이름 형식과 비슷하다고 보면 된다. Key는 중복 허용x, Value는 중복 허용o
	// Map은 인터페이스로 선언되어 있고, Map을 구현한 여러 클래스들이 있다.
	// HashTable(구버전, 동기화o), HashMap(신버전, 동기화x)
	// HashMap : Map인터페이스를 구현한 대표적인 컬렉션 클래스, 순서를 유지하려면, LinkedHashMap클래스를 사용하면 된다.
	// TreeMap(TreeSet과 같은 특성을 가짐) : 범위 검색과 정렬에 유리한 컬렉션 클래스, HashMap보다 데이터 추가, 삭제에 시간이 더 걸린다.(비교 저장을 하기 때문)
	// HashMap : 해싱기법으로 데이터를 저장, 데이터가 많아도 검색이 빠르다.
	// 해싱기법 : 해시함수를 이용해 해시테이블에 데이터를 저장 & 읽어오기
	// 해시테이블 : 배열(장점 : 접근성)과 링크드 리스트(장점 : 변경에 유리)가 조합된 형태
	// Key로 해시함수를 호출해서 해시코드를 얻는다.(캐비넷 번호) -> 배열에서 해시코드에 대응하는 링크드 리스트를 찾는다. -> 링크드 리스트에서 Key와 일치하는 데이터를 찾는다.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("one", 1); // Key, Value
		hm.put("two", 2);
		hm.put("two", 3); // 동일한 Key값이 입력되면 덮어쓰기
		
		System.out.println(hm.get("one")); // 1
		System.out.println(hm.get("two")); // 3
		System.out.println(hm.entrySet()); // [one=1, two=3]
		System.out.println(hm.keySet()); // [one, two]
		System.out.println(hm.values()); // [1, 3]
		System.out.println(hm.getOrDefault("two", 999)); // 3
		System.out.println(hm.getOrDefault("three", 999)); // 999 // Key값이 없을 경우의 값
		System.out.println(hm.containsKey("one")); // true // 해당 Key값이 있는지
		System.out.println(hm.containsValue(3)); // true // 해당 Value값이 있는지
		System.out.println(hm.size()); // 2 // 크기
		System.out.println(hm.isEmpty()); // false // 비었는지 확인
		
		hm.clear(); // 초기화
		
		System.out.println(hm.entrySet()); // []
		
		HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
		
		hm2.putAll(hm);
		
		System.out.println(hm2.get("one")); // 1
		System.out.println(hm2.get("two")); // 3
		
		hm2.remove("two"); // 삭제
		
		System.out.println(hm2.get("one")); // 1
		System.out.println(hm2.get("two")); // null
		
		hm2.replace("one", 3); // 변경
		
		System.out.println(hm2.get("one")); // 3
		System.out.println(hm2.get("two")); // null
	}
}