package study;

import java.util.PriorityQueue;

public class DefenseGame {
	
	// ���潺 ����
	
	public static int solution(int n, int k, int[] enemy) {
		int answer = enemy.length; // ��� ���� Ŭ���� ������ ����� ���� ��
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // �������� ����� ��ġ�� ���� ���� ����� ���� �켱���� ť
		
		// ���潺 ���� ����
		for(int i = 0; i < enemy.length; i++) { // 4, 2, 4, 5, 3, 3, 1
			pq.offer(enemy[i]); // 4 // 2, 4 // 2, 4, 4 // 2, 4, 4, 5 // 3, 4, 4, 5 // 3, 4, 4, 5
			
			// �������� 3���̹Ƿ� pq�� 4�� �̻� ���尡 ���� ���� ���� ���� ���� ��Ÿ���� ����� ���縦 �Ҹ��Ͽ� Ŭ����
			if(pq.size() > k) { // false // false // false // true // true // true
				n -= pq.poll(); // 7 // 7 // 7 // 5 // 2 // -1
			}
			
			if(n < 0) { // false // false // false // false // false // true
				return i; // enemy �迭�� 6��° ���ڿ��� ������ �����Ƿ� enemy �迭�� 5��° ���ڱ����� pass // 5������� ���� ����
			}
		}
		
		return answer; // ������� �����Դٴ� ���� ��� ���� ��ġ��� ���簡 ���Ҵٴ� ��� ��, ��� ���� Ŭ���� ����
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7; // ���� ��
		int k = 3; // ������ ��
		int[] enemy = {4, 2, 4, 5, 3, 3, 1}; // ���庰 �� ��
		
		System.out.println(solution(n, k, enemy)); // 5
	}
}