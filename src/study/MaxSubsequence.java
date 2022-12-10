package study;

public class MaxSubsequence {
	
	// 최대 연속 부분 수열의 합
	// 현재 합, 합의 최대값 갱신
	// 1. 수의 합을 반복적으로 구한다.
	// 2. 이 때 합이 음수이면 그 다음 수부터 다시 시작
	// 3. 합의 최대값을 도출
	
	public static int getMaxSubsequence(int[] arr) {
		int temp = 0;
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			temp += arr[i];
			
			if (temp > max) {
				max = temp;
			} else if (temp < 0) {
				temp = 0;
			}
		}
		
		return max;
	}
	
	public static int getMaxElementForNegativeArr(int[] arr) { // 배열의 원소가 전부 음수일 경우
		int max = -10000;
		
		for (int i = 0; i < arr.length; i++) {
			
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		
		return max;
	}

	public static int solution(int[] arr) {
		
		int result = getMaxSubsequence(arr);
		
		if (result != 0) {
			return result;
		} else { // result 값이 0이라는 건 배열의 원소가 모두 음수라는 얘기
			return getMaxElementForNegativeArr(arr);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-3, 3, 5, -3, -7, 9, -2, 10, -5, -2};
		// 0 번째 -3 : 현재 합 0, 합의 최대값 0
		// 1 번째 3 : 현재 합 3, 합의 최대값 3 (0보다 크므로 갱신)
		// 2 번째 5 : 현재 합 8, 합의 최대값 8 (3보다 크므로 갱신)
		// 3 번째 -3 : 현재 합 5, 합의 최대값 8 (갱신되지 않음)
		// 4 번째 -7 : 현재 합 0 (else if 조건문에 의해 -2 -> 0), 합의 최대값 8 (갱신되지 않음)
		// 5 번째 9 : 현재 합 9, 합의 최대값 9 (8보다 크므로 갱신)
		// 6 번째 -2 : 현재 합 7, 합의 최대값 9 (갱신되지 않음)
		// 7 번째 10 : 현재 합 17, 합의 최대값 17 (9보다 크므로 갱신)
		// 8 번째 -5 : 현재 합 12, 합의 최대값 17 (갱신되지 않음)
		// 9 번째 -2 : 현재 합 10, 합의 최대값 17 (갱신되지 않음)
		
		System.out.println(solution(arr)); // 합의 최대값 17
	}
}