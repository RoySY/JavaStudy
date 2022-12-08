package study;

public class DepthFirstSearch2 {
	
	// DFS : 음료수 얼려 먹기 문제
	// N x M 크기의 얼음 틀이 있습니다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
	// 상, 하, 좌, 우로 붙어 있는 경우 서로 연결된 것으로 간주, 생성되는 아이스크림 총 갯수 구하기
	
	public static boolean[][] visited = {};
	public static int cnt = 0;
	public static int[] moveRow = {-1, 1, 0, 0};
	public static int[] moveCol = {0, 0, -1, 1};
	
	static int n = 4;
	static int m = 5;
	
	// 00110
	// 00011
	// 11111
	// 00000
	
	static int[][] arr = {{0,0,1,1,0}, {0,0,0,1,1}, {1,1,1,1,1}, {0,0,0,0,0}};
	
	public static void dfs(int i, int j) { // 지점으로부터 연결된 부분들은 물감 붓기처럼 모두 방문 처리
		visited[i][j] = true; // 방문처리 하고
		arr[i][j] = 1;
		
		for (int x = 0; x < 4; x++) {
			int row = i + moveRow[x];
			int col = j + moveCol[x];
			
			if (row < 0 || row > n - 1 || col < 0 || col > m - 1) {
				continue;
			}
			
			if (!visited[row][col] && arr[row][col] == 0) {
				dfs(row, col); // 재귀함수를 이용한 DFS
			}
		}
	}
	
	public static void solution() {
		
		visited = new boolean[n][m];
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				if (!visited[i][j] && arr[i][j] == 0) { // 0과 1이 방문 처리를 대신하기 때문에 visited 배열을 쓰지 않아도 된다.
					dfs(i, j); // 덩어리가 시작되는 부분
					cnt++;
				}
			}
		}
		
		System.out.println("만들어지는 아이스크림 총 갯수는 : " + cnt);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 4;
//		int m = 5;
//		
//		// 00110
//		// 00011
//		// 11111
//		// 00000
//		
//		int[][] arr = {{0,0,1,1,0}, {0,0,0,1,1}, {1,1,1,1,1}, {0,0,0,0,0}}; // 총 3개 만들어진다.
		
		solution();
	}
}
