package baekjoon;

public class B1932 {

	// ���� �ﰢ�� - DP 1932��
	
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
//	3 8 (�ڱ� �Ǵ� �ڱ� + 1������ ���� ���� �� �ֳ�)
//	8 1 0
//	2 7 4 4
//	4 5 2 6 5
	
	public static void dynamicProgramming() {
		
		int num = 0;
		
		for (int i = 0; i < arr.length; i++) { // 5����� �ݺ�
			
			for (int j = 0; j < i + 1; j++) { // 0���� 1���� // 1���� 2���� üũ
				
				dp[i][j] = arr[i][j]; // ���� ���� �״�� ����
				
				if (i > 0) { // 2����ʹ� ���� ���ϴµ� ���
					
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
		
		System.out.println("�ִ밪 : " + max);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dynamicProgramming();
	}
}