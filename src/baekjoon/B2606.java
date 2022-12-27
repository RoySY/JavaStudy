package baekjoon;

import java.util.ArrayList;

public class B2606 {
	
	// 바이러스 - DFS 2606번
	
	static boolean[] boolArr = {};
	
	public static void dfs(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			boolArr[arr[i] - 1] = true;
		}
	}
	
	public static void solution(int n, int m, int[][] arr) {
		
		boolArr = new boolean[n + 1];
		
//		ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // list의 틀 생성
//		
//		list.add(0, new ArrayList<>()); // {}
//		
//		for (int i = 0; i < arr.length; i++) {
//			
//			list.add(i + 1, new ArrayList<>()); // list의 i번째에 ArrayList 생성
//			
//			for (int j = 0; j < arr[i].length; j++) { // 1, 2, 2, 3
//				
//				if (i + 1 == arr[i][j]) {
//					
//				}
//			}
//		}
		
		boolArr[0] = true; // 1번 컴퓨터 바이러스
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				if (boolArr[arr[i][j] - 1] == true) { // 둘 중 하나만 true여도 실행
					dfs(arr[i]); // {1, 2}가 가겠지
				}
			}
		}
		
		int cnt = -1;
		
		for (int i = 0; i < boolArr.length; i++) {
//			System.out.print(boolArr[i]);
			
			if (boolArr[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt + "개");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7; // 1, 2, 3, 4, 5, 6, 7
		int m = 6; // 6쌍
		int[][] arr = {{1,2}, {2,3}, {1,5}, {5,2}, {5,6}, {4,7}}; // 1로부터 연결된 지점들의 수(1은 제외)
		
		// 0 : {}
		// 1 : {2, 5}
		// 2 : {1, 3, 5}
		// 3 : {2}
		// 4 : {7}
		// 5 : {1, 2, 6}
		// 6 : {5}
		// 7 : {4}
		// 이게 dfs 쓰기에는 더 좋은데
		
		solution(n, m, arr);
	}
}