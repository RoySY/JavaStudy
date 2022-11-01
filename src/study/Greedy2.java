package study;

import java.util.Scanner;

public class Greedy2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		int k = 0;
		int target = 0;
		int cnt = 0;
		
		Scanner scan = new Scanner(System.in);
		
		num = scan.nextInt(); // 두 수를 입력받고 나누기 또는 빼기 1로 1을 만드는 횟수
		k = scan.nextInt();
		
		while (true) {
			
			if (num >= k) {
				
				if ((num % k) == 0) {
					num = (num / k);
					cnt++;
				} else {
					num = num - 1;
					cnt++;
				}
			} else {
				
				if (num == 1) break;
				
				num = num - 1;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
