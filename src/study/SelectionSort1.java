package study;

public class SelectionSort1 {
	
	// ���� ����
	// ó������ ���� ������ �߿��� ���� ���� �����͸� ������ �� �տ� �ִ� �����Ϳ� �ٲٴ� ���� �ݺ�

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		int minIdx = 0;
		int temp = 0;
		
		// step1 : 7 ���� ��� 5 ~ 8 �� ���� ���� ������ 0 ��
		// step2 : 7�� 0�� ��ġ ����
		// step3 : (����� 0�� ���ΰ�) 5 ���� ��� 9 ~ 8 �� ���� ���� ������ 1 ��
		// step4 : 5�� 1�� ��ġ ����
		
		for(int i = 0; i < n; i++) {
			minIdx = i; // 0
			
			for(int j = i + 1; j < n; j++) { // 1 ~ 9���� �˻�
				
				if(arr[minIdx] > arr[j]) { // �̷��� �ϸ� 1 ~ 9 �� ���� ���� ���� �ε����� minIdx�� ���� ��
					minIdx = j;
				}
			}
			
			// i��°�� minIdx��°�� �� �ٲٱ�
			temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		
		for(int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
	}
}