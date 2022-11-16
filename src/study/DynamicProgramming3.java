package study;

public class DynamicProgramming3 {
	
	// DP : 1�� �����
	// ���� X�� �־����� �� ���� ������ ����Ͽ� 1�� ���� �� �ִ� �ּ� Ƚ��
	// X�� 5�� ������ ��������, 5�� ������.
	// X�� 3���� ������ ��������, 3���� ������.
	// X�� 2�� ������ ��������, 2�� ������.
	// X���� 1�� ����.
	// �� ������ ���� �κ� ������ �����Ѵ�.
	// �ִ� 4������ ��쿡 ���� �ּ� ���� �� + 1�� �ڽ��� ��Ƽ�� �ַ�� ���� ���� �� �ִ� ��
	// 6�� ���� ��� 1�� �� 5, 2�� ���� 3, 3���� ���� 2 �� 3���� ��쿡 ���� �ּ� ���� ���� ���� �� �ű⿡ 5, 3, 2�� ���� ���� 1�� �߰��ϸ� �ȴ�.
	
	static int n = 26;
	static int[] d = new int [30001];
	
	// ��ȭ�� ai = min(ai-1, ai/2, ai/3, ai/5) + 1
	
	public static void dp() {
		
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + 1; // d[1] = 0, d[2] = 1
			
			if (i % 2 == 0) {
				d[i] = Math.min(d[i], d[i / 2] + 1);
			}
			
			if (i % 3 == 0) {
				d[i] = Math.min(d[i], d[i / 3] + 1);
			}

			if (i % 5 == 0) {
				d[i] = Math.min(d[i], d[i / 5] + 1);
			}
		}
		
		System.out.println(d[n]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp();
	}

}
