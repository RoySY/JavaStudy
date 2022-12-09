package study;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch2 {
	
	// BFS : ����� ��� �Ա� ����
	// N x M ũ���� ���� Ʋ�� �ֽ��ϴ�. ������ �շ� �ִ� �κ��� 0, ĭ���̰� �����ϴ� �κ��� 1�� ǥ�õȴ�.
	// ��, ��, ��, ��� �پ� �ִ� ��� ���� ����� ������ ����, �����Ǵ� ���̽�ũ�� �� ���� ���ϱ�
	
	public static int cnt = 0;
	public static int[] moveRow = {-1, 1, 0, 0};
	public static int[] moveCol = {0, 0, -1, 1};
	
	static int n = 4;
	static int m = 5;
	
	// 00110
	// 00011
	// 11111
	// 00000
	
	static int[][] arr = {{0,0,1,1,0}, {0,0,0,1,1}, {1,1,1,1,1}, {0,0,0,0,0}}; // �� 3�� ���������.
	
	public static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		
//		q.offer(arr[i][j]);
		
		q.offer(new Point(i,j)); // ��
		
		arr[i][j] = 1; // ��
		
		while (!q.isEmpty()) {
			
			Point p = q.poll();
			
			int row = p.x;
			int col = p.y;
			
			for (int z = 0; z < 4; z++) {
				int nextRow = row + moveRow[z];
				int nextCol = col + moveCol[z];
				
				if (nextRow < 0 || nextRow > n - 1 || nextCol < 0 || nextCol > m - 1) {
					continue;
				}
				
				if (arr[nextRow][nextCol] == 0) {
					q.offer(new Point(nextRow,nextCol)); // ��
					
					arr[nextRow][nextCol] = 1; // ��
				}
			}
		}
	}
	
	public static void solution() {
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				if (arr[i][j] == 0) {
					bfs(i, j); // ����� ���۵Ǵ� �κ�
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
