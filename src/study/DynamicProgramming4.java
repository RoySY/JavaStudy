package study;

import java.util.Arrays;

public class DynamicProgramming4 {
	
	// DP : ȿ������ ȭ�� ����
	// N���� ������ ȭ�� �ִ�. ������ �ּ������� �̿��ؼ� M���� �ǵ��� �϶�
	static int n = 3;
	static int m = 7;
	static int[] arr = {2, 3, 5};
	static int[] d = {};
	// ���� �� �ε����� �ش��ϴ� ������ ������ ���� �����Ѵ�.
	// INF�� Ư�� �ݾ��� ���� �� �ִ� ȭ�� ������ �������� �ʴٴ� �ǹ̸� ������.
	
	public static void dp() {
		d = new int[m + 1];
		
		Arrays.fill(d, 10001); // 10000�� max�̹Ƿ� 10001�� ������ �ǹ��ϰ� �� {10001,10001,10001,10001,10001,10001,10001}
		
		d[0] = 0;
		
		for (int i = 0; i < n; i++) { // 0, 1, 2
			
			for (int j = arr[i]; j <= m; j++) { // 2 ~ 7 // 3 ~ 7 // 5 ~ 7
				
				if (d[j - arr[i]] != 10001) { // 0, 1, 2, 3, 4, 5 // ����� �ݾ��̶��
					d[j] = Math.min(d[j], d[j - arr[i]] + 1); // 2, 4
				}
			}
		}
		
		if (d[m] == 10001) {
			System.out.println(-1);
		} else {
			System.out.println(d[m]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp();
	}

}
