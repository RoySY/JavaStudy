package baekjoon;

import java.util.LinkedList;
import java.util.Queue;

public class B2178 {

	// 미로 탐색 - BFS 2178번
	// 최단 거리 탐색 BFS
	
	static int r = 4;
	static int c = 6;
	static int[][] arr = {{1, 0, 1, 1, 1, 1}, {1, 0, 1, 0, 1, 0}, {1, 0, 1, 0, 1, 1}, {1, 1, 1, 0, 1, 1}};
	static boolean[][] visit = {};
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void bfs(int n, int m) {
		
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {n,m});
		
		visit[n][m] = true;
		
		while(!q.isEmpty()) {
			
			int[] tempArr = q.poll();
			int row = tempArr[0];
			int col = tempArr[1];
			
			for(int i = 0; i < 4; i++) {
				int nextX = col + dx[i];
				int nextY = row + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= c || nextY >= r) {
					continue;
				}
				
				if(visit[nextY][nextX] || arr[nextY][nextX] == 0) {
					continue;
				}
				
				q.offer(new int[] {nextY,nextX});
				arr[nextY][nextX] = arr[row][col] + 1;
				visit[nextY][nextX] = true;
			}
		}
		
		System.out.println(arr[r-1][c-1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		visit = new boolean[r][c];
		
		bfs(0, 0);
	}
}