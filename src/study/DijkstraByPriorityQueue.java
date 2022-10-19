package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraByPriorityQueue {
	
	public static int n = 6; // 노드의 개수
	public static int INF = 1000000; // 무한대를 의미
	public static HashMap<Integer, ArrayList<Node>> nodeListMap = new HashMap<>(); // key : 각 노드의 인덱스(0 ~ 5), value : 각 노드의 인덱스로부터 전체 노드까지의 인덱스와 거리를 담을 리스트
	public static HashMap<Integer, Integer> minDistanceMap = new HashMap<>(); // key : 각 노드의 인덱스(0 ~ 5), value : 각 노드까지의 최단거리(출발 노드로부터)
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐 생성 // 출발 노드로부터 현재 최단거리에 있는 노드부터 우선적으로 빼내어 체크하기 위함(출발 노드로부터 현재 최단거리에 있는 노드를 체크해야 다른 노드들까지의 최단거리 갱신의 가능성이 있기 때문)
		Node pqNode; // 우선순위 큐에서 빼낸 노드를 담을 변수(출발 노드로부터 현재 최단거리에 있는 노드)
		ArrayList<Node> nodeList; // 우선순위 큐에서 빼낸 (출발 노드로부터 현재 최단거리)노드를 거쳐서 체크할 타겟 노드 리스트

		// 각 노드까지의 최단거리 초기화
		for (int key : nodeListMap.keySet()){ // 0 ~ 5
			minDistanceMap.put(key, INF); // 모든 최단거리 무한대로 초기화
		}
        
		minDistanceMap.put(start, 0); //출발 노드까지의 최단거리는 0으로 SET
        
		pq.add(new Node(start, 0)); // 출발 노드를 우선순위 큐에 추가 // 최단거리가 갱신되었으므로 우선순위 큐에 추가 => 이 최단거리를 거쳐 다른 노드들까지의 최단거리도 갱신될 수 있기 때문

		while (!pq.isEmpty()) { // 더 이상 최단거리 갱신이 불가할 때까지 반복

			pqNode = pq.poll(); // 출발 노드로부터 현재 최단거리에 있는 노드

			if (pqNode.getDistance() > minDistanceMap.get(pqNode.getIndex())) { // 최단거리 갱신이 가능한지 체크
				continue;
			}
            
			nodeList = nodeListMap.get(pqNode.getIndex()); // 현재 최단거리에 있는 노드를 거쳐서 체크할 타겟 노드 리스트
            
			for (Node node : nodeList) { // 타겟 노드 0 ~ 5 모두 체크
                
				if (pqNode.getDistance() + node.getDistance() < minDistanceMap.get(node.getIndex())) { // 출발 노드로부터 현재 최단거리에 있는 노드를 거쳐서 타겟 노드로 가는 거리가 타겟 노드의 최단거리보다 작을 경우
					minDistanceMap.put(node.getIndex(), pqNode.getDistance() + node.getDistance()); // 타겟 노드의 최단거리 갱신
					pq.add(new Node(node.getIndex(), pqNode.getDistance() + node.getDistance())); // 타겟 노드 우선순위 큐에 추가
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) { // 0 ~ 5
			nodeListMap.put(i, new ArrayList<Node>()); // key값 0 ~ 5(각 노드 인덱스)마다 Node 정보를 담을 리스트 생성
		}
		
		nodeListMap.get(0).add(new Node(0, 0)); // 0번 노드로부터 0번 노드까지의 거리 0
		nodeListMap.get(0).add(new Node(1, 2)); // 0번 노드로부터 1번 노드까지의 거리 2
		nodeListMap.get(0).add(new Node(2, 5)); // 0번 노드로부터 2번 노드까지의 거리 5
		nodeListMap.get(0).add(new Node(3, 1)); // 0번 노드로부터 3번 노드까지의 거리 1
		nodeListMap.get(0).add(new Node(4, INF)); // 0번 노드로부터 4번 노드까지의 거리 INF
		nodeListMap.get(0).add(new Node(5, INF)); // 0번 노드로부터 5번 노드까지의 거리 INF
		
		nodeListMap.get(1).add(new Node(0, 2)); // 1번 노드로부터 0번 노드까지의 거리 2
		nodeListMap.get(1).add(new Node(1, 0)); // 1번 노드로부터 1번 노드까지의 거리 0
		nodeListMap.get(1).add(new Node(2, 3)); // 1번 노드로부터 2번 노드까지의 거리 3
		nodeListMap.get(1).add(new Node(3, 2)); // 1번 노드로부터 3번 노드까지의 거리 2
		nodeListMap.get(1).add(new Node(4, INF)); // 1번 노드로부터 4번 노드까지의 거리 INF
		nodeListMap.get(1).add(new Node(5, INF)); // 1번 노드로부터 5번 노드까지의 거리 INF
		
		nodeListMap.get(2).add(new Node(0, 5)); // 2번 노드로부터 0번 노드까지의 거리 5
		nodeListMap.get(2).add(new Node(1, 3)); // 2번 노드로부터 1번 노드까지의 거리 3
		nodeListMap.get(2).add(new Node(2, 0)); // 2번 노드로부터 2번 노드까지의 거리 0
		nodeListMap.get(2).add(new Node(3, 3)); // 2번 노드로부터 3번 노드까지의 거리 3
		nodeListMap.get(2).add(new Node(4, 1)); // 2번 노드로부터 4번 노드까지의 거리 1
		nodeListMap.get(2).add(new Node(5, 5)); // 2번 노드로부터 5번 노드까지의 거리 5
		
		nodeListMap.get(3).add(new Node(0, 1)); // 3번 노드로부터 0번 노드까지의 거리 1
		nodeListMap.get(3).add(new Node(1, 2)); // 3번 노드로부터 1번 노드까지의 거리 2
		nodeListMap.get(3).add(new Node(2, 3)); // 3번 노드로부터 2번 노드까지의 거리 3
		nodeListMap.get(3).add(new Node(3, 0)); // 3번 노드로부터 3번 노드까지의 거리 0
		nodeListMap.get(3).add(new Node(4, 1)); // 3번 노드로부터 4번 노드까지의 거리 1
		nodeListMap.get(3).add(new Node(5, INF)); // 3번 노드로부터 5번 노드까지의 거리 INF
		
		nodeListMap.get(4).add(new Node(0, INF)); // 4번 노드로부터 0번 노드까지의 거리 INF
		nodeListMap.get(4).add(new Node(1, INF)); // 4번 노드로부터 1번 노드까지의 거리 INF
		nodeListMap.get(4).add(new Node(2, 1)); // 4번 노드로부터 2번 노드까지의 거리 1
		nodeListMap.get(4).add(new Node(3, 1)); // 4번 노드로부터 3번 노드까지의 거리 1
		nodeListMap.get(4).add(new Node(4, 0)); // 4번 노드로부터 4번 노드까지의 거리 0
		nodeListMap.get(4).add(new Node(5, 2)); // 4번 노드로부터 5번 노드까지의 거리 2
		
		nodeListMap.get(5).add(new Node(0, INF)); // 5번 노드로부터 0번 노드까지의 거리 INF
		nodeListMap.get(5).add(new Node(1, INF)); // 5번 노드로부터 1번 노드까지의 거리 INF
		nodeListMap.get(5).add(new Node(2, 5)); // 5번 노드로부터 2번 노드까지의 거리 5
		nodeListMap.get(5).add(new Node(3, INF)); // 5번 노드로부터 3번 노드까지의 거리 INF
		nodeListMap.get(5).add(new Node(4, 2)); // 5번 노드로부터 4번 노드까지의 거리 2
		nodeListMap.get(5).add(new Node(5, 0)); // 5번 노드로부터 5번 노드까지의 거리 0
		
		dijkstra(0); // 출발 노드 0
		
		for (int i = 0; i < n; i++) { // 0 ~ 5
			System.out.print(minDistanceMap.get(i) + " "); // 각 노드까지의 최단거리 출력(출발 노드로부터)
		}
	}
}
