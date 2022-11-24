package study;

public class FloydWarshall {
	
	// �÷��̵� ���� �˰���
	// ���ͽ�Ʈ�� �˰����� �ϳ��� �������� ������� �� �ٸ� ��� ���������� �ִ� ��θ� ���ϴ� �˰����̴�.
	// ���� ��� �������� ��� ���������� �ִ� ��θ� ���ϰ� �ʹٸ� �÷��̵� ���� �˰����� ����ؾ� �Ѵ�.
	
	static int number = 4;
	static int INF = 100000000;
	static int[][] originArr = {{0, 5, INF, 8}, {7, 0, 9, INF}, {2, INF, 0, 4}, {INF, INF, 3, 0}}; // �ڷ� �迭 �ʱ�ȭ
	
	public static void floydWarshall() {
		int[][] renewArr = new int[number][number]; // ��� �迭 �ʱ�ȭ
		
		for (int i = 0; i < number; i++) {
			
			for (int j = 0; j < number; j++) {
				renewArr[i][j] = originArr[i][j]; // ��� �迭�� �ʱ� �ڷ� �迭�� �����ϰ� ����� �ش�.
			}
		}
		
		// k : ���İ��� ���
		for (int k = 0; k < number; k++) {
			
			// i : ��� ���
			for (int i = 0; i < number; i++) {
				
				// j : ���� ���
				for (int j = 0; j < number; j++) {
					
					if (renewArr[i][k] + renewArr[k][j] < renewArr[i][j]) { // k ��带 ���İ� �� �Ÿ� ���� �� �۴ٸ�
						renewArr[i][j] = renewArr[i][k] + renewArr[k][j]; // i ��忡�� j ���� ���� �ִ� �Ÿ� ����
					}
				}
			}
		}
		
		for (int i = 0; i < number; i++) {
			
			for (int j = 0; j < number; j++) {
				System.out.print(renewArr[i][j] + " "); // ��� �迭 ���
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		floydWarshall();
	}
}