package study;

import java.util.ArrayList;
import java.util.Scanner;

public class Implementation4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ǯ�̸� ���ø��� ���� ������ �ҽ��ڵ�� �ű�� ����� ������ �����̶� �Ѵ�.
		// �Ϲ������� �˰��� �������� 2���� ������ ���(Matrix)�� �ǹ̷� ���ȴ�.
		// ��ǥ���� ���� ����
		// ���డ A�� N x N ũ���� ���簢�� ���� ���� �� �ִ�. ���� ���� �� ��ǥ��(1, 1)�̴�.
		// �ùķ��̼� ����, ���� ����, ���� Ž�� ������ ���� ������ ���� ����.
		
		int[][] testArr = new int[100][100];
		ArrayList<String> arr = new ArrayList<String>();
		// ��, ��, ��, ��
		int[] dx = {-1, 1, 0, 0}; // (1, 1)���� ��, ���̹Ƿ� ������ �̵� �� ���� -1
		int[] dy = {0, 0, -1, 1}; // (1, 1)���� ��, ���̹Ƿ� �·� �̵� �� ���� -1
		
		int n = 0;
		
		int startX = 1;
		int startY = 1;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("ũ�⸦ �Է��ϼ��� (1 <= N <= 100) : ");
		
		n = scan.nextInt();
		
		System.out.println(n + "ũ�� ��ŭ�� �̵� ��ǥ�� �Է��ϼ��� (��U ��D ��L ��R) : ");
		
		for(int i = 0; i < n; i++) {
			arr.add(scan.next());
		}
		
		System.out.println(n);
		System.out.println(arr);
		
//		for(int j = 0; j < n; j++) {
//
//			if("U".equals(arr.get(j))) {
//				
//				if(startX + dx[0] < 1) {
//					continue;
//				} else {
//					startX += dx[0];
//				}
//			} else if("D".equals(arr.get(j))) {
//				if(startX + dx[1] > n) {
//					continue;
//				} else {
//					startX += dx[1];
//				}
//			} else if("L".equals(arr.get(j))) {
//				if(startY + dy[2] < 1) {
//					continue;
//				} else {
//					startY += dy[2];
//				}
//			} else if("R".equals(arr.get(j))) {
//				if(startY + dy[3] > n) {
//					continue;
//				} else {
//					startY += dy[3];
//				}
//			}
//		}
		
		int arrIdx = 0;
		
		for(int j = 0; j < n; j++) {

			if("U".equals(arr.get(j))) {
				arrIdx = 0;
			} else if("D".equals(arr.get(j))) {
				arrIdx = 1;
			} else if("L".equals(arr.get(j))) {
				arrIdx = 2;
			} else if("R".equals(arr.get(j))) {
				arrIdx = 3;
			}
			
			if(startX + dx[arrIdx] < 1 || startX + dx[arrIdx] > n || startY + dy[arrIdx] < 1 || startY + dy[arrIdx] > n) {
				continue;
			} else {
				startX += dx[arrIdx];
				startY += dy[arrIdx];
			}
		}
		
		System.out.println("�̵� �� ��ǥ�� : (" + startX + ", " + startY + ")");
	}
}