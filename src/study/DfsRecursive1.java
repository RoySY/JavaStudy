package study;
public class DfsRecursive1 {
	
	// [DFS 알고리즘] 재귀 함수 사용
	// (6)--(2)--(1)--(3)--(5)
	//       |  /           |  \
	//      (8)            (4)--(7)
	
	static boolean[] visited = new boolean[9]; // 방문처리에 사용할 배열 선언
	
	// 2차원 배열로 표현
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}}; // 인덱스가 각각의 노드번호가 될 수 있게 0번 인덱스는 아무것도 없는 상태
	
	static void dfs(int nodeIdx) {
		
		visited[nodeIdx] = true; // 들어온 nodeIdx의 방문 true 처리
		
		System.out.print(nodeIdx + " -> "); // 방문한 노드는 출력
		
		for (int node : graph[nodeIdx]) { // nodeIdx가 1일 경우 반복문은 3회, node는 차례로 2, 3, 8이 되는 것
			
			if (!visited[node]) {
				dfs(node);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfs(1); // 시작 노드인 1 넘겨주기
	}
}