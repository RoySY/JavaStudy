package study;

import java.util.HashMap;

public class EnglishWordChainGame {
	
	// 영어 끝말잇기
	
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
		
		System.out.println(answer[0] + "번이 " + answer[1] + "번째에 탈락");
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3; // 2이상 10이하
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}; // 배열 길이 n이상 100이하, 단어 길이 2이상 50이하
		
		// 주어진 단어들로 탈락자가 생기지 않는다면 0, 0 리턴
		
		System.out.println(solution(n, words)); // 3번이 3번째에 탈락
	}
}