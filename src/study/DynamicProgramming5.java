package study;

public class DynamicProgramming5 {
	
	// DP : �ݱ�
	// N x M ũ���� �ݱ��� �ִ�. ù ��° ���� �ƹ� ��ġ������ ������ �� �ִ�.
	// ���� ������ ������, ������ ��, ������ �Ʒ� �� �� ������ �̵� �����ϴ�.
	// ���� �ִ�� ��� �����?
	
	static int n = 3;
	static int m = 4;
	static int[][] arr = {{1,3,3,2},{2,1,4,1},{0,6,4,7}};
	static int[][] d = {};
	
	// 1 3 3 2
	// 2 1 4 1
	// 0 6 4 7
	
	// �ݱ��� ��� ��ġ�� ���Ͽ� ���� �� ������ ����ϸ� �ȴ�.
	// 1. ���� ������ ���� ���
	// 2. ���� �Ʒ����� ���� ���
	// 3. ���ʿ��� ���� ���
	// �� ���� ��� �߿��� ���� ���� ���� ������ �ִ� ��츦 ���̺� �������־� ������ �ذ��Ѵ�.
	
	// arr[i][j] : i�� j���� �����ϴ� ���� ��
	// dp[i][j] : i�� j�������� ������ ��(���� �� �ִ� ���� �ִ�)
	// ��ȭ�� : dp[i][j] = arr[i][j] + max(dp[i - 1][j - 1], dp[i][j - 1], dp[i + 1][j - 1])
	// DP�� ��ȭ���� ����� ���� �߿�
	
	public static void dp() {
		d = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < m; j++) {
				d[i][j] = arr[i][j];
			}
		}
		
		int leftUp = 0;
		int left = 0;
		int leftDown = 0;
		
		for (int j = 1; j < m; j++) { // �ε��� 1�� 2�� 3��
			
			for (int i = 0; i < n; i++) { // �ε��� 0�� 1�� 2��
				
				if (i == 0) { // 0���� ��� ���� ���� ����
					leftUp = 0;
				} else {
					leftUp = d[i - 1][j - 1];
				}
				
				left = d[i][j - 1];
				
				if (i == n - 1) { // ������ ���� ��� ���� �Ʒ��� ����
					leftDown = 0;
				} else {
					leftDown = d[i + 1][j - 1];
				}
				
				d[i][j] = d[i][j] + Math.max(leftUp, Math.max(left, leftDown));
			}
		}
		
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			
			result = Math.max(result, d[i][m - 1]); // ���� ���� ������ ���� ����
		}
		
		System.out.println(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp();
	}

}
