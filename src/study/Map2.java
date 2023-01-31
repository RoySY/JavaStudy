package study;

import java.util.HashMap;
import java.util.Scanner;

public class Map2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap hm = new HashMap();
		
		hm.put("sylee", "1006");
		hm.put("test", "1234");
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("id와 pw를 입력해주세요.");
			System.out.println("id : ");
			String strId = scan.nextLine().trim(); // "  1234  " => "1234"로 인식(문자열 앞 뒤의 공백 제거, 문자열 중간에 있는 공백은 제거하지 못함)
			// 문자열 중간에 있는 공백을 제거하려면 replace()를 사용해야 함
//			String strId = scan.nextLine().replace(" ", ""); // " By default " => "Bydefault"
//			String strId = scan.nextLine().replaceAll(" ", ""); // " By default " => "Bydefault"
//			String strId = scan.nextLine().replaceFirst(" ", ""); // " By default " => "By default "
			System.out.println("대문자 값은 : " + strId.toUpperCase());
			System.out.println("소문자 값은 : " + strId.toLowerCase());
			System.out.println("pw : ");
			String strPw = scan.nextLine().trim();
			System.out.println();
			
			if(!hm.containsKey(strId)) {
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요");
				continue;
			}
			
			if(!hm.get(strId).equals(strPw)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
			} else {
				System.out.println("id와 pw가 일치합니다.");
				break;
			}
		}
	}
}