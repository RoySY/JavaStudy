package baekjoon;

public class B4963 {

	// ���� DFS 4963�� ���� ���� ����
	
	static int[][] arr = {{1, 0, 1, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 1, 0, 1}, {1, 0, 0, 1, 0}};
	static boolean[][] visit = new boolean[4][5];
	static int cnt = 0;
	static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1}; // �����¿�, �»�, ����, ����, ���
	static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1}; // �����¿�, �»�, ����, ����, ���
	
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
	
		for (int i = 0; i < arr.length; i++) { // ó�� 0, 0�� 1�� ���ð��̱� �빮�� ��
				
			for (int j = 0; j < arr[i].length; j++) {
				
				if (arr[i][j] != 0 && visit[i][j] == false) {
					cnt++; // 0�� �ƴ� ���� ã�Ҵٸ� ���̴ϱ� cnt++, �ű�� ������ ������ ��� visit true�� ä��ž�
					dfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
	}
}