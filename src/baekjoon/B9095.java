package baekjoon;

public class B9095 {

	// 1, 2, 3 ���ϱ� - DP 9095��
	// n�� 1, 2, 3�� ������ ��Ÿ���� ����� ��
	
	static int n = 4;
	static int[] dp = new int[101];
	
	// 1+1+1+1
	// 1+1+2
	// 1+2+1
	// 2+1+1
	// 2+2
	// 1+3
	// 3+1
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// n�� 1�� �� 1
		// 2�� �� 1+1, 2
		// 3�� �� 1+1+1, 1+2, 2+1, 3
		
		// 4�� 1+3/2+2/3+1�� ��Ÿ�� �� ����
		// 1+(1+1+1)/2+(1+1)/3+(1)
		// 1+(1+2)/2+(2)
		// 1+(2+1)
		// 1+(3)
		// ���� f(3)+f(2)+f(1)�� ��Ÿ�� �� �ִ� ���̴�.
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i <= 100; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		System.out.println(dp[n]);
	}
}