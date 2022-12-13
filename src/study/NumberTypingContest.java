package study;

public class NumberTypingContest {
	
	// ���� Ÿ�� ��ȸ
	
	public static int[][] weight = { // ����ġ
			{1, 7, 6, 7, 5, 4, 5, 3, 2, 3}, // 0�������� 0 ~ 9������ ����ġ
			{7, 1, 2, 4, 2, 3, 5, 4, 5, 6}, // 1�������� 0 ~ 9������ ����ġ
			{6, 2, 1, 2, 3, 2, 3, 5, 4, 5}, // 2�������� 0 ~ 9������ ����ġ
			{7, 4, 2, 1, 5, 3, 2, 6, 5, 4}, // 3�������� 0 ~ 9������ ����ġ
			{5, 2, 3, 5, 1, 2, 4, 2, 3, 5}, // 4�������� 0 ~ 9������ ����ġ
			{4, 3, 2, 3, 2, 1, 2, 3, 2, 3}, // 5�������� 0 ~ 9������ ����ġ
			{5, 5, 3, 2, 4, 2, 1, 5, 3, 2}, // 6�������� 0 ~ 9������ ����ġ
			{3, 4, 5, 6, 2, 3, 5, 1, 2, 4}, // 7�������� 0 ~ 9������ ����ġ
			{2, 5, 4, 5, 3, 2, 3, 2, 1, 2}, // 8�������� 0 ~ 9������ ����ġ
			{3, 6, 5, 4, 5, 3, 2, 4, 2, 1}  // 9�������� 0 ~ 9������ ����ġ
	};
	public static int[][][] dp; // depth, �޼� �հ��� ��ġ, ������ �հ��� ��ġ
	public static String targetNumbers; // numbers
	public static int targetDepth; // numbers�� depth
	
	public static int contest(int depth, int lPos, int rPos) {
		
		if (depth == targetDepth + 1) { // targetDepth�� �Ѿ��ٸ�
			return 0;
		}
		
		if (dp[depth][lPos][rPos] != 0) { // �̹� ���� ���̶��
			return dp[depth][lPos][rPos];
		}
		
		int targetPos = targetNumbers.charAt(depth) - '0'; // 1 // 7 // 5 // 6
		int result = Integer.MAX_VALUE;
		
		// �޼� �հ������� ������
		if (targetPos != rPos) { // ������ �հ������� �ٷ� ���� �� �ִ� ��Ȳ(������ �հ������� ������ �� �ּ� ����ġ�� ����Ǵ� ��Ȳ)�� �ƴ϶��, �޼� �հ������� ��������
			result = Math.min(contest(depth + 1, targetPos, rPos) + weight[lPos][targetPos], result);
		}
		
		// ������ �հ������� ������
		if (targetPos != lPos) { // �޼� �հ������� �ٷ� ���� �� �ִ� ��Ȳ(�޼� �հ������� ������ �� �ּ� ����ġ�� ����Ǵ� ��Ȳ)�� �ƴ϶��, ������ �հ������� ��������
			result = Math.min(contest(depth + 1, lPos, targetPos) + weight[rPos][targetPos], result);
		}
		
		dp[depth][lPos][rPos] = result;
		
		return dp[depth][lPos][rPos];
	}
	
	public static int solution(String numbers) {
		targetNumbers = numbers; // "1756"
		targetDepth = numbers.length() - 1; // 3
		
		dp = new int [targetDepth + 1][10][10]; // 0 ~ 3 // 0 ~ 9 // 0 ~ 9
		
		return contest(0, 4, 6); // �ʱ� depth 0, �ʱ� �޼� �հ��� ��ġ 4, �ʱ� ������ �հ��� ��ġ 6
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "1756"; // 0 ~ 3 depth
		
		System.out.println(solution(numbers)); // 10
	}
}