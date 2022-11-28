package study;

import java.util.HashMap;

public class CuttingRollCake {
	
	// 롤케이크 자르기
	
	public static int solution(int[] topping) {
		int answer = 0;
		
		HashMap<Integer, Integer> hm1 = new HashMap<>();
		HashMap<Integer, Integer> hm2 = new HashMap<>();
		
		for (int i = 0; i < topping.length; i++) {
			hm2.put(topping[i], hm2.getOrDefault(topping[i], 0) + 1);
		}
		
		// hm2 : {1=4, 2=2, 3=1, 4=1}
		
		for (int i = 0; i < topping.length; i++) {
			hm1.put(topping[i], hm1.getOrDefault(topping[i], 0) + 1);
			
			if (hm2.containsKey(topping[i])) {
				hm2.put(topping[i], hm2.get(topping[i]) - 1);
			}
			
			if (hm2.get(topping[i]) == 0) {
				hm2.remove(topping[i]);
			}
			
			if (hm1.size() == hm2.size()) { // hm1 : {1=2, 2=1, 3=1}, hm2 : {1=2, 2=1, 4=1} // hm1 : {1=3, 2=1, 3=1}, hm2 : {1=1, 2=1, 4=1}
				answer++;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] topping = {1, 2, 1, 3, 1, 4, 1, 2}; // 1, 2, 1, 3과 1, 4, 1, 2로 잘랐을 떄, 1, 2, 1, 3, 1과 4, 1, 2로 잘랐을 때
		
		System.out.println(solution(topping)); // 2
	}
}