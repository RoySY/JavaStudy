package study;

public class InsertionSort1 {
	
	// ���� ����
	// ó������ ���� �����͸� �ϳ��� ��� ������ ��ġ�� ����
	// ���� ���Ŀ� ���� ���� ���̵��� ���� ��������, �Ϲ������� �� ȿ�������� ����

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		int temp = 0;
		
		// step1 : ù ���� �������� 7�� �� ��ü�� ���� �Ǿ��ִٰ� �Ǵ��ϰ�, �� ��° �������� 5���� �������� ��´�.
		// step2 : ���� �������� 7���� �����Ƿ� 5�� 7�� ��ġ�� �������ش�.
		// step3 : �� ��° �������� 9�� �������� ��� ���� 7, 5�� �񱳸� �� ���̴�.
		// step4 : 7���� ũ�Ƿ� break
		// step5 : �� ��° �������� 0�� �������� ��� ���� 9, 7, 5�� �񱳸� �� ���̴�.
		// step6 : 9�� ��ġ ����, 7�� ��ġ ����, 5�� ��ġ �����Ͽ� 0, 5, 7, 9�� �ȴ�.
		
		for(int i = 1; i < n; i++) {
			
			for(int j = i; j > 0; j--) {
				
				if(arr[j] < arr[j-1]) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				} else {
					break;
				}
			}
		}
		
		for(int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
	}
}