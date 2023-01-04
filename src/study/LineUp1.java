package study;

import java.util.Arrays;

public class LineUp1 {
	
	// 줄 세우기 - DP 2631번
	// 이동 위치 제한 없음
	// 가장 긴 증가하는 부분 수열(LIS) 이용
	
	static int n = 7;
	static int[] arr = {3, 7, 5, 2, 6, 1, 4};
	static int[] dp = {1, 1, 1, 1, 1, 1, 1};
	
	public static void setLine() {
		
		int lisCnt = 0;
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < i; j++) {
				
				if (arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		// arr = {3, 7, 5, 2, 6, 1, 4}
		// dp = {1, 2, 2, 1, 3, 1, 2}
		
		Arrays.sort(dp);
		
		lisCnt = dp[n - 1]; // 3
		
		// 3, 5, 6이 가장 긴 증가하는 부분 수열이므로 나머지 4개의 숫자를 이동해 1, 2, 3, 4, 5, 6, 7로 줄 세우기 가능
		System.out.println(n - lisCnt + "번의 이동만으로 줄 세우기 가능");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setLine();
	}
}