package study;

public class NumberTypingContest {
	
	// 숫자 타자 대회
	
	public static int[][] weight = { // 가중치
			{1, 7, 6, 7, 5, 4, 5, 3, 2, 3}, // 0에서부터 0 ~ 9까지의 가중치
			{7, 1, 2, 4, 2, 3, 5, 4, 5, 6}, // 1에서부터 0 ~ 9까지의 가중치
			{6, 2, 1, 2, 3, 2, 3, 5, 4, 5}, // 2에서부터 0 ~ 9까지의 가중치
			{7, 4, 2, 1, 5, 3, 2, 6, 5, 4}, // 3에서부터 0 ~ 9까지의 가중치
			{5, 2, 3, 5, 1, 2, 4, 2, 3, 5}, // 4에서부터 0 ~ 9까지의 가중치
			{4, 3, 2, 3, 2, 1, 2, 3, 2, 3}, // 5에서부터 0 ~ 9까지의 가중치
			{5, 5, 3, 2, 4, 2, 1, 5, 3, 2}, // 6에서부터 0 ~ 9까지의 가중치
			{3, 4, 5, 6, 2, 3, 5, 1, 2, 4}, // 7에서부터 0 ~ 9까지의 가중치
			{2, 5, 4, 5, 3, 2, 3, 2, 1, 2}, // 8에서부터 0 ~ 9까지의 가중치
			{3, 6, 5, 4, 5, 3, 2, 4, 2, 1}  // 9에서부터 0 ~ 9까지의 가중치
	};
	public static int[][][] dp; // depth, 왼손 손가락 위치, 오른손 손가락 위치
	public static String targetNumbers; // numbers
	public static int targetDepth; // numbers의 depth
	
	public static int contest(int depth, int lPos, int rPos) {
		
		if (depth == targetDepth + 1) { // targetDepth를 넘었다면
			return 0;
		}
		
		if (dp[depth][lPos][rPos] != 0) { // 이미 구한 값이라면
			return dp[depth][lPos][rPos];
		}
		
		int targetPos = targetNumbers.charAt(depth) - '0'; // 1 // 7 // 5 // 6
		int result = Integer.MAX_VALUE;
		
		// 왼손 손가락으로 누르기
		if (targetPos != rPos) { // 오른손 손가락으로 바로 누를 수 있는 상황(오른손 손가락으로 눌렀을 때 최소 가중치가 보장되는 상황)이 아니라면, 왼손 손가락으로 눌러보기
			result = Math.min(contest(depth + 1, targetPos, rPos) + weight[lPos][targetPos], result);
		}
		
		// 오른손 손가락으로 누르기
		if (targetPos != lPos) { // 왼손 손가락으로 바로 누를 수 있는 상황(왼손 손가락으로 눌렀을 때 최소 가중치가 보장되는 상황)이 아니라면, 오른손 손가락으로 눌러보기
			result = Math.min(contest(depth + 1, lPos, targetPos) + weight[rPos][targetPos], result);
		}
		
		dp[depth][lPos][rPos] = result;
		
		return dp[depth][lPos][rPos];
	}
	
	public static int solution(String numbers) {
		targetNumbers = numbers; // "1756"
		targetDepth = numbers.length() - 1; // 3
		
		dp = new int [targetDepth + 1][10][10]; // 0 ~ 3 // 0 ~ 9 // 0 ~ 9
		
		return contest(0, 4, 6); // 초기 depth 0, 초기 왼손 손가락 위치 4, 초기 오른손 손가락 위치 6
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "1756"; // 0 ~ 3 depth
		
		System.out.println(solution(numbers)); // 10
	}
}