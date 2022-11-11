package study;

public class Tiredness {
	
	// 피로도
	
	static int answer = 0;
	static boolean[] visited = {};
	
	public static void dfs(int depth, int k, int[][] dungeons) {
		
		for (int i = 0; i < dungeons.length; i++) {
			
			if (!visited[i] && dungeons[i][0] <= k) { // depth가 0 & 첫 번째 던전에서 dfs -> depth가 0 & 두 번째 던전에서 dfs -> depth가 0 & 세 번째 던전에서 dfs
				visited[i] = true; // 해당 던전을 방문한 상태에서 다음 depth로 dfs
				dfs(depth + 1, k - dungeons[i][1], dungeons); // depth가 1 & 위 3가지 각각의 경우에 대해 방문하지 않은 던전 dfs
				visited[i] = false; // 해당 던전으로의 dfs가 끝났으므로 다시 방문 전 상태로 변경
			}
		}
		
		answer = Math.max(answer, depth); // 몇 번째 depth까지 들어갈 수 있는지 확인
	}
	
	public static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		
		dfs(0, k, dungeons); // depth, 현재 피로도, 던전 배열
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}}; // 최소 필요 피로도, 소모 피로도 // {80,20} -> {30,10} -> {50,40} 가능
		
		System.out.println(solution(k, dungeons)); // 3
	}
}