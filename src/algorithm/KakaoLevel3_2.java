package algorithm;

import java.util.*;

public class KakaoLevel3_2 {
	
	// ����ڽ� ���ϱ�
	
	public static int INF = 10000001;
	public static HashMap<Integer, ArrayList<IntensityNode>> nodeListMap = new HashMap<>();
	public static HashMap<Integer, Integer> maxOfMinIntensityMap = new HashMap<>();
	public static int totalNum = 0;
	public static int[] arrGates = {};
	public static int[] arrSummits = {};
	
	public static int dijkstra(int i, int j) {
		PriorityQueue<IntensityNode> pq = new PriorityQueue<>();
		IntensityNode pqNode;
		ArrayList<IntensityNode> nodeList;
		
		int summit = arrSummits[i];
		int gate = arrGates[j];
		
		boolean[] targetNode = new boolean[totalNum + 1]; // 1���� ���Ա�, 1���� ���츮�� �������� boolean �迭
		
		Arrays.fill(targetNode, true);
		
		for (int k = 0; k < arrSummits.length; k++) {
			
			if (arrSummits[k] == summit) {
				continue;
			}
			
			targetNode[arrSummits[k]] = false;
		}
		
		for (int k = 0; k < arrGates.length; k++) {
			
			if (arrGates[k] == gate) {
				continue;
			}
			
			targetNode[arrGates[k]] = false;
		}
		
		for (int key : nodeListMap.keySet()) {
			maxOfMinIntensityMap.put(key, INF); // �ּ� Intensity �ڽ� �� �ִ� Intensity �� ���Ѵ�� �ʱ�ȭ
		}
		
		maxOfMinIntensityMap.put(summit, 0); // ��� ���츮�� Intensity�� 0
		
		pq.add(new IntensityNode(summit, 0));
		
		while (!pq.isEmpty()) {
			pqNode = pq.poll();
			
			if (pqNode.getIntensity() > maxOfMinIntensityMap.get(pqNode.getIndex())) {
				continue;
			}
			
			nodeList = nodeListMap.get(pqNode.getIndex());
			
			for (IntensityNode node : nodeList) {
				
				if (!targetNode[node.getIndex()]) {
					continue; // ������ ���츮, ���Ա��� �ƴ� ��� ���� �Ұ�
				}
				
				if (pqNode.getIntensity() + node.getIntensity() < maxOfMinIntensityMap.get(node.getIndex())) {
					maxOfMinIntensityMap.put(node.getIndex(), Math.max(pqNode.getIntensity(), node.getIntensity()));
					pq.add(new IntensityNode(node.getIndex(), Math.max(pqNode.getIntensity(), node.getIntensity())));
				}
			}
		}
		
		int minIntensity = maxOfMinIntensityMap.get(arrGates[0]);
		
		for (int n = 1; n < arrGates.length; n++) {
			
			if (maxOfMinIntensityMap.get(arrGates[n]) < minIntensity) {
				minIntensity = maxOfMinIntensityMap.get(arrGates[n]);
			}
		}
		
		return minIntensity;
	}
	
	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		int[] answer = {};
		int MinSummit = 0;
		int MinIntensity = INF;
        
		totalNum = n;
		arrGates = Arrays.copyOf(gates, gates.length);
		arrSummits = Arrays.copyOf(summits, summits.length);
        		
		for (int i = 0; i < n + 1; i++) {
			nodeListMap.put(i, new ArrayList<IntensityNode>());
		}
        
		for (int i = 0; i < paths.length; i++) {
			nodeListMap.get(paths[i][0]).add(new IntensityNode(paths[i][1], paths[i][2]));
			nodeListMap.get(paths[i][1]).add(new IntensityNode(paths[i][0], paths[i][2]));
		}
        
		Arrays.sort(arrSummits); // intensity�� ���� ��� ���츮 ��ȣ ���� ���� ����� �ǵ��� ���� & �� ���� �� �� ���� intensity���� ���� ��쿡�� ���ŵǵ���
        
		int tempIntensity = 0;
        
		for (int i = 0; i < arrSummits.length; i++) {
        	
			for (int j = 0; j < arrGates.length; j++) {
        		
				tempIntensity = dijkstra(i, j);
        		
				if (tempIntensity < MinIntensity) {
					MinIntensity = tempIntensity;
					MinSummit = arrSummits[i];
				}
			}
		}
        
		answer = new int[2];
        
		answer[0] = MinSummit;
		answer[1] = MinIntensity;
        
		System.out.println(MinSummit + " " + MinIntensity);
        
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
		int[] gates = {3, 7};
		int[] summits = {1, 5};
		
		// gates �� �ϳ��� ��ȣ�� ���� �����ϸ�, ���� ó���� �������̾�� �� => 3 - ... - 3
		// summits �� �ϳ��� ���� �����ϸ�, intensity�� �ּҷ� ���� �� �ִ� ��ȣ => 1�� 5�� �ϳ��� ���� ��
		// ex) ���Ա� 7, ���츮 5�� �����ߴٸ� : 7 - (1) - 6 - (1) - 5 - (1) - 6 - (1) - 7 (intensity�� 1)
		// ���ƴ� ���� ũ�� �� �ִ� ���� intensity�� �ȴ�. �츮�� �� intensity�� �ּҰ� �Ǵ� ���Ա��� ���츮�� ã�ƾ� �Ѵ�.
		// 7 - (1) - 6 - (7) - 2 - (7) - 6 - (1) - 5 - (1) - 6 - (1) - 7
		// �ٸ� ��Ʈ�� ��ģ�ٰ� �ؼ� �ʼ��� ��ġ�� ���Ա� ~ ���츮������ intensity�� ���� ���� ����.
		// ��, ���Ա�(A) - ��(B) - ���츮(C) - ��(B) - ���Ա�(A)�� ����, ���� ��� �ǵ��ƿ��� ��Ʈ�� �����ϸ� �ȴٴ� �ǹ��̴�.
		// ���� ���
		// ���Ա� 3, ���츮 1 : 3-2-1-2-3 => 3-2-1 �Ǵ� 1-2-3�� ���� ��
		// ���Ա� 3, ���츮 5 : 3-2-6-5-6-2-3 => 3-2-6-5 �Ǵ� 5-6-2-3�� ���� ��
		// ���Ա� 7, ���츮 1 : 7-6-2-1-2-6-7 => 7-6-2-1 �Ǵ� 1-2-6-7�� ���� ��
		// ���Ա� 7, ���츮 5 : 7-6-5-6-7 => 7-6-5 �Ǵ� 5-6-7�� ���� ��
		// �� ���������� ���츮 ��ȣ�� intensity �ּҰ��� ���ϹǷ�, ���츮���� ��� -> ���Ա� ���� ��Ʈ�� ������ Ǯ�ڴ�.
		
		System.out.println(solution(n, paths, gates, summits)); // {5, 1} // {���츮 ��ȣ, intensity �ּҰ�}
	}

}
