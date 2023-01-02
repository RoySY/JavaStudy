package study;

public class WayToSchool {
	
	// ���
	
	static int[][] dp = {};
	
	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		
		dp = new int [n][m]; // n�� m��
		
		dp[0][0] = 1; // ��
		
		for(int[] puddle : puddles) {
			dp[puddle[1] - 1][puddle[0] - 1] = -1; // ������ -1��
		}
		
		for(int i = 0; i < n; i++) { // ��
			
			for(int j = 0; j < m; j++) { // ��
				
				if(dp[i][j] == -1) { // �����̶��
					dp[i][j] = 0; // 0���� �� ���� �� continue
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
		int m = 4; // ��
		int n = 3; // ��
		int[][] puddles = {{2, 2}}; // ������ ��ǥ // ��, ��
		
		// (1, 1)���� (4, 3)���� �ִܰ�� ������ 1,000,000,007�� ���� ������ ����
		// ������ ������ �Ǵ� �Ʒ������θ� �̵� ���� -> �ִ� �Ÿ��� m + n - 3�̶�� �͵� �� �� �ִ�.
		System.out.println(solution(m, n, puddles)); // 4
	}
}