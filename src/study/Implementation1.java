package study;

public class Implementation1 {
	
	// ���� : �ùķ��̼ǰ� ���� Ž��
	// �Ӹ��ӿ� �ִ� �˰����� �ҽ��ڵ�� �ٲٴ� ����
	// Ǯ�̸� ���ø��� ���� ������ �ҽ��ڵ�� �ű�� ���� ����� ����
	
	// �˰����� �����ѵ� �ڵ尡 ����ĥ ��ŭ ������� ����
	// �Ǽ� ������ �ٷ��, Ư�� �Ҽ��� �ڸ����� ����ؾ� �ϴ� ����
	// ���ڿ��� Ư���� ���ؿ� ���� ���� ó���ؾ� �ϴ� ����
	// ������ ���̺귯���� ã�Ƽ� ����ؾ� �ϴ� ����
	
	// �����¿� ����
	
	public static void solution(int n, String[] arr) {
		
		// ���� ���� (0, 0), ������ ũ�� n x n
		int row = 0;
		int col = 0;
		
		for (int i = 0; i < arr.length; i++) {

			if ("U".equals(arr[i])) {
				
				if (row + 1 > n - 1) {
					continue;
				}
				row = row + 1;
			} else if ("D".equals(arr[i])) {
				
				if (row - 1 < 0) {
					continue;
				}
				
				row = row - 1;
			} else if ("L".equals(arr[i])) {
				
				if (col - 1 < 0) {
					continue;
				}
				
				col = col - 1;
			} else if ("R".equals(arr[i])) {
				
				if (col + 1 > n - 1) {
					continue;
				}
				
				col = col + 1;
			}
		}
		
		System.out.println(row + ", " + col);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		String[] arr = {"R", "R", "R", "U", "D", "D"}; // 0,0���� ���� 3,4
		
		solution(n, arr);
	}
}