package study;

import java.util.Scanner;

public class BruteForceSearch2 {
	
	static int dx[] = {1, 1, 2, 2, -1, -1, -2, -2};
	static int dy[] = {2, -2, 1, -1, 2, -2, 1, -1};
	static int x = 0;
	static int y = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 8 x 8 좌표 평면
		// 나이트의 좌표를 입력했을 때 나이트가 이동할 수 있는 경우의 수 구하기
		
		int[][] arr = new int[8][8];
		
		String s = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이트의 최초 위치를 입력하세요 (a ~ h)(1 ~ 8) ex) a2 : ");
		
		s = scan.next();
		
		if (s.length() != 2) {
			System.out.println("잘못된 입력입니다.");
			return;
		} else {
			
//			System.out.println((s.charAt(0) - 'a') + 1);
//			System.out.println((s.charAt(1) - '0'));
			x = (s.charAt(0) - 'a') + 1; // 아스키코드값을 빼서 숫자 확인 (소문자의 경우 +1을 해줘야 값이 맞더라고) // 대문자도 마찬가지 // ★★★★★★★★★★
//			x = (s.charAt(0) - 'A') + 1; // 대문자로 입력 받았다면 // ★★★★★★★★★★
			y = (s.charAt(1) - '0'); // 아스키코드값을 빼서 숫자 확인 // ★★★★★★★★★★
			
			// b2 입력할 경우 2,2 나옴
			
			if (x < 1 || x > 8 || y < 1 || y > 8) {
				System.out.println("잘못된 입력입니다.");
				return;
			}
			
//			if ((s.charAt(0) - 'a') < 97 || (s.charAt(0) - 'a') > 122) {
//				System.out.println("잘못된 입력입니다.");
//				return;
//			}
//			
//			if ((s.charAt(1) - '0') < 48 || (s.charAt(1) - '0') > 57) {
//				System.out.println("잘못된 입력입니다.");
//				return;
//			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < 8; i++) {
			
			if ((x + dx[i]) < 1 || (x + dx[i]) > 8 || (y + dy[i]) < 1 || (y + dy[i]) > 8) {
				continue;
			} else {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}