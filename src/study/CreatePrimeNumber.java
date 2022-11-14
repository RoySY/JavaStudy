package study;

import java.util.HashSet;
import java.util.Iterator;

public class CreatePrimeNumber {
	
	// 소수 만들기
	
	static HashSet<Integer> hs = new HashSet<>();
	
	public static boolean isPrimeNumber(int num) {
		
		int limit = 0;
		
		if (num == 0 || num == 1) { // 0과 1은 소수가 아니다.
			return false;
		}
		
		limit = (int) Math.sqrt(num);
		
		for (int i = 2; i <= limit; i++) { // num이 80이라면 루트 80의 정수 값인 8까지만 체크하여 나누어떨어지는지 확인하면 된다.
			
			if (num % i == 0) { // 나누어떨어진다면 num은 1과 자기 자신을 제외한 약수를 가지는 것이므로 소수가 아니다.
				return false;
			}
		}
		
		return true;
	}
	
	public static void recursive(String comb, String rest) {
		
		if (!"".equals(comb)) {
			hs.add(Integer.parseInt(comb)); // HashSet은 중복을 허용하지 않는다.
		}
		
		for (int i = 0; i < rest.length(); i++) { // rest 문자열 중 한 문자를 comb에 붙이고, 그 문자를 제외한 나머지 문자열을 rest 값으로 다시 재귀함수를 호출한다.
			recursive(comb + rest.charAt(i), rest.substring(0, i) + rest.substring(i + 1));
		}
	}
	
	public static int solution(String numbers) {
		int answer = 0;
		int tempNum = 0;
		
		// STEP 1. 모든 조합의 숫자를 만든다.
		recursive("", numbers); // 재귀함수 호출("", "011")
		
		// STEP 2. 소수의 개수를 센다.
		Iterator<Integer> it = hs.iterator();
		
		while (it.hasNext()) {
			tempNum = it.next();
			
			if (isPrimeNumber(tempNum)) { // 소수이면
				answer++; // 개수 1 증가
			}
		}
		
		// STEP 3. 소수의 개수를 리턴한다.
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "011"; // 11, 101
		
		System.out.println(solution(numbers)); // 2
	}
}