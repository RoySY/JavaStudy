package baekjoon;

public class B4963 {

	// 백준 DFS 4963번 섬의 개수 문제
	
	static int[][] arr = {{1, 0, 1, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 1, 0, 1}, {1, 0, 0, 1, 0}};
	static boolean[][] visit = new boolean[4][5];
	static int cnt = 0;
	static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1}; // 상하좌우, 좌상, 좌하, 우하, 우상
	static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1}; // 상하좌우, 좌상, 좌하, 우하, 우상
	
	public static void dfs(int i, int j) {
		visit[i][j] = true;
		
		for (int k = 0; k < 8; k++) {
			int nx = j + dx[k];
			int ny = i + dy[k];
			
			if (nx >= 0 && ny >= 0 && nx < 5 && ny < 4) {
				
				if (arr[ny][nx] == 1 && visit[ny][nx] == false) {
					dfs(ny, nx);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			5 4
//			1 0 1 0 0
//			1 0 0 0 0
//			1 0 1 0 1
//			1 0 0 1 0
	
		for (int i = 0; i < arr.length; i++) { // 처음 0, 0인 1이 나올것이기 대문에 들어가
				
			for (int j = 0; j < arr[i].length; j++) {
				
				if (arr[i][j] != 0 && visit[i][j] == false) {
					cnt++; // 0이 아닌 곳을 찾았다면 섬이니까 cnt++, 거기랑 연관된 육지는 모두 visit true로 채울거야
					dfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
	}
}