package study;

public class MaxSubsequence {
	
	// �ִ� ���� �κ� ������ ��
	// ���� ��, ���� �ִ밪 ����
	// 1. ���� ���� �ݺ������� ���Ѵ�.
	// 2. �� �� ���� �����̸� �� ���� ������ �ٽ� ����
	// 3. ���� �ִ밪�� ����
	
	public static int getMaxSubsequence(int[] arr) {
		int temp = 0;
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			temp += arr[i];
			
			if (temp > max) {
				max = temp;
			} else if (temp < 0) {
				temp = 0;
			}
		}
		
		return max;
	}
	
	public static int getMaxElementForNegativeArr(int[] arr) { // �迭�� ���Ұ� ���� ������ ���
		int max = -10000;
		
		for (int i = 0; i < arr.length; i++) {
			
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		
		return max;
	}

	public static int solution(int[] arr) {
		
		int result = getMaxSubsequence(arr);
		
		if (result != 0) {
			return result;
		} else { // result ���� 0�̶�� �� �迭�� ���Ұ� ��� ������� ���
			return getMaxElementForNegativeArr(arr);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-3, 3, 5, -3, -7, 9, -2, 10, -5, -2};
		// 0 ��° -3 : ���� �� 0, ���� �ִ밪 0
		// 1 ��° 3 : ���� �� 3, ���� �ִ밪 3 (0���� ũ�Ƿ� ����)
		// 2 ��° 5 : ���� �� 8, ���� �ִ밪 8 (3���� ũ�Ƿ� ����)
		// 3 ��° -3 : ���� �� 5, ���� �ִ밪 8 (���ŵ��� ����)
		// 4 ��° -7 : ���� �� 0 (else if ���ǹ��� ���� -2 -> 0), ���� �ִ밪 8 (���ŵ��� ����)
		// 5 ��° 9 : ���� �� 9, ���� �ִ밪 9 (8���� ũ�Ƿ� ����)
		// 6 ��° -2 : ���� �� 7, ���� �ִ밪 9 (���ŵ��� ����)
		// 7 ��° 10 : ���� �� 17, ���� �ִ밪 17 (9���� ũ�Ƿ� ����)
		// 8 ��° -5 : ���� �� 12, ���� �ִ밪 17 (���ŵ��� ����)
		// 9 ��° -2 : ���� �� 10, ���� �ִ밪 17 (���ŵ��� ����)
		
		System.out.println(solution(arr)); // ���� �ִ밪 17
	}
}