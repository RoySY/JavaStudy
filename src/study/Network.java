package study;

public class Network {
	
	// 네트워크
	
	static boolean[] visited = {};
	
	public static void dfs(int i, int[][] computers) {
		visited[i] = true;
		
		for(int j = 0; j < computers[i].length; j++) {
			
			if(!visited[j] && computers[i][j] == 1) {
				dfs(j, computers);
			}
		}
	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		
		visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
        	
			if(!visited[i]) {
				answer++;
				dfs(i, computers);
			}
		}
        
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3; // 3대의 컴퓨터
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; // 연결된 네트워크
		
		System.out.println(solution(n, computers)); // 2 // 전체 컴퓨터 수에서 간선의 수를 빼면 된다.
	}
}