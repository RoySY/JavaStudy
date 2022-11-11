package study;

public class Tiredness {
	
	// �Ƿε�
	
	static int answer = 0;
	static boolean[] visited = {};
	
	public static void dfs(int depth, int k, int[][] dungeons) {
		
		for (int i = 0; i < dungeons.length; i++) {
			
			if (!visited[i] && dungeons[i][0] <= k) { // depth�� 0 & ù ��° �������� dfs -> depth�� 0 & �� ��° �������� dfs -> depth�� 0 & �� ��° �������� dfs
				visited[i] = true; // �ش� ������ �湮�� ���¿��� ���� depth�� dfs
				dfs(depth + 1, k - dungeons[i][1], dungeons); // depth�� 1 & �� 3���� ������ ��쿡 ���� �湮���� ���� ���� dfs
				visited[i] = false; // �ش� ���������� dfs�� �������Ƿ� �ٽ� �湮 �� ���·� ����
			}
		}
		
		answer = Math.max(answer, depth); // �� ��° depth���� �� �� �ִ��� Ȯ��
	}
	
	public static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		
		dfs(0, k, dungeons); // depth, ���� �Ƿε�, ���� �迭
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}}; // �ּ� �ʿ� �Ƿε�, �Ҹ� �Ƿε� // {80,20} -> {30,10} -> {50,40} ����
		
		System.out.println(solution(k, dungeons)); // 3
	}
}