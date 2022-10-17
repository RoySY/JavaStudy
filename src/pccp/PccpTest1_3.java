package pccp;

import java.util.*;

public class PccpTest1_3 {
	
	// PCCP 모의고사 1회 3번 유전법칙
	
	public static void selfPollination(String parent) { // parent를 자가 수분했을 때 다음 세대 형질 출력해보기
		char leftChar = parent.charAt(0);
		char rightChar = parent.charAt(1);
		
		Queue<Character> leftQ = new LinkedList<>();
		Queue<Character> rightQ = new LinkedList<>();
		
		rightQ.offer(leftChar);
		
		for (int i = 0; i < 3; i++) {
			leftQ.offer(leftChar);
			rightQ.offer(rightChar);
		}
		
		leftQ.offer(rightChar);
		
		for (int i = 0; i < 4; i++) {
			System.out.print(leftQ.poll().toString() + rightQ.poll().toString() + " ");
		}
	}
	
	public static String solve(int generation, long number) {
		long upperCaseLastNum = 0;
		long centerGroupLastNum = 0;
		String strRoot = "Rr";
		long tempNum = 0;
		
		if (generation == 1) {
			return strRoot;
		}
		
		upperCaseLastNum = (long) Math.pow(4, generation - 2);
		centerGroupLastNum = upperCaseLastNum + (2 * upperCaseLastNum);
		
		if (number <= upperCaseLastNum) {
			return "RR";
		} else if (upperCaseLastNum < number && number <= centerGroupLastNum) {
			tempNum = number % ((centerGroupLastNum - upperCaseLastNum) / 2) == 0 ? (centerGroupLastNum - upperCaseLastNum) / 2 : number % ((centerGroupLastNum - upperCaseLastNum) / 2);
			return solve(generation - 1, tempNum);
		} else { // centerGroupLastNum < number
			return "rr";
		}
	}
	
	public static String[] solution(int[][] queries) {
		String[] answer = {};
		int generation = 0;
		long number = 0;
		
		answer = new String[queries.length];
		
		for (int i = 0; i < queries.length; i++) {
			generation = queries[i][0];
			number = queries[i][1];
			
			answer[i] = solve(generation, number);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] queries = {{3, 1}, {2, 3}, {3, 9}}; // RR, Rr, RR
		
		selfPollination("Rr"); // RR, Rr, Rr, rr
		
		System.out.println(solution(queries));
	}
}