package study;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsIceCream {
	
	// ��������� �� �ڵ�� ���̽�ũ�� ��Ḧ ���� �� �ִ� ĭ 0�� ������ ī��Ʈ�� �����ϰ�,
	// �װ��� �����¿�, �� �����¿��� �� �����¿���� ���� 1�� ������༭ 0���κ��� ���̽�ũ���� ������ �� �ִ� ��� ���� 1�� �ٲ��ִ� �ڵ��̴�.
	// �� 0�� �ִٸ� 1�� ����� ī��Ʈ ���� & �ű⼭���� ���̽�ũ���� ������� �� �ִ� ��� ���� 1�� ����
	// ���̻� 1�� �ٲ� ���� ���ٸ� ���� ĭ���� �ٽ� 0���� üũ
	
	static int n = 0;
	static int m = 0;
	static String str = "";
	static int[][] arr = new int[1000][1000];
	public static int[] moveRow = {-1, 1, 0, 0};
	public static int[] moveCol = {0, 0, -1, 1};
	
	public static boolean bfs(int a, int b) {
		
		Queue<Point> q = new LinkedList<>();
		
		if (arr[a][b] == 0) { // ���̽�ũ�� ��Ḧ ���� �� �ִ� ĭ�̶��
			
			q.offer(new Point(a,b));
			
			arr[a][b] = 1; // ���̽�ũ�� ��� �ױ�
			
			while (!q.isEmpty()) {
				
				Point p = q.poll();
				
				int row = p.x;
				int col = p.y;
				
				for (int z = 0; z < 4; z++) { // ���̽�ũ�� ��Ḧ ���� ĭ�� ��, ��, ��, �� Ȯ���ϸ� ��Ḧ ���� �� �ִٸ� ���� ����� ���̽�ũ�� ��� Ű���
					int nextRow = row + moveRow[z];
					int nextCol = col + moveCol[z];
					
					// 4ȸ �ݺ����� ���� nextRow, nextCol�� ���̽�ũ�� ��Ḧ ���� ĭ�� ��, ��, ��, �� ��ǥ�� �� ��
					
					if (nextRow < 0 || nextRow > n - 1 || nextCol < 0 || nextCol > m - 1) { // ������ ����ٸ� continue
						continue;
					}
					
					if (arr[nextRow][nextCol] == 0) { // nextRow, nextCol�� ��Ḧ ���� �� �ִ� ĭ�̶��
						q.offer(new Point(nextRow,nextCol)); // nextRow, nextCol ���� ��, ��, ��, �� ��ǥ ���� ���� �� �� �ִ� ĭ���� Ȯ���� ���� ť�� ���
						
						arr[nextRow][nextCol] = 1; // ��� �ױ�
					}
				}
			}
			
			return true; // ���̽�ũ�� ��Ḧ ���� �� �ִ� ĭ�̾����Ƿ� true �����Ͽ� result �� 1 �����ǵ��� �ϱ�
		}
		
		return false; // ���̽�ũ�� ��Ḧ ���� �� ���� ĭ�̹Ƿ� false ����
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
				if (bfs(k, z)) {
					result += 1; // ��������� �� result ī��Ʈ�� �� n x m Ƚ�� �� true�� ��쿡�� �����Ѵ�.
				}
			}
		}
		
		System.out.print("���̽�ũ�� ���� : " + result);
	}
}