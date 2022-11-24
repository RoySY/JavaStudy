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
		// 정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지 모든 시각 중 3이 하나라도 포함되는 모든 경우의 수를 구하기(완전 탐색)
		// 하루는 24 * 60 * 60 = 86400초이므로 모든 경우는 86400가지이다.
		// 이 문제는 가능한 모든 시각의 경우를 하나씩 모두 세서 풀 수 있는 문제이기 때문에 완전 탐색이면서, 구현이기도 하다.

		int n = 0;
		int cnt = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("1~12의 숫자 중 하나를 입력하세요 : ");
		
		n = scan.nextInt();
		
		if (n < 1 || n > 12) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		
		for (int i = 0; i <= n; i++) { // 00시부터 n시까지
			
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
