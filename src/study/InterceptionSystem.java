package study;

import java.util.Arrays;

public class InterceptionSystem {
	
	// 요격 시스템
	
	public static int solution(int[][] targets) {
		int answer = 0;
		
		// 개구간 (s, e)로 표현되는 폭격 미사일을 s와 e에서 발사하는 요격 미사일로는 요격할 수 없기 때문에 각각의 원소에 10을 곱한 후
		// 첫 번째 원소에서는 +1을, 두 번째 원소에서는 -1을 하여 폐구간 [r, f]을 만든 후 [Java] 프로그래머스 [Level-3] 단속카메라 문제처럼 풀도록 한다.
		int[][] tempTargets = new int[targets.length][targets[0].length];
		
		for (int i = 0; i < targets.length; i++) {
			tempTargets[i][0] = targets[i][0] * 10 + 1;
			tempTargets[i][1] = targets[i][1] * 10 - 1;
		}
		
		// int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
		// int[][] tempTargets = {{41, 49}, {41, 79}, {101, 139}, {111, 129}, {51, 119}, {31, 69}, {11, 39}};
		
		// 이차원 배열 tempTargets 정렬
		Arrays.sort(tempTargets, (o1, o2) -> {
			if (o1[1] == o2[1]) { // 뒤 원소가 같을 경우
				return o1[0] - o2[0]; // 앞 원소 기준 오름차순
			} else { // 뒤 원소가 같지 않을 경우
				return o1[1] - o2[1]; // 뒤 원소 기준 오름차순
			}
		});
		
		// int[][] tempTargets = {{11, 39}, {41, 49}, {31, 69}, {41, 79}, {51, 119}, {111, 129}, {101, 139}};
		
		int missilePoint = tempTargets[0][0] - 1; // 10 // 정렬 후 첫 번째 첫 원소보다 작은 값을 넣기 위해 -1 => 최초 무조건 아래 if문에 걸리게 됨
		
		for (int i = 0; i < tempTargets.length; i++) {
			
			if (missilePoint < tempTargets[i][0]) {
				missilePoint = tempTargets[i][1];
				System.out.println(missilePoint + "번 위치에 미사일 설치");
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
		
		System.out.println(solution(targets)); // 3
	}
}