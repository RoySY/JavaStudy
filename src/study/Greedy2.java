package study;

public class Greedy2 {
	
	// �׸��� : 1�� �� ������
	// ��� �� N�� 1�� �� ������ ���� �� ���� �� �ϳ��� �ݺ������� �����Ͽ� �����Ϸ��� �Ѵ�.
	// N���� 1�� ����. N�� K�� ������.(N�� K�� �������� ��쿡��)
	// N�� K�� �־��� �� 1�� �� ������ ������ �����ؾ� �ϴ� �ּ� Ƚ����?
	
	public static void solution(int n, int k) {
		int cnt = 0;
		
		while (n > 1) {
			if (n % k == 0 && k != 1) {
				n = n / k;
				cnt++;
			} else {
				n = n - 1;
				cnt++;
			}
			
			if (n == 1) {
				System.out.println(cnt + "Ƚ���� 1�� ���� �� �ִ�.");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 37;
		int K = 2; //36, 18, 9, 8, 4, 2, 1
		
		solution(N,K);
	}

}
