package baekjoon;

public class B11048 {

	// �̵��ϱ� - DP 11048��
	
	static int n = 3;
	static int m = 4;
	static int[][] arr = {{1, 2, 3, 4}, {0, 0, 0, 5}, {9, 8, 7, 6}};
	static int[] dy = {1, 1, 0};
	static int[] dx = {0, 1, 1};
	static int[][] dp = new int[n][m];
	
	public static void dfs(int a, int b) {
		
		for(int i = 0; i < 3; i++) {
			int ny = a + dy[i];
			int nx = b + dx[i];
			
			if(ny > n - 1 || nx > m - 1) {
				continue;
			}
			
			// dp ���� �� dfs(���� �� ����)
			dp[ny][nx] = Math.max(dp[ny][nx], arr[ny][nx] + dp[a][b]);
			dfs(ny, nx);
		}
	}
	
	public static void dynamicProgramming() {
		dp[0][0] = arr[0][0];
		dfs(0,0);
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < m; j++) {
				System.out.print(dp[i][j] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println("���� �� �ִ� �ִ� ���� ���� : " + dp[n - 1][m - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// (1,1) �»�ܿ��� (N,M) ���ϴܱ��� ���� �ִ�� ���
		dynamicProgramming();
	}
}