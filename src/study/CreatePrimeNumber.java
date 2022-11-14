package study;

import java.util.HashSet;
import java.util.Iterator;

public class CreatePrimeNumber {
	
	// �Ҽ� �����
	
	static HashSet<Integer> hs = new HashSet<>();
	
	public static boolean isPrimeNumber(int num) {
		
		int limit = 0;
		
		if (num == 0 || num == 1) { // 0�� 1�� �Ҽ��� �ƴϴ�.
			return false;
		}
		
		limit = (int) Math.sqrt(num);
		
		for (int i = 2; i <= limit; i++) { // num�� 80�̶�� ��Ʈ 80�� ���� ���� 8������ üũ�Ͽ� ������������� Ȯ���ϸ� �ȴ�.
			
			if (num % i == 0) { // ����������ٸ� num�� 1�� �ڱ� �ڽ��� ������ ����� ������ ���̹Ƿ� �Ҽ��� �ƴϴ�.
				return false;
			}
		}
		
		return true;
	}
	
	public static void recursive(String comb, String rest) {
		
		if (!"".equals(comb)) {
			hs.add(Integer.parseInt(comb)); // HashSet�� �ߺ��� ������� �ʴ´�.
		}
		
		for (int i = 0; i < rest.length(); i++) { // rest ���ڿ� �� �� ���ڸ� comb�� ���̰�, �� ���ڸ� ������ ������ ���ڿ��� rest ������ �ٽ� ����Լ��� ȣ���Ѵ�.
			recursive(comb + rest.charAt(i), rest.substring(0, i) + rest.substring(i + 1));
		}
	}
	
	public static int solution(String numbers) {
		int answer = 0;
		int tempNum = 0;
		
		// STEP 1. ��� ������ ���ڸ� �����.
		recursive("", numbers); // ����Լ� ȣ��("", "011")
		
		// STEP 2. �Ҽ��� ������ ����.
		Iterator<Integer> it = hs.iterator();
		
		while (it.hasNext()) {
			tempNum = it.next();
			
			if (isPrimeNumber(tempNum)) { // �Ҽ��̸�
				answer++; // ���� 1 ����
			}
		}
		
		// STEP 3. �Ҽ��� ������ �����Ѵ�.
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "011"; // 11, 101
		
		System.out.println(solution(numbers)); // 2
	}
}