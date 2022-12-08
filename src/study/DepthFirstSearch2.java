package study;

public class DepthFirstSearch2 {
	
	// DFS : ����� ��� �Ա� ����
	// N x M ũ���� ���� Ʋ�� �ֽ��ϴ�. ������ �շ� �ִ� �κ��� 0, ĭ���̰� �����ϴ� �κ��� 1�� ǥ�õȴ�.
	// ��, ��, ��, ��� �پ� �ִ� ��� ���� ����� ������ ����, �����Ǵ� ���̽�ũ�� �� ���� ���ϱ�
	
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
	
	public static void dfs(int i, int j) { // �������κ��� ����� �κе��� ���� �ױ�ó�� ��� �湮 ó��
		visited[i][j] = true; // �湮ó�� �ϰ�
		arr[i][j] = 1;
		
		for (int x = 0; x < 4; x++) {
			int row = i + moveRow[x];
			int col = j + moveCol[x];
			
			if (row < 0 || row > n - 1 || col < 0 || col > m - 1) {
				continue;
			}
			
			if (!visited[row][col] && arr[row][col] == 0) {
				dfs(row, col); // ����Լ��� �̿��� DFS
			}
		}
	}
	
	public static void solution() {
		
		visited = new boolean[n][m];
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				if (!visited[i][j] && arr[i][j] == 0) { // 0�� 1�� �湮 ó���� ����ϱ� ������ visited �迭�� ���� �ʾƵ� �ȴ�.
					dfs(i, j); // ����� ���۵Ǵ� �κ�
					cnt++;
				}
			}
		}
		
		System.out.println("��������� ���̽�ũ�� �� ������ : " + cnt);
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
//		int[][] arr = {{0,0,1,1,0}, {0,0,0,1,1}, {1,1,1,1,1}, {0,0,0,0,0}}; // �� 3�� ���������.
		
		solution();
	}
}
