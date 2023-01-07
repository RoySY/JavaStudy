package study;
import java.util.Stack;

public class DfsStack1 {
	
	// [DFS �˰���] ���� ��� // peek() : Stack �ֻ�ܿ� �ִ� top data ��ȯ�Ѵ�(Stack���� ������ ����) // pop() : Stack�� �ִ� ������ ������ // push() : Stack�� �����͸� �����Ѵ� // isEmpty() : Stack ����ִ��� Ȯ���Ѵ� // empty() : Stack�� �ʱ�ȭ�Ѵ� // size() : Stack Size�� ��ȯ�Ѵ�
	// (6)--(2)--(1)--(3)--(5)
	//       |  /           |  \
	//      (8)            (4)--(7)
	
	static boolean[] visited = new boolean[9]; // �湮ó���� ����� �迭 ����
	
	// 2���� �迭�� ǥ��
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}}; // �ε����� ������ ����ȣ�� �� �� �ְ� 0�� �ε����� �ƹ��͵� ���� ����
	
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack.push(1); // ���� ��带 �־��ش�. // ������ ���� ��带 ã�� ���� �׸��� ��
		
		visited[1] = true; // ���� ��� �湮 ó��
		
		while (!stack.isEmpty()) { // ������ ������� ������ ��� �ݺ�
			
			int nodeIdx = stack.pop(); // ���ÿ��� �ϳ��� ������ ��ȯ // peek���� �޸� �ƿ� ������ �� // ������ �������� ���� �ͺ��� ���� -> �ڽ� ���� �� ���� �������� ���� �ͺ��� ���� �׸��� �� ����� �ڽ� ���� �� ���� �������� ���� �ͺ��� ����(��������� �ڽ� ����� �ڽ� ������ Ž���ϰ� ��)
			
			System.out.print(nodeIdx + " -> "); // �湮 ��� ���
			
			for (int LinkedNode : graph[nodeIdx]) { // ���� ���� ���� ��� ã��
				
				if (!visited[LinkedNode]) { // ���� ��带 �湮���� �ʾ��� ��� ���ÿ� �ְ� �湮 ó��
					stack.push(LinkedNode); // LinkedNode�� ���� ��带 ã�� ���� ���ÿ� �ִ´�.
					visited[LinkedNode] = true; // LinkedNode�� �湮�����Ƿ� true ó�� ���ش�. // ���ÿ� ����ְ�, �湮 ó���� ������ ������ ������ ���� ����
				}
			}
		}
	}
}