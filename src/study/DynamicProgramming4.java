package study;

import java.util.Arrays;

public class DynamicProgramming4 {
	
	// DP : 효율적인 화폐 구성
	// N가지 종류의 화폐가 있다. 개수를 최소한으로 이용해서 M원이 되도록 하라
	static int n = 3;
	static int m = 7;
	static int[] arr = {2, 3, 5};
	static int[] d = {};
	// 먼저 각 인덱스에 해당하는 값으로 무한의 값을 설정한다.
	// INF는 특정 금액을 만들 수 있는 화폐 구성이 가능하지 않다는 의미를 가진다.
	
	public static void dp() {
		d = new int[m + 1];
		
		Arrays.fill(d, 10001); // 10000이 max이므로 10001은 무한을 의미하게 됨 {10001,10001,10001,10001,10001,10001,10001}
		
		d[0] = 0;
		
		for (int i = 0; i < n; i++) { // 0, 1, 2
			
			for (int j = arr[i]; j <= m; j++) { // 2 ~ 7 // 3 ~ 7 // 5 ~ 7
				
				if (d[j - arr[i]] != 10001) { // 0, 1, 2, 3, 4, 5 // 사용한 금액이라면
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
