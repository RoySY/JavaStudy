package study;

import java.util.*;

public class JewelryShopping {
	
	// ���� ����
	
	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		int length = Integer.MAX_VALUE;
		int startIndex = 0;
		int exceptCnt = 0;
		String tempGem = "";
		
		HashSet<String> hs = new HashSet<>(Arrays.asList(gems));
		HashMap<String, Integer> hm = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		
		for (int i = 0; i < gems.length; i++) {
			hm.put(gems[i], hm.getOrDefault(gems[i], 0) + 1); // key(������), value(���� ����)
			q.add(gems[i]); // �����Ϸ��� ���� �� ���� �տ� �� ������ ���� ������ ������ �� ��� FIFO�� �����ϵ��� Queue Ȱ��
			
			while (hm.get(q.peek()) > 1) { // �����Ϸ��� ���� �� ���� �տ� �� ������ 2�� �̻��� �Ǿ��ٸ�
				tempGem = q.poll(); // ���� �տ� �� ���� ����
				hm.put(tempGem, hm.get(tempGem) - 1); // �ش� ���� ���� 1 ���̱�
				exceptCnt++; // �տ������� ������ ���� ���� ����
			}
			
			if (hm.size() == hs.size() && length > (i - exceptCnt)) { // ������ ��� �����ϰ� �ּ� ���̶��
				length = i - exceptCnt; // ���� ����
				startIndex = exceptCnt + 1; // + 1�� �ϴ� ���� : �ε����� �ƴ� �� ��° ���������� return �ؾ� �ϱ� ����
			}
		}
		
		answer[0] = startIndex;
		answer[1] = startIndex + length;
		
		System.out.println(answer[0] + ", " + answer[1]);
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		
		System.out.println(solution(gems)); // {3, 7}
	}
}