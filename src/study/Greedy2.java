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
		
		num = scan.nextInt(); // �� ���� �Է¹ް� ������ �Ǵ� ���� 1�� 1�� ����� Ƚ��
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
