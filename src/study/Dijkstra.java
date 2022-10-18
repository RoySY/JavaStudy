package study;

public class Dijkstra {
	
	public static int n = 6;
	public static int INF = 1000000;
	public static int[][] arr = {{0, 2, 5, 1, INF, INF}, {2, 0, 3, 2, INF, INF}, {5, 3, 0, 3, 1, 5}, {1, 2, 3, 0, 1, INF}, {INF, INF, 1, 1, 0, 2}, {INF, INF, 5, INF, 2, 0}};
	public static boolean[] visited = new boolean[n];
	public static int[] minDistance = new int[n];
	
	
	// 선형 탐색 풀이
	public static int getSmallestValueIndex() { // 방문하지 않은 정점 중 최소 거리를 갖는 정점의 인덱스를 반환해주기 위한 함수
		int minValue = INF;
		int minValueIndex = 0;
		
		for (int i = 0; i < n; i++) {
			
			if (!visited[i] && minDistance[i] < minValue) { // 방문하지 않은 정점 중 최단 거리인 정점의 인덱스 찾기
				minValue = minDistance[i];
				minValueIndex = i;
			}
		}
		return minValueIndex;
	}
	
	public static void dijkstra(int startIndex) {
		
		// STEP 1. 입력받은 시작 인덱스토부터 각 정점까지의 거리를 최단 거리로 SET
		for (int i = 0; i < n; i++) {
			minDistance[i] = arr[startIndex][i]; // 시작 인덱스 0으로부터 각 정점까지의 거리를 최소값으로 세팅
		}
		// {0, 2, 5, 1, INF, INF}
		
		// STEP 2. 시작 인덱스 방문처리
		visited[startIndex] = true;
		// {true, false, false, false, false, false}
		
		// STEP 3 ~ STEP 6
		for (int i = 0; i < n - 2; i++) { // n - 2를 쓰는 것이 더 효율적인 이유 : 아래에 ★ 주석 부분 참고
			
			// STEP 3. 방문하지 않은 정점 중 최소 거리를 갖는 정점 인덱스 가져오기
			int minIndex = getSmallestValueIndex(); // 바로 위의 반복문은 getSmallestValueIndex(방문하지 않은 최소 거리를 갖는 정점의 인덱스를 가져오는 함수)를 호출해야 하는 횟수를 의미
			// minIndex : 3
			
			// STEP 4. 최소 거리를 갖는 정점 방문처리 => 현재 상테에서 최소 거리를 갖는다는 말은, 다른 정점(최소 거리보다 큰 값)을 거쳤을 경우 값이 절대 갱신될 수 없음을 의미
			visited[minIndex] = true;
			// {true, false, false, true, false, false}
			
			// STEP 5. 최소 거리를 갖는 정점으로부터 방문하지 않은 다른 정점까지의 거리 체크
			for (int j = 0; j < n; j++) {
				
				if (!visited[j]) { // 방문하지 않은 정점이라면
					
					// STEP 6. 최소 거리를 갖는 정점을 거쳐서 다른 정점을 가는 거리가 더 작을 경우 갱신
					if (minDistance[minIndex] + arr[minIndex][j] < minDistance[j]) { // 최소 거리를 갖는 정점까지의 거리 + 최소 거리 정점으로부터 방문하지 않은 다른 정점까지의 거리가 다른 정점까지의 최소 거리보다 작다면
						minDistance[j] = minDistance[minIndex] + arr[minIndex][j]; // 거쳐갔을 경우의 거리 값이 더 작으므로 최소 거리 갱신
					}
				}
			}
		} 
	}
	
	// ★ 방문하지 않은 최소 거리를 갖는 정점의 인덱스를 가져와야 하는 횟수를 의미 => 이미 방문한 startIndex가 있으므로 반복 횟수 -1,
	// ★ n - 1로 했을 경우 반복문의 흐름 상 getSmallestValueIndex에서 나오는 마지막 인덱스는 STEP 4에서 방문처리가 되고(모두 방문을 마친 상태), STEP 5 반복문이 아무 의미가 없는 상황이 된다.
	// ★ 이 문제는 minDistance를 갱신하기 위함이지, 방문에 목적이 있는 것이 아니므로 횟수를 한번 더 줄여 n - 2를 해도 같은 결과가 나온다.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dijkstra(0); // 시작 인덱스 0
		
		for (int i = 0; i < minDistance.length; i++) {
			System.out.print(minDistance[i] + " "); // 다익스트라 이후 갱신된 최단 거리 출력
		}
	}
}
