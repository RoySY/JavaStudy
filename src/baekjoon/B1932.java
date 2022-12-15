package baekjoon;

public class B1932 {

	// 정수 삼각형 - DP 1932번
	
	static int n = 5;
	static int[][] arr = {{7,0,0,0,0}, {3,8,0,0,0}, {8,1,0,0,0}, {2,7,4,4,0}, {4,5,2,6,5}};
	static int[][] dp = {{0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
//	static int[][] dp = {{7,0,0,0,0}, {10,15,0,0,0}, {11,9,8,0,0}, {0,0,0,0,0}, {0,0,0,0,0}};
	
//			7
//    	  3   8
//  	8   1   0
//	  2   7   4   4
//  4   5   2   6   5
	
//	7
//	3 8 (자기 또는 자기 + 1까지만 값을 더할 수 있네)
//	8 1 0
//	2 7 4 4
//	4 5 2 6 5
	
	public static void dynamicProgramming() {
		
		int num = 0;
		
		for (int i = 0; i < arr.length; i++) { // 5행까지 반복
			
			for (int j = 0; j < i + 1; j++) { // 0행은 1까지 // 1행은 2까지 체크
				
				dp[i][j] = arr[i][j]; // 같은 행은 그대로 삽입
				
				if (i > 0) { // 2행부터는 수를 더하는데 사용
					
					if (j == 0) {
						dp[i][j] = arr[i][j] + dp[i - 1][j];
					} else {
						dp[i][j] = Math.max(arr[i][j] + dp[i - 1][j], arr[i][j] + dp[i - 1][j - 1]);
					}
				}
			}
		}
		
		int max = dp[4][0];
		
		for (int i = 1; i < dp[4].length; i++) {
			
			if (max < dp[4][i]) {
				max = dp[4][i];
			}
		}
		
		System.out.println("최대값 : " + max);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dynamicProgramming();
	}
}