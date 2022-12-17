package baekjoon;

import java.util.Arrays;

public class B7570 {
	
	// 줄 세우기 - DP 7570번
	// 제일 앞 또는 제일 뒤로만 이동 가능
	// 연속된 가장 긴 증가하는 부분 수열 이용
	
	static int n = 7;
	static int[] arr = {3, 7, 5, 2, 6, 1, 4};
	static int[] dp = {1, 1, 1, 1, 1, 1, 1};
	
	public static void setLine() {
		
		int clisCnt = 0;
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < i; j++) {
				
				if (arr[i] == arr[j] + 1) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		// arr = {3, 7, 5, 2, 6, 1, 4}
		// dp = {1, 1, 1, 1, 2, 1, 2}
		
		Arrays.sort(dp);
		
		clisCnt = dp[n - 1]; // 2
		
		// 3, 4 또는 5, 6이 연속된 가장 긴 증가하는 부분 수열이므로 나머지 5개의 숫자를 이동해 1, 2, 3, 4, 5, 6, 7로 줄 세우기 가능
		System.out.println(n - clisCnt + "번의 이동만으로 줄 세우기 가능");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setLine();
	}
}