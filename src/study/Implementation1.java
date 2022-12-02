package study;

public class Implementation1 {
	
	// 구현 : 시뮬레이션과 완전 탐색
	// 머릿속에 있는 알고리즘을 소스코드로 바꾸는 과정
	// 풀이를 떠올리는 것은 쉽지만 소스코드로 옮기는 것이 어려운 문제
	
	// 알고리즘은 간단한데 코드가 지나칠 만큼 길어지는 문제
	// 실수 연산을 다루고, 특정 소수점 자리까지 출력해야 하는 문제
	// 문자열을 특정한 기준에 따라서 끊어 처리해야 하는 문제
	// 적절한 라이브러리를 찾아서 사용해야 하는 문제
	
	// 상하좌우 문제
	
	public static void solution(int n, String[] arr) {
		
		// 시작 지점 (0, 0), 공간의 크기 n x n
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < arr.length; i++) {

			if ("U".equals(arr[i])) {
				
				if (row + 1 > n - 1) {
					continue;
				}
				row = row + 1;
			} else if ("D".equals(arr[i])) {
				
				if (row - 1 < 0) {
					continue;
				}
				
				row = row - 1;
			} else if ("L".equals(arr[i])) {
				
				if (col - 1 < 0) {
					continue;
				}
				
				col = col - 1;
			} else if ("R".equals(arr[i])) {
				
				if (col + 1 > n - 1) {
					continue;
				}
				
				col = col + 1;
			}
		}
		
		System.out.println(row + ", " + col);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		String[] arr = {"R", "R", "R", "U", "D", "D"}; // 0,0에서 시작 3,4
		
		solution(n, arr);
	}
}