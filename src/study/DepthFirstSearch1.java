package study;

import java.util.ArrayList;

public class DepthFirstSearch1 {
	
	// DFS
	// [DFS �˰���] ���� ��� // peek() : Stack �ֻ�ܿ� �ִ� top data ��ȯ�Ѵ�(Stack���� ������ ����) // pop() : Stack�� �ִ� ������ ������ // push() : Stack�� �����͸� �����Ѵ� // isEmpty() : Stack ����ִ��� Ȯ���Ѵ� // empty() : Stack�� �ʱ�ȭ�Ѵ� // size() : Stack Size�� ��ȯ�Ѵ�
	// (6)--(2)--(1)--(3)--(5)
	//       |  /           |  \
	//      (8)            (4)--(7)
	
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 2���� �迭 �Ǵ� ����Ʈ Ȱ������
//	public static int[][] arr = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	public static void dfs(int n) {
		
		visited[n] = true; // ��
		
		System.out.println(n + " "); // ��
		
		for (int i = 0; i < graph.get(n).size(); i++) {
			
			int x = graph.get(n).get(i);
			
			if (!visited[x]) {
				dfs(x);
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
		
		dfs(1); // 1����
	}
}
