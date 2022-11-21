package study;

import java.util.Arrays;

public class Greedy6 {
	
	// �׸��� : ���谡 ���
	// �� ������ ���谡�� n�� �ִ�.
	// �� ���谡�� ������ 2,3,1,2,2�� ��
	// �������� x�� ���谡�� �ݵ�� x�� �̻����� ������ ���谡 �׷쿡 �����ؾ� ������ ���� �� �ִ�.
	// �η��� ���ܵ� �ȴ�.
	
	public static void solution(int n, int[] arr) {
		
		int cnt = 0;
		int result = 0;
		
		Arrays.sort(arr); // �������� ���� // 1, 2, 2, 2, 3
		
		for (int i = 0; i < arr.length; i++) {
			cnt++;
			
			if (cnt >= arr[i]) {
				result++;
				cnt = 0;
			}
		}
		
		System.out.println(result); // (1), (2,2) 2���� �������� ������ ���� �� ����
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] arr = {2,3,1,2,2};
		
		solution(n, arr);
	}
}