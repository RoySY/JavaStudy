package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DynamicProgramming6 {
	
	// DP : ���� ��ġ�ϱ�
	// N���� ���簡 �������� �����Ǿ� �ִ�. �� ����� Ư���� ���� �������� ����
	// ���縦 ��ġ�� �� �������� ���� ���縦 ���ʿ� ������ �������� ��ġ�� �Ѵ�.
	// ���縦 ���ܽ�Ű�� ����� �ִ�. �׷��鼭�� ������ ���� �ִ�� �Ϸ��� �Ѵ�.
	// ���ܽ��Ѿ� �ϴ� ������ ����?
	
//	static int n = 7; // 1 <= n <= 2000
//	static int[] arr = {15, 11, 4, 8, 5, 2, 4}; // �������� 10000000 ������ �ڿ���
	
	// ���� �� �����ϴ� �κ� ����(LIS)�� �����Ͽ� Ǫ�� ����
	// �� ������ LIS�� {4, 5, 8, 11, 15}
	
	static int n = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] d = new int[2000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			list.add(scan.nextInt());
		}
		
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
		
		Collections.reverse(list); // ���� �� �����ϴ� �κ� ���� ����ó�� Ǯ�� ���� ������ 4, 2, 5, 8, 4, 11, 15
		
		for (int i = 0; i < n; i++) {
			d[i] = 1;
		}
		
		for (int i = 0; i < n; i++) { // ���� ��
			
			for (int j = 0; j < i; j++) { // ���� �� ���� ���� �� �۴ٸ� �� ���� dp�� + 1 �������ֱ�
				
				if (list.get(i) > list.get(j)) {
					d[i] = Math.max(d[i], d[j] + 1);
				}
			}
		}
		
		int maxValue = 0;
		
		for (int i = 0; i < n; i++) {
			maxValue = Math.max(maxValue, d[i]);
		}
		
		System.out.println(n - maxValue);
	}
}
