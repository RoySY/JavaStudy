package study;

public class FloydWarshall {
	
	// 플로이드 워셜 알고리즘
	// 다익스트라 알고리즘은 하나의 정점에서 출발했을 때 다른 모든 정점으로의 최단 경로를 구하는 알고리즘이다.
	// 만약 모든 정점에서 모든 정점으로의 최단 경로를 구하고 싶다면 플로이드 워셜 알고리즘을 사용해야 한다.
	
	static int number = 4;
	static int INF = 100000000;
	static int[][] originArr = {{0, 5, INF, 8}, {7, 0, 9, INF}, {2, INF, 0, 4}, {INF, INF, 3, 0}}; // 자료 배열 초기화
	
	public static void floydWarshall() {
		int[][] renewArr = new int[number][number]; // 결과 배열 초기화
		
		for (int i = 0; i < number; i++) {
			
			for (int j = 0; j < number; j++) {
				renewArr[i][j] = originArr[i][j]; // 결과 배열을 초기 자료 배열과 동일하게 만들어 준다.
			}
		}
		
		// k : 거쳐가는 노드
		for (int k = 0; k < number; k++) {
			
			// i : 출발 노드
			for (int i = 0; i < number; i++) {
				
				// j : 도착 노드
				for (int j = 0; j < number; j++) {
					
					if (renewArr[i][k] + renewArr[k][j] < renewArr[i][j]) { // k 노드를 거쳐갈 때 거리 값이 더 작다면
						renewArr[i][j] = renewArr[i][k] + renewArr[k][j]; // i 노드에서 j 노드로 가는 최단 거리 갱신
					}
				}
			}
		}
		
		for (int i = 0; i < number; i++) {
			
			for (int j = 0; j < number; j++) {
				System.out.print(renewArr[i][j] + " "); // 결과 배열 출력
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		floydWarshall();
	}
}