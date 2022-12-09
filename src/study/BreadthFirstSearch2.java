package study;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch2 {
	
	// BFS : 음료수 얼려 먹기 문제
	// N x M 크기의 얼음 틀이 있습니다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
	// 상, 하, 좌, 우로 붙어 있는 경우 서로 연결된 것으로 간주, 생성되는 아이스크림 총 갯수 구하기
	
	public static int cnt = 0;
	public static int[] moveRow = {-1, 1, 0, 0};
	public static int[] moveCol = {0, 0, -1, 1};
	
	static int n = 4;
	static int m = 5;
	
	// 00110
	// 00011
	// 11111
	// 00000
	
	static int[][] arr = {{0,0,1,1,0}, {0,0,0,1,1}, {1,1,1,1,1}, {0,0,0,0,0}}; // 총 3개 만들어진다.
	
	public static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		
//		q.offer(arr[i][j]);
		
		q.offer(new Point(i,j)); // 넣
		
		arr[i][j] = 1; // 방
		
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
					q.offer(new Point(nextRow,nextCol)); // 넣
					
					arr[nextRow][nextCol] = 1; // 방
				}
			}
		}
	}
	
	public static void solution() {
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				if (arr[i][j] == 0) {
					bfs(i, j); // 덩어리가 시작되는 부분
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
