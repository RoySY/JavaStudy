package study;

public class Greedy5 {
	
	// 그리디 : 곱하기 혹은 더하기
	// 각 자리가 0 ~ 9로만 이루어진 문자열 s가 주어질 때 왼쪽부터 오른쪽으로 숫자를 확인하며
	// 숫자 사이에 + 혹은 x 연산자를 넣어 가장 큰 수를 만드는 프로그램이다.
	// 모든 연산은 일반적인 방식과 달리 무조건 왼쪽부터 순서대로 이루어진다고 할 때 최대의 수를 구하라
	
	public static void solution(String s) {
		
		int val = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			int num = s.charAt(i) - '0';
			
			if (num <= 1 || val <= 1) {
				val += num;
			} else {
				val *= num;
			}
		}
		
		System.out.println(val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "02984";
		
		solution(s);
	}

}
