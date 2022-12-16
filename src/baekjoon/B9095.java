package baekjoon;

public class B9095 {

	// 1, 2, 3 더하기 - DP 9095번
	// n을 1, 2, 3의 합으로 나타내는 방법의 수
	
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
		// n은 1일 때 1
		// 2일 때 1+1, 2
		// 3일 때 1+1+1, 1+2, 2+1, 3
		
		// 4는 1+3/2+2/3+1로 나타낼 수 있음
		// 1+(1+1+1)/2+(1+1)/3+(1)
		// 1+(1+2)/2+(2)
		// 1+(2+1)
		// 1+(3)
		// 따라서 f(3)+f(2)+f(1)로 나타낼 수 있는 것이다.
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i <= 100; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		System.out.println(dp[n]);
	}
}