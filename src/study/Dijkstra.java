package study;

public class Dijkstra {
	
	public static int n = 6;
	public static int INF = 1000000;
	public static int[][] arr = {{0, 2, 5, 1, INF, INF}, {2, 0, 3, 2, INF, INF}, {5, 3, 0, 3, 1, 5}, {1, 2, 3, 0, 1, INF}, {INF, INF, 1, 1, 0, 2}, {INF, INF, 5, INF, 2, 0}};
	public static boolean[] visited = new boolean[n];
	public static int[] minDistance = new int[n];
	
	
	// ���� Ž�� Ǯ��
	public static int getSmallestValueIndex() { // �湮���� ���� ���� �� �ּ� �Ÿ��� ���� ������ �ε����� ��ȯ���ֱ� ���� �Լ�
		int minValue = INF;
		int minValueIndex = 0;
		
		for (int i = 0; i < n; i++) {
			
			if (!visited[i] && minDistance[i] < minValue) { // �湮���� ���� ���� �� �ִ� �Ÿ��� ������ �ε��� ã��
				minValue = minDistance[i];
				minValueIndex = i;
			}
		}
		return minValueIndex;
	}
	
	public static void dijkstra(int startIndex) {
		
		// STEP 1. �Է¹��� ���� �ε�������� �� ���������� �Ÿ��� �ִ� �Ÿ��� SET
		for (int i = 0; i < n; i++) {
			minDistance[i] = arr[startIndex][i]; // ���� �ε��� 0���κ��� �� ���������� �Ÿ��� �ּҰ����� ����
		}
		// {0, 2, 5, 1, INF, INF}
		
		// STEP 2. ���� �ε��� �湮ó��
		visited[startIndex] = true;
		// {true, false, false, false, false, false}
		
		// STEP 3 ~ STEP 6
		for (int i = 0; i < n - 2; i++) { // n - 2�� ���� ���� �� ȿ������ ���� : �Ʒ��� �� �ּ� �κ� ����
			
			// STEP 3. �湮���� ���� ���� �� �ּ� �Ÿ��� ���� ���� �ε��� ��������
			int minIndex = getSmallestValueIndex(); // �ٷ� ���� �ݺ����� getSmallestValueIndex(�湮���� ���� �ּ� �Ÿ��� ���� ������ �ε����� �������� �Լ�)�� ȣ���ؾ� �ϴ� Ƚ���� �ǹ�
			// minIndex : 3
			
			// STEP 4. �ּ� �Ÿ��� ���� ���� �湮ó�� => ���� ���׿��� �ּ� �Ÿ��� ���´ٴ� ����, �ٸ� ����(�ּ� �Ÿ����� ū ��)�� ������ ��� ���� ���� ���ŵ� �� ������ �ǹ�
			visited[minIndex] = true;
			// {true, false, false, true, false, false}
			
			// STEP 5. �ּ� �Ÿ��� ���� �������κ��� �湮���� ���� �ٸ� ���������� �Ÿ� üũ
			for (int j = 0; j < n; j++) {
				
				if (!visited[j]) { // �湮���� ���� �����̶��
					
					// STEP 6. �ּ� �Ÿ��� ���� ������ ���ļ� �ٸ� ������ ���� �Ÿ��� �� ���� ��� ����
					if (minDistance[minIndex] + arr[minIndex][j] < minDistance[j]) { // �ּ� �Ÿ��� ���� ���������� �Ÿ� + �ּ� �Ÿ� �������κ��� �湮���� ���� �ٸ� ���������� �Ÿ��� �ٸ� ���������� �ּ� �Ÿ����� �۴ٸ�
						minDistance[j] = minDistance[minIndex] + arr[minIndex][j]; // ���İ��� ����� �Ÿ� ���� �� �����Ƿ� �ּ� �Ÿ� ����
					}
				}
			}
		} 
	}
	
	// �� �湮���� ���� �ּ� �Ÿ��� ���� ������ �ε����� �����;� �ϴ� Ƚ���� �ǹ� => �̹� �湮�� startIndex�� �����Ƿ� �ݺ� Ƚ�� -1,
	// �� n - 1�� ���� ��� �ݺ����� �帧 �� getSmallestValueIndex���� ������ ������ �ε����� STEP 4���� �湮ó���� �ǰ�(��� �湮�� ��ģ ����), STEP 5 �ݺ����� �ƹ� �ǹ̰� ���� ��Ȳ�� �ȴ�.
	// �� �� ������ minDistance�� �����ϱ� ��������, �湮�� ������ �ִ� ���� �ƴϹǷ� Ƚ���� �ѹ� �� �ٿ� n - 2�� �ص� ���� ����� ���´�.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dijkstra(0); // ���� �ε��� 0
		
		for (int i = 0; i < minDistance.length; i++) {
			System.out.print(minDistance[i] + " "); // ���ͽ�Ʈ�� ���� ���ŵ� �ִ� �Ÿ� ���
		}
	}
}
