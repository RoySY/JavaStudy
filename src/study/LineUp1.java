package study;

import java.util.Arrays;

public class LineUp1 {
	
	// �� ����� - DP 2631��
	// �̵� ��ġ ���� ����
	// ���� �� �����ϴ� �κ� ����(LIS) �̿�
	
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
		
		// 3, 5, 6�� ���� �� �����ϴ� �κ� �����̹Ƿ� ������ 4���� ���ڸ� �̵��� 1, 2, 3, 4, 5, 6, 7�� �� ����� ����
		System.out.println(n - lisCnt + "���� �̵������� �� ����� ����");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setLine();
	}
}