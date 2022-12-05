package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch1 {
	
	// BFS
	// [BFS 알고리즘] 큐 사용 // peek() : Queue에 맨 앞에 있는 데이터를 가져온다 (Queue에서 꺼내진 않음) // poll() : Queue에 맨 앞에 있는 데이터 꺼낸다 // offer() : Stack에 데이터를 삽입
	// (6)--(2)--(1)--(3)--(5)
	//       |  /           |  \
	//      (8)            (4)--(7)
	
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 2차원 배열 또는 리스트 활용하자
//	public static int[][] arr = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(n); // 넣
		
		visited[n] = true; // 방
		
		while (!q.isEmpty()) { // 반
			int x = q.poll(); // 빼
			
			System.out.println(x + " "); // 출
			
			for (int i = 0; i < graph.get(x).size(); i++) { // 반
				int y = graph.get(x).get(i);
				
				if (!visited[y]) {
					q.offer(y); // 넣
					visited[y] = true; // 방
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 9; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 0번째는 생략
		
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
		
		bfs(1); // 1부터
	}

}
