package baekjoon;

import java.util.Arrays;

public class B7570 {
	
	// �� ����� - DP 7570��
	// ���� �� �Ǵ� ���� �ڷθ� �̵� ����
	// ���ӵ� ���� �� �����ϴ� �κ� ���� �̿�
	
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
		
		// 3, 4 �Ǵ� 5, 6�� ���ӵ� ���� �� �����ϴ� �κ� �����̹Ƿ� ������ 5���� ���ڸ� �̵��� 1, 2, 3, 4, 5, 6, 7�� �� ����� ����
		System.out.println(n - clisCnt + "���� �̵������� �� ����� ����");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setLine();
	}
}