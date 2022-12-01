package study;

public class Rank {
	
	// ����
	// Floyd Warshall �˰������� Ǯ��
	
	public static int solution(int n, int[][] results) {
		int answer = 0;
		int zeroCnt = 0;
		int[][] board = new int[n][n]; // 0 ~ 4
		
		for (int i = 0; i < results.length; i++) {
			// {4, 3}�� ���
			board[results[i][0] - 1][results[i][1] - 1] = 1; // 4�� 3���� �̰����Ƿ� board[3][2] = 1
			board[results[i][1] - 1][results[i][0] - 1] = -1; // 3�� 4���� �����Ƿ� board[2][3] = -1
		}
		
//		0 : {0, 1, 0, 0, 0}
//		1 : {-1, 0, -1, -1, 1}
//		2 : {0, 1, 0, -1, 0}
//		3 : {0, 1, 1, 0, 0}
//		4 : {0, -1, 0, 0, 0}
		
		for (int k = 0; k < n; k++) {
			
			for (int i = 0; i < n; i++) {
				
				for (int j = 0; j < n; j++) {
					
					if (k == i || i == j || k == j) { // �ڱ� �ڽŰ��� ���� ���� �� ����.
						continue;
					}
					
					if (board[i][j] == 0) { // i�� j�� ��� ����� �н��ߴٸ�
						
						if (board[i][k] == 1 && board[k][j] == 1) { // i�� k���� �̱��, k�� j���� �̰�ٸ�
							board[i][j] = 1; // i�� j���� �̱� ������ üũ
						} else if (board[i][k] == -1 && board[k][j] == -1) { // i�� k���� ����, k�� j���� ���ٸ�
							board[i][j] = -1; // i�� j���� �� ������ üũ
						}
					}
				}
			}
		}
		
//		0 : {0, 1, 0, 0, 1}
//		1 : {-1, 0, -1, -1, 1} // �ڱ� �ڽ��� �����ϰ� �ٸ� ��� ��������� ��� ����� �� �� �ִ� ����
//		2 : {0, 1, 0, -1, 1}
//		3 : {0, 1, 1, 0, 1}
//		4 : {-1, -1, -1, -1, 0} // �ڱ� �ڽ��� �����ϰ� �ٸ� ��� ��������� ��� ����� �� �� �ִ� ����
		
		for (int i = 0; i < n; i++) {
			
			zeroCnt = 0;
			
			for (int j = 0; j < n; j++) {
				
				if (board[i][j] == 0) {
					zeroCnt++;
				}
			}
			
			if (zeroCnt == 1) {
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		System.out.println(solution(n, results)); // 2
	}
}