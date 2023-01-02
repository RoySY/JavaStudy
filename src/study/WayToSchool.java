package study;

public class WayToSchool {
	
	// 등굣길
	
	static int[][] dp = {};
	
	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		
		dp = new int [n][m]; // n행 m열
		
		dp[0][0] = 1; // 집
		
		for(int[] puddle : puddles) {
			dp[puddle[1] - 1][puddle[0] - 1] = -1; // 웅덩이 -1로
		}
		
		for(int i = 0; i < n; i++) { // 행
			
			for(int j = 0; j < m; j++) { // 열
				
				if(dp[i][j] == -1) { // 웅덩이라면
					dp[i][j] = 0; // 0으로 값 변경 후 continue
					continue;
				}
				
				if(i != 0) {
					dp[i][j] += dp[i - 1][j] % 1000000007;
				}
				
				if(j != 0) {
					dp[i][j] += dp[i][j - 1] % 1000000007;
				}
			}
		}
		
		answer = dp[n - 1][m - 1] % 1000000007;
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4; // 열
		int n = 3; // 행
		int[][] puddles = {{2, 2}}; // 웅덩이 좌표 // 열, 행
		
		// (1, 1)에서 (4, 3)까지 최단경로 개수를 1,000,000,007로 나눈 나머지 리턴
		// 무조건 오른쪽 또는 아래쪽으로만 이동 가능 -> 최단 거리가 m + n - 3이라는 것도 알 수 있다.
		System.out.println(solution(m, n, puddles)); // 4
	}
}