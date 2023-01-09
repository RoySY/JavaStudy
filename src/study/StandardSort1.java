package study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class StandardSort1 {
	
	// ǥ�� ���� �˰��� ���
	// �� ���� �迭 A�� B�� �ִ�. �� �迭�� N���� ���ҷ� �����Ǿ� ������, �迭�� ���Ҵ� ��� �ڿ����̴�.
	// �ִ� K���� �ٲ�ġ�� ������ �����Ͽ� �迭 A�� ������ ���� �ִ밡 �ǵ��� �϶�
	// ���Ұ� �ִ� 10�������� �Էµ� �� �ִ�. => �� ��� �Ҿ��� ��쿡�� O(NlogN)�� �����ϴ� ǥ�� ���� �˰����� ����ؾ� �Ѵ�.
	// 5 3
	// 1 2 5 4 3
	// 5 5 6 6 5
	// 26

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = 0;
		int m = 0;
		
		n = scan.nextInt();
		m = scan.nextInt();
		
//		int[] a = new int[n];
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[n]; // int�� Integer ���� : int(�ڷ���(primitive type), ��� ������ ����, null�� �ʱ�ȭ �Ұ�), Integer(���� Ŭ����(Wrapper class), Unboxing�� ���� ������ ��� ������ �Ұ���������, null ó�� ����, nulló���� �����ϹǷ� SQL�� ������ ��� ó�� ����, DB���� �ڷ����� ���������� null���� �ʿ��� ��� VO���� Integer ��� ����)
		
		for(int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			b[i] = scan.nextInt();
		}
		
		Arrays.sort(a);
		
		Arrays.sort(b, Collections.reverseOrder()); // int�� ��� ������ ����
		
		for(int i = 0; i < m; i++) {
			
			if(a[i] < b[i]) {
				int temp = a[i];
				a[i] = b[i];
				b[i] = temp;
			} else {
				break;
			}
		}
		
		long result = 0;
		
		for(int i = 0; i < n; i++) {
			result += a[i];
		}
		
		System.out.print(result);
	}
}