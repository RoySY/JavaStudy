package study;

import java.util.Arrays;

public class LifeBoat {
	
	// 구명보트
	
	public static int solution(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people); // 50, 50, 70, 80
		
		int maxWeightIndex = people.length - 1; // 구조되지 않은 사람 중 가장 무거운 무게를 가진 사람의 인덱스
		int minWeightIndex = 0; // 구조되지 않은 사람 중 가장 가벼운 무게를 가진 사람의 인덱스
		
		for (int i = maxWeightIndex; i >= 0; i--) { // 구조되지 않은 사람 중 가장 무거운 무게를 가진 사람부터 순서대로 구조
			
			answer++; // 보트에 타지 못하는 경우는 없으므로 1 증가 // 구조되지 않은 사람 중 가장 무거운 무게를 가진 사람 무조건 보트에 태우기
			
			if (i == minWeightIndex) { // max 인덱스 감소 후 min 인덱스와 값이 같다는 것은 해당 위치에 혼자 남은 경우를 의미하며 위에서 구조 보트에 이미 탔기 때문에(answer증가) 바로 break
				break;
			}
			
			if (people[i] + people[minWeightIndex] <= limit) { // 보트에는 최대 2명까지 탈 수 있고 구조되지 않은 사람 중 가장 무거운 무게를 가진 사람이 탄 보트에 현재 가장 가벼운 사람 또한 함께 탈 수 있다면
				minWeightIndex++; // 현재 가장 가벼운 사람도 함께 구조된 것으로 간주하고 min 인덱스 1 증가 => 다음 가벼운 사람에게 순서를 넘김
			}
			
			if (i == minWeightIndex) { // min 인덱스 증가 후 max 인덱스와 값이 같다면 모든 인원에 대해 구조가 끝난 상황이므로 바로 break
				break;
			}
			
//			if (i <= minWeightIndex) { // 위에 break if문 2개를 모두 주석처리 하고 이 if문만 살려도 결과는 같다.
//				break;
//			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		
		System.out.println(solution(people, limit));
	}
}