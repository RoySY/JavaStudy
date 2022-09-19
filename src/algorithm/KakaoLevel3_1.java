package algorithm;

public class KakaoLevel3_1 {
	
	// 파괴되지 않은 건물
	
	public static int solution(int[][] board, int[][] skill) {
		int answer = 0;
		int N = board.length;
		int M = board[0].length;
		int[][] sumArr = new int[N+1][M+1];
		int[] infoArr = new int[skill[0].length];
		int startRowNum = 0;
		int startColNum = 0;
		int endRowNum = 0;
		int endColNum = 0;
		int affectPoint = 0;
        
		for (int i = 0; i < skill.length; i++) {
			infoArr = skill[i];
        	
			startRowNum = infoArr[1];
			startColNum = infoArr[2];
			endRowNum = infoArr[3];
			endColNum = infoArr[4];
        	
			affectPoint = (infoArr[0] == 1 ? -infoArr[5] : infoArr[5]);
        	
			sumArr[startRowNum][startColNum] += affectPoint; // 좌상 +
			sumArr[startRowNum][endColNum + 1] += -affectPoint; // 좌하 -
			sumArr[endRowNum + 1][startColNum] += -affectPoint; // 우상 -
			sumArr[endRowNum + 1][endColNum + 1] += affectPoint; // 우하 +
		}
        
        
		// 상하의 합
		for (int i = 1; i < N; i++) {
        	
			for (int j = 0; j < M; j++) {
				sumArr[i][j] += sumArr[i - 1][j];
			}
		}
        
		// 좌우의 합
		for (int j = 1; j < M; j++) {
        	
			for (int i = 0; i < N; i++) {
				sumArr[i][j] += sumArr[i][j - 1];
			}
		}
        
		for (int i = 0; i < N; i++) {
        	
			for (int j = 0; j < M; j++) {
        		
				if (board[i][j] + sumArr[i][j] > 0) {
					answer++;
				}
			}
		}
        
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}; // 4개의 행 5개의 열
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}; // 1은 공격, 2는 회복 // {1,0,0,3,4,4}는 공격이며 0행0열 ~ 3행4열까지 4의 피해를 준다는 의미
		
		System.out.println(solution(board, skill)); // 10
	}

}
