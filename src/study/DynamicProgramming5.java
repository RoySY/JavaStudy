package study;

public class DynamicProgramming5 {
	
	// DP : 금광
	// N x M 크기의 금광이 있다. 첫 번째 열의 아무 위치에서나 시작할 수 있다.
	// 다음 열에선 오른쪽, 오른쪽 위, 오른쪽 아래 중 한 곳으로 이동 가능하다.
	// 금을 최대로 얻는 방법은?
	
	static int n = 3;
	static int m = 4;
	static int[][] arr = {{1,3,3,2},{2,1,4,1},{0,6,4,7}};
	static int[][] d = {};
	
	// 1 3 3 2
	// 2 1 4 1
	// 0 6 4 7
	
	// 금광의 모든 위치에 대하여 다음 세 가지만 고려하면 된다.
	// 1. 왼쪽 위에서 오는 경우
	// 2. 왼쪽 아래에서 오는 경우
	// 3. 왼쪽에서 오는 경우
	// 세 가지 경우 중에서 가장 많은 금을 가지고 있는 경우를 테이블에 갱신해주어 문제를 해결한다.
	
	// arr[i][j] : i행 j열에 존재하는 금의 양
	// dp[i][j] : i행 j열까지의 최적의 해(얻을 수 있는 금의 최댓값)
	// 점화식 : dp[i][j] = arr[i][j] + max(dp[i - 1][j - 1], dp[i][j - 1], dp[i + 1][j - 1])
	// DP는 점화식을 세우는 것이 중요
	
	public static void dp() {
		d = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < m; j++) {
				d[i][j] = arr[i][j];
			}
		}
		
		int leftUp = 0;
		int left = 0;
		int leftDown = 0;
		
		for (int j = 1; j < m; j++) { // 인덱스 1열 2열 3열
			
			for (int i = 0; i < n; i++) { // 인덱스 0행 1행 2행
				
				if (i == 0) { // 0행일 경우 왼쪽 위는 없어
					leftUp = 0;
				} else {
					leftUp = d[i - 1][j - 1];
				}
				
				left = d[i][j - 1];
				
				if (i == n - 1) { // 마지막 행일 경우 왼쪽 아래는 없어
					leftDown = 0;
				} else {
					leftDown = d[i + 1][j - 1];
				}
				
				d[i][j] = d[i][j] + Math.max(leftUp, Math.max(left, leftDown));
			}
		}
		
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			
			result = Math.max(result, d[i][m - 1]); // 열은 제일 마지막 열로 고정
		}
		
		System.out.println(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp();
	}

}
