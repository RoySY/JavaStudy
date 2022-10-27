package study;

public class DynamicProgramming2 {
	
	// DP : ��������
	// ���ӵ� â��� ������ �� ����.
	// â�� 1, 3, 1, 5�� �� ���� ���� �ķ��� ���� �� �ִ� �����? 
	// 8
	
	static int n = 4;
	static int[] arr = {1, 3, 1, 5};
	static int[] d = {};
	
	// ��ȭ�� ai = max(ai-1, ai-2 + ki)
	
	public static void dp() {
		
		d = new int[n];
		
		d[0] = arr[0];
		d[1] = Math.max(arr[0], arr[1]);
		
		for (int i = 2; i < n; i++) {
			d[i] = Math.max(arr[i - 1], arr[i - 2] + arr[i]);
		}
		
		System.out.println(d[n - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp();
	}

}
