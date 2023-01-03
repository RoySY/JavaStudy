package study;

import java.util.HashMap;

public class EnglishWordChainGame {
	
	// ���� �����ձ�
	
	public static int[] solution(int n, String[] words) {
		int[] answer = {};
		int number = 0;
		int cycleCnt = 1;
		char startChar;
		
		answer = new int[2];
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		startChar = words[0].charAt(words[0].length() - 1);
		
		for(int i = 0; i < words.length; i++) {
			
			number++;
			
			if(number == n + 1) {
				number = 1;
				cycleCnt++;
			}
			
			if(!hm.containsKey(words[i])) {
				
				hm.put(words[i], 1);
				
				if(i > 0) {
					
					if((startChar == words[i].charAt(0))) {
						startChar = words[i].charAt(words[i].length() - 1);
					} else {
						answer[0] = number;
						answer[1] = cycleCnt;
						break;
					}
				}
			} else {
				answer[0] = number;
				answer[1] = cycleCnt;
				break;
			}
		}
		
		System.out.println(answer[0] + "���� " + answer[1] + "��°�� Ż��");
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3; // 2�̻� 10����
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}; // �迭 ���� n�̻� 100����, �ܾ� ���� 2�̻� 50����
		
		// �־��� �ܾ��� Ż���ڰ� ������ �ʴ´ٸ� 0, 0 ����
		
		System.out.println(solution(n, words)); // 3���� 3��°�� Ż��
	}
}