package baekjoon;

import java.util.ArrayList;

public class B1303 {

	// ���� - ���� - DFS 1303��
	
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
		
		visit[i][j] = true; // Ž���� ���� ���Դٸ� �湮ó��
		cnt++;
		
		for (int k = 0; k < 4; k++) {
			
			int row = i + dy[k];
			int col = j + dx[k];
			
			if (row < 0 || row > n - 1 || col < 0 || col > m - 1) {
				continue;
			}
			
			if (arr[row][col] == arr[i][j] && visit[row][col] == false) { // ���� ����, ���� �湮���� ���ٸ�
				dfs(row, col);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < n; i++) { // ��
			
			for (int j = 0 ; j < m; j++) { // ��
				
				if (visit[i][j] == false) { // �湮 ���̶��
					cnt = 0;
					
					dfs(i, j); // �����¿� Ž���ϱ� ���� dfs // ����� ������ ������
					
					if (arr[i][j] == 'W') {
						System.out.println("��� ���" + cnt);
						wList.add(cnt * cnt);
					} else if (arr[i][j] == 'B') {
						System.out.println("�Ķ� ���" + cnt);
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
		
		System.out.println("��� ���� ���� : " + wValue + " �Ķ� ���� ���� : " + bValue);
	}
}