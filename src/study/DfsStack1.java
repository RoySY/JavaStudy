package study;
import java.util.Stack;

public class DfsStack1 {
	
	// [DFS 알고리즘] 스택 사용 // peek() : Stack 최상단에 있는 top data 반환한다(Stack에서 꺼내진 않음) // pop() : Stack에 있는 데이터 꺼낸다 // push() : Stack에 데이터를 삽입한다 // isEmpty() : Stack 비어있는지 확인한다 // empty() : Stack을 초기화한다 // size() : Stack Size를 반환한다
	// (6)--(2)--(1)--(3)--(5)
	//       |  /           |  \
	//      (8)            (4)--(7)
	
	static boolean[] visited = new boolean[9]; // 방문처리에 사용할 배열 선언
	
	// 2차원 배열로 표현
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}}; // 인덱스가 각각의 노드번호가 될 수 있게 0번 인덱스는 아무것도 없는 상태
	
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack.push(1); // 시작 노드를 넣어준다. // 스택은 인접 노드를 찾기 위한 그릇일 뿐
		
		visited[1] = true; // 시작 노드 방문 처리
		
		while (!stack.isEmpty()) { // 스택이 비어있지 않으면 계속 반복
			
			int nodeIdx = stack.pop(); // 스택에서 하나를 꺼내서 반환 // peek과는 달리 아예 꺼내는 것 // 무조건 마지막에 들어온 것부터 꺼냄 -> 자식 노드들 중 가장 마지막에 들어온 것부터 꺼냄 그리고 그 노드의 자식 노드들 중 가장 마지막에 들어온 것부터 꺼냄(결과적으로 자식 노드의 자식 노드부터 탐색하게 됨)
			
			System.out.print(nodeIdx + " -> "); // 방문 노드 출력
			
			for (int LinkedNode : graph[nodeIdx]) { // 꺼낸 노드와 인접 노드 찾기
				
				if (!visited[LinkedNode]) { // 인접 노드를 방문하지 않았을 경우 스택에 넣고 방문 처리
					stack.push(LinkedNode); // LinkedNode의 인접 노드를 찾기 위해 스택에 넣는다.
					visited[LinkedNode] = true; // LinkedNode는 방문했으므로 true 처리 해준다. // 스택에 담겨있고, 방문 처리는 했지만 순서는 찍히지 않은 상태
				}
			}
		}
	}
}