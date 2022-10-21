package study;

import java.util.LinkedList;
import java.util.Queue;

public class CorrectParenthesis {
	
	// 올바른 괄호
	
	static boolean solution(String s) {
		boolean answer = true;
		char tempChar;
        
		Queue<Character> q = new LinkedList<>();
        
		for (int i = 0; i < s.length(); i++) {
			
			tempChar = s.charAt(i);
			
			if (tempChar == '(') { // '('라면
				
				q.offer(tempChar); // 큐에 넣기
				
			} else { // ')'라면
        		
				if (q.isEmpty()) { // 이 시점에 큐가 비어있는 상태라면 짝이 맞지 않는 것이므로 answer = false 후 break
					answer = false;
					break;
				}
        		
				q.poll(); // 큐에 있는 '(' 괄호 꺼내기
			}
		}
        
		if (!q.isEmpty()) { // 짝이 맞았다면 '(' 괄호가 모두 제거되었어야 한다. 큐가 비어있는 상태가 아니라는 것은 짝이 맞지 않았다는 뜻이므로 answer = false
			answer = false;
		}
        
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(())()";
		
		System.out.println(solution(s));
	}

}
