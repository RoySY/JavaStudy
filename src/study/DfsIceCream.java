package study;

import java.util.Scanner;

public class DfsIceCream {
	
	// ��������� �� �ڵ�� ���̽�ũ�� ��Ḧ ���� �� �ִ� ĭ 0�� ������ ī��Ʈ�� �����ϰ�,
	// �װ��� �����¿�, �� �����¿��� �� �����¿���� ���� 1�� ������༭ 0���κ��� ���̽�ũ���� ������ �� �ִ� ��� ���� 1�� �ٲ��ִ� �ڵ��̴�.
	// �� 0�� �ִٸ� 1�� ����� ī��Ʈ ���� & �ű⼭���� ���̽�ũ���� ������� �� �ִ� ��� ���� 1�� ����
	// ���̻� 1�� �ٲ� ���� ���ٸ� ���� ĭ���� �ٽ� 0���� üũ
	
	static int n = 0;
	static int m = 0;
	static int[][] arr = new int[1000][1000];
	static String str = "";
	
	public static boolean dfs(int a, int b) {
		
		if (a < 0 || a > n - 1 || b < 0 || b > m - 1) { // ���� ������� Ȯ��
			return false;
		}
		
		if (arr[a][b] == 0) { // ���̽�ũ���� ���� �� �ִ� �����̶��
			arr[a][b] = 1; // ���̽�ũ���� �ױ�
			dfs(a, b + 1); // �� ĭ�� ���� �� �ִ� �����̶�� ���̽�ũ�� �ױ����� dfs�Լ� ���� // ���⼭ �� 0�� ������ ���̽�ũ�� �װ� ��,��,��,�� üũ�Ͽ� dfs�Լ� ���� �ݺ� �� �ݺ�
			dfs(a, b - 1); // �� ĭ�� ���� �� �ִ� �����̶�� ���̽�ũ�� �ױ����� dfs�Լ� ����
			dfs(a - 1, b); // �� ĭ�� ���� �� �ִ� �����̶�� ���̽�ũ�� �ױ����� dfs�Լ� ����
			dfs(a + 1, b); // �� ĭ�� ���� �� �ִ� �����̶�� ���̽�ũ�� �ױ����� dfs�Լ� ����
			return true; // ���̽�ũ���� ������ٸ� ī��Ʈ ������ ���� true ��ȯ
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("���� �Է��ϼ��� : ");
		
		n = scan.nextInt(); // ���� �Է� �� ���͸� ġ�� // ���⿡ ����
		
//		scan.nextLine(); // ���� ����ֱ� // ���⿡ ������ �Է��� ����
		
		System.out.print("���� �Է��ϼ��� : ");
		
		m = scan.nextInt(); // ���⿡ ����
		
		scan.nextLine(); // ���� ����ֱ� // ������ �Է¹��� ���͵� ��������
		
		System.out.println(n + "�� " + m + "���� ���̽�ũ�� Ʋ���� ���̽�ũ���� ����ϴ�. �� ������ 0 ���� ������ 1�� �Է����ּ��� : ");
		
		for (int i = 0; i < n; i++) {
			System.out.print((i+1) + "��° �� �Է� : ");
			str = scan.nextLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		scan.close(); // �Է� �׸� �޵���
		
		int result = 0;
		
		for (int k = 0; k < n; k++) {
			for (int z = 0; z < m; z++) {
				if (dfs(k, z)) {
					result += 1; // ��������� �� result ī��Ʈ�� �� n x m Ƚ�� �� true�� ��쿡�� �����Ѵ�.
				}
			}
		}
		
		System.out.print("���̽�ũ�� ���� : " + result);
	}

}
