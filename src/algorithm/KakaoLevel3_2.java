package algorithm;

import java.util.*;

public class KakaoLevel3_2 {
	
	// 등산코스 정하기
	
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
		
		boolean[] targetNode = new boolean[totalNum + 1]; // 1개의 출입구, 1개의 봉우리만 지나도록 boolean 배열
		
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
			maxOfMinIntensityMap.put(key, INF); // 최소 Intensity 코스 중 최대 Intensity 값 무한대로 초기화
		}
		
		maxOfMinIntensityMap.put(summit, 0); // 출발 봉우리의 Intensity값 0
		
		pq.add(new IntensityNode(summit, 0));
		
		while (!pq.isEmpty()) {
			pqNode = pq.poll();
			
			if (pqNode.getIntensity() > maxOfMinIntensityMap.get(pqNode.getIndex())) {
				continue;
			}
			
			nodeList = nodeListMap.get(pqNode.getIndex());
			
			for (IntensityNode node : nodeList) {
				
				if (!targetNode[node.getIndex()]) {
					continue; // 지정된 봉우리, 출입구가 아닐 경우 경유 불가
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
        
		Arrays.sort(arrSummits); // intensity값 같을 경우 봉우리 번호 작은 것이 대상이 되도록 정렬 & 답 구할 때 더 작은 intensity값이 있을 경우에만 갱신되도록
        
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
		
		// gates 중 하나의 번호만 선택 가능하며, 제일 처음과 마지막이어야 함 => 3 - ... - 3
		// summits 중 하나만 선택 가능하며, intensity를 최소로 만들 수 있는 번호 => 1과 5중 하나만 들어가야 함
		// ex) 출입구 7, 봉우리 5를 선택했다면 : 7 - (1) - 6 - (1) - 5 - (1) - 6 - (1) - 7 (intensity는 1)
		// 거쳤던 길의 크기 중 최대 값이 intensity가 된다. 우리는 그 intensity가 최소가 되는 출입구와 봉우리를 찾아야 한다.
		// 7 - (1) - 6 - (7) - 2 - (7) - 6 - (1) - 5 - (1) - 6 - (1) - 7
		// 다른 루트를 거친다고 해서 필수로 거치는 출입구 ~ 봉우리까지의 intensity를 낮출 수는 없다.
		// 즉, 출입구(A) - 길(B) - 봉우리(C) - 길(B) - 출입구(A)와 같이, 갔던 길로 되돌아오는 루트만 생각하면 된다는 의미이다.
		// 예를 들면
		// 출입구 3, 봉우리 1 : 3-2-1-2-3 => 3-2-1 또는 1-2-3만 봐도 됨
		// 출입구 3, 봉우리 5 : 3-2-6-5-6-2-3 => 3-2-6-5 또는 5-6-2-3만 봐도 됨
		// 출입구 7, 봉우리 1 : 7-6-2-1-2-6-7 => 7-6-2-1 또는 1-2-6-7만 봐도 됨
		// 출입구 7, 봉우리 5 : 7-6-5-6-7 => 7-6-5 또는 5-6-7만 봐도 됨
		// 이 문제에서는 봉우리 번호와 intensity 최소값을 원하므로, 봉우리에서 출발 -> 출입구 도착 루트로 문제를 풀겠다.
		
		System.out.println(solution(n, paths, gates, summits)); // {5, 1} // {봉우리 번호, intensity 최소값}
	}

}
