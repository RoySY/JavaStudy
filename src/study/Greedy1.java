package study;

public class Greedy1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1260;
		
		int cnt = 0;
		
		int[] coinTypes = {500, 100, 50, 10}; // �Ž����� ���� // �� ��� ū ������ �׻� ���� ������ ����̱� ������ ū �������� �Ž����൵ ������ �ذ� �����
		
		for (int i = 0; i < 4; i++) {
			cnt += n / coinTypes[i];
			n %= coinTypes[i];
		}
		
		System.out.println(cnt);
		
		System.out.println("A".charAt(0));
		System.out.println((int)"A".charAt(0));
		System.out.println((byte)"A".charAt(0));
		System.out.println('A');
		System.out.println((int)'A');
		System.out.println((byte)'A');
	}

}
