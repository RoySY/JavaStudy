package study;

import java.util.HashMap;

public class Map1 {
	
	// Map(Collections framework)
	// Key�� Value�� �����Ǹ�, �ð� ���⵵�� O(1)
	// Key & Value ������ �ֹε�Ϲ�ȣ & ����̸� ���İ� ����ϴٰ� ���� �ȴ�. Key�� �ߺ� ���x, Value�� �ߺ� ���o
	// Map�� �������̽��� ����Ǿ� �ְ�, Map�� ������ ���� Ŭ�������� �ִ�.
	// HashTable(������, ����ȭo), HashMap(�Ź���, ����ȭx)
	// HashMap : Map�������̽��� ������ ��ǥ���� �÷��� Ŭ����, ������ �����Ϸ���, LinkedHashMapŬ������ ����ϸ� �ȴ�.
	// TreeMap(TreeSet�� ���� Ư���� ����) : ���� �˻��� ���Ŀ� ������ �÷��� Ŭ����, HashMap���� ������ �߰�, ������ �ð��� �� �ɸ���.(�� ������ �ϱ� ����)
	// HashMap : �ؽ̱������ �����͸� ����, �����Ͱ� ���Ƶ� �˻��� ������.
	// �ؽ̱�� : �ؽ��Լ��� �̿��� �ؽ����̺� �����͸� ���� & �о����
	// �ؽ����̺� : �迭(���� : ���ټ�)�� ��ũ�� ����Ʈ(���� : ���濡 ����)�� ���յ� ����
	// Key�� �ؽ��Լ��� ȣ���ؼ� �ؽ��ڵ带 ��´�.(ĳ��� ��ȣ) -> �迭���� �ؽ��ڵ忡 �����ϴ� ��ũ�� ����Ʈ�� ã�´�. -> ��ũ�� ����Ʈ���� Key�� ��ġ�ϴ� �����͸� ã�´�.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("one", 1); // Key, Value
		hm.put("two", 2);
		hm.put("two", 3); // ������ Key���� �ԷµǸ� �����
		
		System.out.println(hm.get("one")); // 1
		System.out.println(hm.get("two")); // 3
		System.out.println(hm.entrySet()); // [one=1, two=3]
		System.out.println(hm.keySet()); // [one, two]
		System.out.println(hm.values()); // [1, 3]
		System.out.println(hm.getOrDefault("two", 999)); // 3
		System.out.println(hm.getOrDefault("three", 999)); // 999 // Key���� ���� ����� ��
		System.out.println(hm.containsKey("one")); // true // �ش� Key���� �ִ���
		System.out.println(hm.containsValue(3)); // true // �ش� Value���� �ִ���
		System.out.println(hm.size()); // 2 // ũ��
		System.out.println(hm.isEmpty()); // false // ������� Ȯ��
		
		hm.clear(); // �ʱ�ȭ
		
		System.out.println(hm.entrySet()); // []
		
		HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
		
		hm2.putAll(hm);
		
		System.out.println(hm2.get("one")); // 1
		System.out.println(hm2.get("two")); // 3
		
		hm2.remove("two"); // ����
		
		System.out.println(hm2.get("one")); // 1
		System.out.println(hm2.get("two")); // null
		
		hm2.replace("one", 3); // ����
		
		System.out.println(hm2.get("one")); // 3
		System.out.println(hm2.get("two")); // null
	}
}