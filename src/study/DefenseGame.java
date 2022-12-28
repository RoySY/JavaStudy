package study;

import java.util.PriorityQueue;

public class DefenseGame {
	
	// 디펜스 게임
	
	public static int solution(int n, int k, int[] enemy) {
		int answer = enemy.length; // 모든 라운드 클리어 가능할 경우의 리턴 값
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 무적권을 사용해 해치울 적의 수를 남기기 위한 우선순위 큐
		
		// 디펜스 게임 시작
		for(int i = 0; i < enemy.length; i++) { // 4, 2, 4, 5, 3, 3, 1
			pq.offer(enemy[i]); // 4 // 2, 4 // 2, 4, 4 // 2, 4, 4, 5 // 3, 4, 4, 5 // 3, 4, 4, 5
			
			// 무적권은 3개이므로 pq에 4개 이상 라운드가 담기면 그중 가장 적은 적이 나타나는 라운드는 병사를 소모하여 클리어
			if(pq.size() > k) { // false // false // false // true // true // true
				n -= pq.poll(); // 7 // 7 // 7 // 5 // 2 // -1
			}
			
			if(n < 0) { // false // false // false // false // false // true
				return i; // enemy 배열의 6번째 숫자에서 음수가 나오므로 enemy 배열의 5번째 숫자까지는 pass // 5라운드까지 진출 가능
			}
		}
		
		return answer; // 여기까지 내려왔다는 것은 모든 적을 해치우고도 병사가 남았다는 얘기 즉, 모든 라운드 클리어 가능
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7; // 병사 수
		int k = 3; // 무적권 수
		int[] enemy = {4, 2, 4, 5, 3, 3, 1}; // 라운드별 적 수
		
		System.out.println(solution(n, k, enemy)); // 5
	}
}