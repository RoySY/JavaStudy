package baekjoon;

import java.util.ArrayList;

public class B1303 {

	// 전쟁 - 전투 - DFS 1303번
	
	static int n = 5;
	static int m = 5;
	static char[][] arr = {{'W','B','W','W','W'}, {'W','W','W','W','W'}, {'B','B','B','B','B'}, {'B','B','B','W','W'}, {'W','W','W','W','W'}};
	static boolean[][] visit = new boolean[5][5];
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static ArrayList<Integer> wList = new ArrayList<>();
	static ArrayList<Integer> bList = new ArrayList<>();
	static int cnt = 0;
	static int wValue = 0;
	static int bValue = 0;
	
//	WBWWW
//	WWWWW
//	BBBBB
//	BBBWW
//	WWWWW
	
	public static void dfs(int i, int j) {
		
		visit[i][j] = true; // 탐색을 위해 들어왔다면 방문처리
		cnt++;
		
		for (int k = 0; k < 4; k++) {
			
			int row = i + dy[k];
			int col = j + dx[k];
			
			if (row < 0 || row > n - 1 || col < 0 || col > m - 1) {
				continue;
			}
			
			if (arr[row][col] == arr[i][j] && visit[row][col] == false) { // 팀이 같고, 아직 방문한적 없다면
				dfs(row, col);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < n; i++) { // 행
			
			for (int j = 0 ; j < m; j++) { // 열
				
				if (visit[i][j] == false) { // 방문 전이라면
					cnt = 0;
					
					dfs(i, j); // 상하좌우 탐색하기 위해 dfs // 덩어리의 갯수가 결정됨
					
					if (arr[i][j] == 'W') {
						System.out.println("흰색 덩어리" + cnt);
						wList.add(cnt * cnt);
					} else if (arr[i][j] == 'B') {
						System.out.println("파란 덩어리" + cnt);
						bList.add(cnt * cnt);
					}
				}
			}
		}
		
		for (int i = 0; i < wList.size(); i++) {
			wValue += wList.get(i);
		}
		
		for (int i = 0; i < bList.size(); i++) {
			bValue += bList.get(i);
		}
		
		System.out.println("흰색 팀의 위력 : " + wValue + " 파란 팀의 위력 : " + bValue);
	}
}