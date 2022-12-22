package baekjoon;

import java.util.ArrayList;
import java.util.Collections;

public class B2583 {
	
	// 영역 구하기 - DFS 2583번
	
	static boolean[][] boolArr = {};
	static int[] dRow = {1, -1, 0, 0}; // 상, 하, 좌, 우
	static int[] dCol = {0, 0, -1, 1}; // 상, 하, 좌, 우
	static int cnt = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	static int areaSize = 0;
	static int maxN = 0;
	static int maxM = 0;
	
	public static void dfs(int i, int j) {
		
		boolArr[i][j] = true; // 방문처리
		areaSize++;
		
		for (int x = 0; x < 4; x++) { // 상, 우상, 우로 이동
			int r = i + dRow[x];
			int c = j + dCol[x];
			
			if (r >= maxN || r < 0 || c >= maxM || c < 0) {
				continue;
			}
			
			if (!boolArr[r][c]) {
				dfs(r, c); // 거기서 연결되는 부분들 쭉 방문(물감 붓기)
			}
		}
	}
	
	public static void solution(int n, int m, int k, int[][] arr) {
		
		for (int i = 0; i < n; i++) { // row
			
			for (int j = 0; j < m; j++) { // col
				if (!boolArr[i][j]) { // 방문 전일 경우 DFS
					areaSize = 0;
					cnt++; // 영역 카운트
					dfs(i, j);
					list.add(areaSize);
				}
			}
		}
		
	}
	
	public static void draw(int[][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = arr[i][0]; j < arr[i][2]; j++) { // 0 ~ 3
				
				for (int z = arr[i][1]; z < arr[i][3]; z++) { // 2 ~ 3
					boolArr[z][j] = true; // 도형 그리기(방문 처리)
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int m = 7;
		int k = 3;
		int[][] arr = {{0,2,4,4}, {1,1,2,5}, {4,0,6,2}}; // 0,2 0,3 0,4 1,2 1,3 1,4 2,2 2,3 2,4 이런 식으로 이미 방문 처리를 해야돼
		
		maxN = n;
		maxM = m;
		
		boolArr = new boolean[n][m];
		
		draw(arr);
		
		solution(n,m,k,arr); // 3개 1, 7, 13
		
		System.out.println(cnt + "개의 영역");
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}