package study;

import java.util.*;

public class JewelryShopping {
	
	// 보석 쇼핑
	
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
			hm.put(gems[i], hm.getOrDefault(gems[i], 0) + 1); // key(보석명), value(보석 개수)
			q.add(gems[i]); // 구매하려는 보석 중 제일 앞에 고른 보석과 같은 보석이 들어오게 될 경우 FIFO이 가능하도록 Queue 활용
			
			while (hm.get(q.peek()) > 1) { // 구매하려는 보석 중 제일 앞에 고른 보석이 2개 이상이 되었다면
				tempGem = q.poll(); // 제일 앞에 고른 보석 빼기
				hm.put(tempGem, hm.get(tempGem) - 1); // 해당 보석 개수 1 줄이기
				exceptCnt++; // 앞에서부터 제외할 보석 개수 증가
			}
			
			if (hm.size() == hs.size() && length > (i - exceptCnt)) { // 보석을 모두 포함하고 최소 길이라면
				length = i - exceptCnt; // 길이 갱신
				startIndex = exceptCnt + 1; // + 1을 하는 이유 : 인덱스가 아닌 몇 번째 보석인지를 return 해야 하기 때문
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