package study;

public class Gcd {
	
	// ��Ŭ���� ȣ������ �̿��� �ִ����� ���ϱ�
	// �� �ڿ��� A, B�� ���Ͽ�(A > B) A�� B�� ���� �������� R�̶�� �� ��
	// A�� B�� �ִ������� B�� R�� �ִ������� ����.
	// �̰��� ����Լ��� �ۼ� �����ϴ�.
	
	public static void gcd(int a, int b) {
		int x = 0;
		int y = 0;
		int z = 0;
		
		if(a >= b) {
			x = a;
			y = b;
		} else {
			x = b;
			y = a;
		}
		
		if(y == 0) {
			System.out.println(x);
			return;
		}
		
		z = x % y; // 30
		
		gcd(y, z);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 192	162
		// 162	30 (192�� 162�� ���� ������)
		// 30	12 (162�� 30���� ���� ������)
		// 12	6 (30�� 12�� ���� ������)
		// 6	0 (12�� 6���� ���� ������)
		// �ִ������� 6
		gcd(192, 162);
	}
}