package study;
public class DfsRecursive1 {
	
	// [DFS �˰���] ��� �Լ� ���
	// (6)--(2)--(1)--(3)--(5)
	//       |  /           |  \
	//      (8)            (4)--(7)
	
	static boolean[] visited = new boolean[9]; // �湮ó���� ����� �迭 ����
	
	// 2���� �迭�� ǥ��
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}}; // �ε����� ������ ����ȣ�� �� �� �ְ� 0�� �ε����� �ƹ��͵� ���� ����
	
	static void dfs(int nodeIdx) {
		
		visited[nodeIdx] = true; // ���� nodeIdx�� �湮 true ó��
		
		System.out.print(nodeIdx + " -> "); // �湮�� ���� ���
		
		for (int node : graph[nodeIdx]) { // nodeIdx�� 1�� ��� �ݺ����� 3ȸ, node�� ���ʷ� 2, 3, 8�� �Ǵ� ��
			
			if (!visited[node]) {
				dfs(node);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfs(1); // ���� ����� 1 �Ѱ��ֱ�
	}
}