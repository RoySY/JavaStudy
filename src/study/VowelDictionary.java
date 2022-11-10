package study;

import java.util.HashMap;

public class VowelDictionary {
	
	// ��������
	
	public static int solution(String word) {
		int answer = 0;
		
		HashMap<Character, Integer> hm = new HashMap<>();
		
		hm.put('A', 0);
		hm.put('E', 1);
		hm.put('I', 2);
		hm.put('O', 3);
		hm.put('U', 4);
		
		// A     1
		// AA    2
		// AAA   3
		// AAAA  4
		// AAAAA 5
		// AAAAE 6   (AAAAA���� + 1) (+ 1)
		// ...
		// AAAAU 9
		// AAAE  10  (AAAA���� + 6) (1 + 5)
		// AAAEA 11
		// AAAEU 15
		// AAAI  16
		// ...
		// AAAO  22
		// ...
		// AAAU  28
		// AAAUA 29
		// ...
		// AAAUU 33
		// AAE   34  (AAA���� + 31) (1 + 5 + 25)
		// AAEA  35
		// AAEAA 36
		// ...
		// AAI   65
		// ...
		// AE    158 (AA���� + 156) (1 + 5 + 25 + 125)
		// ...
		// AI    314
		// ...
		// E     782 (A���� + 781) (1 + 5 + 25 + 125 + 625)
		// ù ��° �ڸ� ���� �ϳ��� �ٲ�� ���ؼ��� + 781(1 + 5 + 25 + 125 + 625)�� �ʿ�
		// �� ��° �ڸ� ���� �ϳ��� �ٲ�� ���ؼ��� + 156(1 + 5 + 25 + 125)�� �ʿ�
		
		int[] arr = {781, 156, 31, 6, 1};
		
		answer += word.length(); // word ���̸�ŭ ����
		
		for (int i = 0; i < word.length(); i++) {
			answer += hm.get(word.charAt(i)) * arr[i]; // �ٲ� ���� üũ�Ͽ� ����
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "AAAAE";
		
		System.out.println(solution(word)); // 6
	}
}