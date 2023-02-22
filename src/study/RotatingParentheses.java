package study;

import java.util.Stack;

public class RotatingParentheses {
	
	// level-2 괄호 회전하기
	
	public static boolean isCorrect(String s) {
		
		Stack<Character> st = new Stack<>();
		
      for(char c : s.toCharArray()) {
    	
    	if(!st.isEmpty() && ("[]".equals(st.peek().toString() + c) || "()".equals(st.peek().toString() + c) || "{}".equals(st.peek().toString() + c))) {
    		st.pop();
    	} else {
    		st.push(c);
    	}
    }
		
     	if(st.isEmpty()) { // 짝이 다 맞아서 비워졌다면
    		return true;
    	} else { // 짝이 다 맞지 않아서 남았다면
    		return false;
    	}
	}
	
	public static int solution(String s) {
        int answer = -1;
        int cnt = 0;
        
//        if(isCorrect(s)) { // 최초의 문자열 여기서 체크
//        	cnt++;
//        }
//        
//        for(int i = 1; i < s.length(); i++) {
//        	StringBuilder sb = new StringBuilder(s); // "[](){}"
//        	String moveStr = s.substring(0, i); // "["
//        	sb.delete(0, i);
//        	sb.append(moveStr);
//        	
//        	if(isCorrect(sb.toString())) {
//            	cnt++;
//            }
//        }
        
        for(int i = 0; i < s.length(); i++) { // i를 0부터 체크하면 이동 전 최초의 문자열도 확인 가능
        	StringBuilder sb = new StringBuilder(s); // "[](){}"
        	String moveStr = s.substring(0, i); // 이상 ~ 미만 // "" // "["
        	sb.delete(0, i); // 이상 ~ 미만
        	sb.append(moveStr);
        	
        	if(isCorrect(sb.toString())) {
            	cnt++;
            }
        }
        
        answer = cnt;
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[](){}";
//		(0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return
		System.out.println(solution(s));
	}
}