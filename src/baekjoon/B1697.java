package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B1697 {

	// 숨바꼭질 - BFS 1697번
	
	static int n = 5;
	static int m = 17;
	
	public static void bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		
		int[] check = new int[100001]; // 0 ~ 17까지 만들자
		boolean[] visit = new boolean[100001];
		
		Arrays.fill(check, 0); // 전체 0으로 초기화
		
		q.offer(n); //5 넣고
		visit[n] = true; // 5 방문
		
		while (!q.isEmpty()) {
			// 5 4 6 10 3 (5) 8 (5) 7 12
			// 0 1 1 1 2 0 2 0 2 2
			int num = q.poll(); // 5 꺼내 // 4 꺼내
//				check[num] = check[num] + 1;
//				visit[num] = true; // 5 방문처리 // 4 방문처리
			
			if (num == m) {
				System.out.println(check[num]);
			}
			
			if (num < 1 || num > 50000) {
				continue;
			}
			
			if (visit[num - 1] == false) { // 4를 방문하지 않았다면 // 3을 방문하지 않았다면
				q.offer(num - 1); // 4 넣기 // 3 넣기
				check[num - 1] = Math.max(check[num - 1], check[num] + 1); // check[4] = 1이 될거야 // check[3] = 2가 될거야
				visit[num - 1] = true; // 4 방문처리 // 3 방문처리
			}
			
			if (visit[num + 1] == false) { // 6을 방문하지 않았다면 // 5는 스킵
				q.offer(num + 1); // 6 넣기
				check[num + 1] = Math.max(check[num + 1], check[num] + 1); // check[6] = 1이 될거야
				visit[num + 1] = true; // 6 방문처리
			}
			
			if (visit[num * 2] == false) { // 10을 방문하지 않았다면 // 8을 방문하지 않았다면
				q.offer(num * 2); // 10 넣기 // 8 넣기
				check[num * 2] = Math.max(check[num * 2], check[num] + 1); // check[10] = 1이 될거야 // check[8] = 2가 될거야
				visit[num * 2] = true; // 10 방문 // 8 방문
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 횟수의 max 카운트는 17 - 5일 거야
		// +1, -1, x2 3가지 경우에 대해 계속 bfs 수행
		bfs(n, m);
	}
}