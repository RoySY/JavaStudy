package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch1 {
	
	// BFS
	// [BFS �˰���] ť ��� // peek() : Queue�� �� �տ� �ִ� �����͸� �����´� (Queue���� ������ ����) // poll() : Queue�� �� �տ� �ִ� ������ ������ // offer() : Stack�� �����͸� ����
	// (6)--(2)--(1)--(3)--(5)
	//       |  /           |  \
	//      (8)            (4)--(7)
	
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 2���� �迭 �Ǵ� ����Ʈ Ȱ������
//	public static int[][] arr = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(n); // ��
		
		visited[n] = true; // ��
		
		while (!q.isEmpty()) { // ��
			int x = q.poll(); // ��
			
			System.out.println(x + " "); // ��
			
			for (int i = 0; i < graph.get(x).size(); i++) { // ��
				int y = graph.get(x).get(i);
				
				if (!visited[y]) {
					q.offer(y); // ��
					visited[y] = true; // ��
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 9; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 0��°�� ����
		
		graph.get(1).add(2);
		graph.get(1).add(3);
		graph.get(1).add(8);
		
		graph.get(2).add(1);
		graph.get(2).add(6);
		graph.get(2).add(8);
		
		graph.get(3).add(1);
		graph.get(3).add(5);
		
		graph.get(4).add(5);
		graph.get(4).add(7);
		
		graph.get(5).add(3);
		graph.get(5).add(4);
		graph.get(5).add(7);
		
		graph.get(6).add(2);
		
		graph.get(7).add(4);
		graph.get(7).add(5);
		
		graph.get(8).add(1);
		graph.get(8).add(2);
		
		bfs(1); // 1����
	}

}
