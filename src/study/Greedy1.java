package study;

public class Greedy1 {
	
	// �׸��� : �Ž����� ����
	// �ݾ� n�� �Ž����� ���� �迭 arr�� �־��� �� �ּ����� ���� ������ �Ž������� �ַ��� �Ѵ�.
	
	public static void solution(int n, int[] arr) {
		int cnt = 0;
		int val = 0;
		
		for (int i = 0; i < arr.length; i++) {
			cnt += n / arr[i];
			n = n % arr[i];
			
			if (n == 0) {
				System.out.println(cnt + "���� ���������� �Ž����� ����");
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1260;
		int[] arr = {500, 100, 50, 10}; // ū ������ ���� ������ ����̹Ƿ� ū �������� ������ ������ �� ����(���缺 �м�)
		
		solution(n, arr);
	}

}
