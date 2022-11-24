package study;

import java.util.Scanner;

public class BruteForceSearch1 {
	
	public static boolean check(int h, int m, int s) {
		boolean boolVal = false;
		
		if ((h % 10) == 3 || (m / 10) == 3 || (m % 10) == 3 || (s / 10) == 3 || (s % 10) == 3) {
			boolVal = true;
		}
		
		return boolVal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� N�� �ԷµǸ� 00�� 00�� 00�ʺ��� N�� 59�� 59�ʱ��� ��� �ð� �� 3�� �ϳ��� ���ԵǴ� ��� ����� ���� ���ϱ�(���� Ž��)
		// �Ϸ�� 24 * 60 * 60 = 86400���̹Ƿ� ��� ���� 86400�����̴�.
		// �� ������ ������ ��� �ð��� ��츦 �ϳ��� ��� ���� Ǯ �� �ִ� �����̱� ������ ���� Ž���̸鼭, �����̱⵵ �ϴ�.

		int n = 0;
		int cnt = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("1~12�� ���� �� �ϳ��� �Է��ϼ��� : ");
		
		n = scan.nextInt();
		
		if (n < 1 || n > 12) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		
		for (int i = 0; i <= n; i++) { // 00�ú��� n�ñ���
			
			for (int j = 0; j <= 59; j++) {
				
				for (int k = 0; k <= 59; k++) {

					if (check(i, j, k)) {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

}
