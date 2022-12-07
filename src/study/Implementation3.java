package study;

import java.util.ArrayList;
import java.util.Collections;

public class Implementation3 {
	
	// 구현 : 문자열 재정렬
	// 알파벳 대문자와 숫자(0~9)로만 구성된 문자열이 입력으로 주어진다. 이때 모든 알파벳을 오름차순으로 정렬하여 이어서 출력한 뒤
	// 그 뒤에 모든 숫자를 더한 값을 이어서 출력한다. 예를 들어 K1KA5CB7이라는 값이 들어오면 ABCKK13을 출력한다.
	
	public static void solution(String s) {
		
		ArrayList<Character> engList = new ArrayList<>();
		
		int sumNum = 0;
		
//		System.out.println((int)'A'); // 65
//		System.out.println((int)'Z'); // 90
		
		for (int i = 0; i < s.length(); i++) {
			
			if ((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90) { // 영문 대문자라면
				engList.add(s.charAt(i));
			} else { // 영대문자와 숫자만 입력으로 받는데 영대문자가 아니라면, 즉, 숫자라면
				sumNum += (int) s.charAt(i) - '0';
			}
		}
		
		Collections.sort(engList); // 오름차순 정렬
		
		StringBuilder sb = new StringBuilder();
		
		for (char c : engList) {
			sb.append(c);
		}
		
		sb.append(sumNum);
		
		System.out.println(sb.toString()); // ABCKK13
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "K1KA5CB7";
		
		solution(s); // 그리디 & 구현 문제 풀이는 완료
	}
}