package study;

import java.util.Scanner;

public class BruteForceSearch2 {
	
	static int dx[] = {1, 1, 2, 2, -1, -1, -2, -2};
	static int dy[] = {2, -2, 1, -1, 2, -2, 1, -1};
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 8 x 8 ��ǥ ���
		// ����Ʈ�� ��ǥ�� �Է����� �� ����Ʈ�� �̵��� �� �ִ� ����� �� ���ϱ�
		
		int[][] arr = new int[8][8];
		
		String s = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("����Ʈ�� ���� ��ġ�� �Է��ϼ��� (a ~ h)(1 ~ 8) ex) a2 : ");
		
		s = scan.next();
		
		if (s.length() != 2) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		} else {
			
//			System.out.println((s.charAt(0) - 'a') + 1);
//			System.out.println((s.charAt(1) - '0'));
			x = (s.charAt(0) - 'a') + 1; // �ƽ�Ű�ڵ尪�� ���� ���� Ȯ�� (�ҹ����� ��� +1�� ����� ���� �´����) // �빮�ڵ� �������� // �ڡڡڡڡڡڡڡڡڡ�
//			x = (s.charAt(0) - 'A') + 1; // �빮�ڷ� �Է� �޾Ҵٸ� // �ڡڡڡڡڡڡڡڡڡ�
			y = (s.charAt(1) - '0'); // �ƽ�Ű�ڵ尪�� ���� ���� Ȯ�� // �ڡڡڡڡڡڡڡڡڡ�
			
			// b2 �Է��� ��� 2,2 ����
			
			if (x < 1 || x > 8 || y < 1 || y > 8) {
				System.out.println("�߸��� �Է��Դϴ�.");
				return;
			}
			
//			if ((s.charAt(0) - 'a') < 97 || (s.charAt(0) - 'a') > 122) {
//				System.out.println("�߸��� �Է��Դϴ�.");
//				return;
//			}
//			
//			if ((s.charAt(1) - '0') < 48 || (s.charAt(1) - '0') > 57) {
//				System.out.println("�߸��� �Է��Դϴ�.");
//				return;
//			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < 8; i++) {
			
			if ((x + dx[i]) < 1 || (x + dx[i]) > 8 || (y + dy[i]) < 1 || (y + dy[i]) > 8) {
				continue;
			} else {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}