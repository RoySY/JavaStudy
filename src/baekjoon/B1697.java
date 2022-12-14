package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B1697 {

	// ���ٲ��� - BFS 1697��
	
	static int n = 5;
	static int m = 17;
	
	public static void bfs(int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		
		int[] check = new int[100001]; // 0 ~ 17���� ������
		boolean[] visit = new boolean[100001];
		
		Arrays.fill(check, 0); // ��ü 0���� �ʱ�ȭ
		
		q.offer(n); //5 �ְ�
		visit[n] = true; // 5 �湮
		
		while (!q.isEmpty()) {
			// 5 4 6 10 3 (5) 8 (5) 7 12
			// 0 1 1 1 2 0 2 0 2 2
			int num = q.poll(); // 5 ���� // 4 ����
//				check[num] = check[num] + 1;
//				visit[num] = true; // 5 �湮ó�� // 4 �湮ó��
			
			if (num == m) {
				System.out.println(check[num]);
			}
			
			if (num < 1 || num > 50000) {
				continue;
			}
			
			if (visit[num - 1] == false) { // 4�� �湮���� �ʾҴٸ� // 3�� �湮���� �ʾҴٸ�
				q.offer(num - 1); // 4 �ֱ� // 3 �ֱ�
				check[num - 1] = Math.max(check[num - 1], check[num] + 1); // check[4] = 1�� �ɰž� // check[3] = 2�� �ɰž�
				visit[num - 1] = true; // 4 �湮ó�� // 3 �湮ó��
			}
			
			if (visit[num + 1] == false) { // 6�� �湮���� �ʾҴٸ� // 5�� ��ŵ
				q.offer(num + 1); // 6 �ֱ�
				check[num + 1] = Math.max(check[num + 1], check[num] + 1); // check[6] = 1�� �ɰž�
				visit[num + 1] = true; // 6 �湮ó��
			}
			
			if (visit[num * 2] == false) { // 10�� �湮���� �ʾҴٸ� // 8�� �湮���� �ʾҴٸ�
				q.offer(num * 2); // 10 �ֱ� // 8 �ֱ�
				check[num * 2] = Math.max(check[num * 2], check[num] + 1); // check[10] = 1�� �ɰž� // check[8] = 2�� �ɰž�
				visit[num * 2] = true; // 10 �湮 // 8 �湮
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ƚ���� max ī��Ʈ�� 17 - 5�� �ž�
		// +1, -1, x2 3���� ��쿡 ���� ��� bfs ����
		bfs(n, m);
	}
}