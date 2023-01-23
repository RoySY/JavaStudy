package study;

public class CountingSort1 {
	
	// ��� ����
	// ���� ���⵵�� ������ ���Ǹ� �����ϸ�(�������� ũ�Ⱑ �����Ǿ� �ִ� ���) ������. �ð� ���⵵�� ���� ���⵵ ��� O(N+K)
	// ��� ������ ������ ���� ������ �����Ͱ� ���� �� ������ �� ȿ�������� ����� �� �ִ�.
	// ������ ��� 100���� ���� �л��� ���� ���� �� �ֱ� ������ ��� ������ ȿ����
	
	static final int MAX_VALUE = 9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 15;
		
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2}; // 0 ~ 9������ ���ڸ� ���� => 0 ~ 9 �ε��� �迭 ���� => �� ���� üũ�Ͽ� �ش� �ε��� �� 1�� ����
		
		int[] cnt = new int[MAX_VALUE + 1]; // int���̹Ƿ� 0���� �ʱ�ȭ
		
		for(int i = 0; i < n; i++) {
			cnt[arr[i]] += 1;
		}
		
		for(int i = 0; i <= MAX_VALUE; i++) {
			for(int j = 0; j < cnt[i]; j++) {
				System.out.print(i + " "); // 0 0 1 1 2 2 3 4 5 5 6 7 8 9 9 
			}
		}
	}
}