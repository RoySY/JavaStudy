package study;

public class Rank {
	
	// 순위
	// Floyd Warshall 알고리즘으로 풀이
	
	public static int solution(int n, int[][] results) {
		int answer = 0;
		int zeroCnt = 0;
		int[][] board = new int[n][n]; // 0 ~ 4
		
		for (int i = 0; i < results.length; i++) {
			// {4, 3}의 경우
			board[results[i][0] - 1][results[i][1] - 1] = 1; // 4는 3에게 이겼으므로 board[3][2] = 1
			board[results[i][1] - 1][results[i][0] - 1] = -1; // 3은 4에게 졌으므로 board[2][3] = -1
		}
		
//		0 : {0, 1, 0, 0, 0}
//		1 : {-1, 0, -1, -1, 1}
//		2 : {0, 1, 0, -1, 0}
//		3 : {0, 1, 1, 0, 0}
//		4 : {0, -1, 0, 0, 0}
		
		for (int k = 0; k < n; k++) {
			
			for (int i = 0; i < n; i++) {
				
				for (int j = 0; j < n; j++) {
					
					if (k == i || i == j || k == j) { // 자기 자신과의 경기는 있을 수 없다.
						continue;
					}
					
					if (board[i][j] == 0) { // i와 j의 경기 결과를 분실했다면
						
						if (board[i][k] == 1 && board[k][j] == 1) { // i가 k에게 이기고, k가 j에게 이겼다면
							board[i][j] = 1; // i는 j에게 이긴 것으로 체크
						} else if (board[i][k] == -1 && board[k][j] == -1) { // i가 k에게 지고, k가 j에게 졌다면
							board[i][j] = -1; // i는 j에게 진 것으로 체크
						}
					}
				}
			}
		}
		
//		0 : {0, 1, 0, 0, 1}
//		1 : {-1, 0, -1, -1, 1} // 자기 자신을 제외하고 다른 모든 선수들과의 경기 결과를 알 수 있는 선수
//		2 : {0, 1, 0, -1, 1}
//		3 : {0, 1, 1, 0, 1}
//		4 : {-1, -1, -1, -1, 0} // 자기 자신을 제외하고 다른 모든 선수들과의 경기 결과를 알 수 있는 선수
		
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