package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraByPriorityQueue {
	
	public static int n = 6; // ����� ����
	public static int INF = 1000000; // ���Ѵ븦 �ǹ�
	public static HashMap<Integer, ArrayList<Node>> nodeListMap = new HashMap<>(); // key : �� ����� �ε���(0 ~ 5), value : �� ����� �ε����κ��� ��ü �������� �ε����� �Ÿ��� ���� ����Ʈ
	public static HashMap<Integer, Integer> minDistanceMap = new HashMap<>(); // key : �� ����� �ε���(0 ~ 5), value : �� �������� �ִܰŸ�(��� ���κ���)
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(); // �켱���� ť ���� // ��� ���κ��� ���� �ִܰŸ��� �ִ� ������ �켱������ ������ üũ�ϱ� ����(��� ���κ��� ���� �ִܰŸ��� �ִ� ��带 üũ�ؾ� �ٸ� ��������� �ִܰŸ� ������ ���ɼ��� �ֱ� ����)
		Node pqNode; // �켱���� ť���� ���� ��带 ���� ����(��� ���κ��� ���� �ִܰŸ��� �ִ� ���)
		ArrayList<Node> nodeList; // �켱���� ť���� ���� (��� ���κ��� ���� �ִܰŸ�)��带 ���ļ� üũ�� Ÿ�� ��� ����Ʈ

		// �� �������� �ִܰŸ� �ʱ�ȭ
		for (int key : nodeListMap.keySet()){ // 0 ~ 5
			minDistanceMap.put(key, INF); // ��� �ִܰŸ� ���Ѵ�� �ʱ�ȭ
		}
        
		minDistanceMap.put(start, 0); //��� �������� �ִܰŸ��� 0���� SET
        
		pq.add(new Node(start, 0)); // ��� ��带 �켱���� ť�� �߰� // �ִܰŸ��� ���ŵǾ����Ƿ� �켱���� ť�� �߰� => �� �ִܰŸ��� ���� �ٸ� ��������� �ִܰŸ��� ���ŵ� �� �ֱ� ����

		while (!pq.isEmpty()) { // �� �̻� �ִܰŸ� ������ �Ұ��� ������ �ݺ�

			pqNode = pq.poll(); // ��� ���κ��� ���� �ִܰŸ��� �ִ� ���

			if (pqNode.getDistance() > minDistanceMap.get(pqNode.getIndex())) { // �ִܰŸ� ������ �������� üũ
				continue;
			}
            
			nodeList = nodeListMap.get(pqNode.getIndex()); // ���� �ִܰŸ��� �ִ� ��带 ���ļ� üũ�� Ÿ�� ��� ����Ʈ
            
			for (Node node : nodeList) { // Ÿ�� ��� 0 ~ 5 ��� üũ
                
				if (pqNode.getDistance() + node.getDistance() < minDistanceMap.get(node.getIndex())) { // ��� ���κ��� ���� �ִܰŸ��� �ִ� ��带 ���ļ� Ÿ�� ���� ���� �Ÿ��� Ÿ�� ����� �ִܰŸ����� ���� ���
					minDistanceMap.put(node.getIndex(), pqNode.getDistance() + node.getDistance()); // Ÿ�� ����� �ִܰŸ� ����
					pq.add(new Node(node.getIndex(), pqNode.getDistance() + node.getDistance())); // Ÿ�� ��� �켱���� ť�� �߰�
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) { // 0 ~ 5
			nodeListMap.put(i, new ArrayList<Node>()); // key�� 0 ~ 5(�� ��� �ε���)���� Node ������ ���� ����Ʈ ����
		}
		
		nodeListMap.get(0).add(new Node(0, 0)); // 0�� ���κ��� 0�� �������� �Ÿ� 0
		nodeListMap.get(0).add(new Node(1, 2)); // 0�� ���κ��� 1�� �������� �Ÿ� 2
		nodeListMap.get(0).add(new Node(2, 5)); // 0�� ���κ��� 2�� �������� �Ÿ� 5
		nodeListMap.get(0).add(new Node(3, 1)); // 0�� ���κ��� 3�� �������� �Ÿ� 1
		nodeListMap.get(0).add(new Node(4, INF)); // 0�� ���κ��� 4�� �������� �Ÿ� INF
		nodeListMap.get(0).add(new Node(5, INF)); // 0�� ���κ��� 5�� �������� �Ÿ� INF
		
		nodeListMap.get(1).add(new Node(0, 2)); // 1�� ���κ��� 0�� �������� �Ÿ� 2
		nodeListMap.get(1).add(new Node(1, 0)); // 1�� ���κ��� 1�� �������� �Ÿ� 0
		nodeListMap.get(1).add(new Node(2, 3)); // 1�� ���κ��� 2�� �������� �Ÿ� 3
		nodeListMap.get(1).add(new Node(3, 2)); // 1�� ���κ��� 3�� �������� �Ÿ� 2
		nodeListMap.get(1).add(new Node(4, INF)); // 1�� ���κ��� 4�� �������� �Ÿ� INF
		nodeListMap.get(1).add(new Node(5, INF)); // 1�� ���κ��� 5�� �������� �Ÿ� INF
		
		nodeListMap.get(2).add(new Node(0, 5)); // 2�� ���κ��� 0�� �������� �Ÿ� 5
		nodeListMap.get(2).add(new Node(1, 3)); // 2�� ���κ��� 1�� �������� �Ÿ� 3
		nodeListMap.get(2).add(new Node(2, 0)); // 2�� ���κ��� 2�� �������� �Ÿ� 0
		nodeListMap.get(2).add(new Node(3, 3)); // 2�� ���κ��� 3�� �������� �Ÿ� 3
		nodeListMap.get(2).add(new Node(4, 1)); // 2�� ���κ��� 4�� �������� �Ÿ� 1
		nodeListMap.get(2).add(new Node(5, 5)); // 2�� ���κ��� 5�� �������� �Ÿ� 5
		
		nodeListMap.get(3).add(new Node(0, 1)); // 3�� ���κ��� 0�� �������� �Ÿ� 1
		nodeListMap.get(3).add(new Node(1, 2)); // 3�� ���κ��� 1�� �������� �Ÿ� 2
		nodeListMap.get(3).add(new Node(2, 3)); // 3�� ���κ��� 2�� �������� �Ÿ� 3
		nodeListMap.get(3).add(new Node(3, 0)); // 3�� ���κ��� 3�� �������� �Ÿ� 0
		nodeListMap.get(3).add(new Node(4, 1)); // 3�� ���κ��� 4�� �������� �Ÿ� 1
		nodeListMap.get(3).add(new Node(5, INF)); // 3�� ���κ��� 5�� �������� �Ÿ� INF
		
		nodeListMap.get(4).add(new Node(0, INF)); // 4�� ���κ��� 0�� �������� �Ÿ� INF
		nodeListMap.get(4).add(new Node(1, INF)); // 4�� ���κ��� 1�� �������� �Ÿ� INF
		nodeListMap.get(4).add(new Node(2, 1)); // 4�� ���κ��� 2�� �������� �Ÿ� 1
		nodeListMap.get(4).add(new Node(3, 1)); // 4�� ���κ��� 3�� �������� �Ÿ� 1
		nodeListMap.get(4).add(new Node(4, 0)); // 4�� ���κ��� 4�� �������� �Ÿ� 0
		nodeListMap.get(4).add(new Node(5, 2)); // 4�� ���κ��� 5�� �������� �Ÿ� 2
		
		nodeListMap.get(5).add(new Node(0, INF)); // 5�� ���κ��� 0�� �������� �Ÿ� INF
		nodeListMap.get(5).add(new Node(1, INF)); // 5�� ���κ��� 1�� �������� �Ÿ� INF
		nodeListMap.get(5).add(new Node(2, 5)); // 5�� ���κ��� 2�� �������� �Ÿ� 5
		nodeListMap.get(5).add(new Node(3, INF)); // 5�� ���κ��� 3�� �������� �Ÿ� INF
		nodeListMap.get(5).add(new Node(4, 2)); // 5�� ���κ��� 4�� �������� �Ÿ� 2
		nodeListMap.get(5).add(new Node(5, 0)); // 5�� ���κ��� 5�� �������� �Ÿ� 0
		
		dijkstra(0); // ��� ��� 0
		
		for (int i = 0; i < n; i++) { // 0 ~ 5
			System.out.print(minDistanceMap.get(i) + " "); // �� �������� �ִܰŸ� ���(��� ���κ���)
		}
	}
}
