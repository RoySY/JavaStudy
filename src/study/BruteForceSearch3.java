package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BruteForceSearch3 {
	
	// 수와 숫자의 차이
	// 수는 99, 100, 1000
	// 숫자는 0 ~ 9 (한 글자로 된 수 데이터)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strVal = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("대문자와 숫자를 섞어서 입력하세요 (길이는 1 <= S <= 10000) : ");
		
		strVal = scan.next(); // 대문자와 숫자 조합
		
		ArrayList<Character> strArr = new ArrayList<>(); // ★★★★★★★★★★
		int resultNum = 0;
		
//		System.out.println((strVal.charAt(0) - 'A') + 1);
		
		for (int i = 0; i < strVal.length(); i++) {
			
//			if ((strVal.charAt(i) - 'A') + 1 > 0 && (strVal.charAt(i) - 'A') + 1 < 27) { // 이 경우 대문자야
//				strArr.add(strVal.charAt(i));
//			}
			
			if (Character.isLetter(strVal.charAt(i))) { // 대문자가 아닌 알파벳과 비교 가능 // ★★★★★★★★★★
				strArr.add(strVal.charAt(i));
			} else {
				resultNum += strVal.charAt(i) - '0';
			}
		}
		
		Collections.sort(strArr);
		
		for (int j = 0; j < strArr.size(); j++) {
			System.out.print(strArr.get(j));
		}
		
		if (resultNum != 0) {
			System.out.print(resultNum);
		}
	}
}