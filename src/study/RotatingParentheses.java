package study;

import java.util.Stack;

public class RotatingParentheses {
	
	// level-2 ��ȣ ȸ���ϱ�
	
	public static boolean isCorrect(String s) {
		
		Stack<Character> st = new Stack<>();
		
      for(char c : s.toCharArray()) {
    	
    	if(!st.isEmpty() && ("[]".equals(st.peek().toString() + c) || "()".equals(st.peek().toString() + c) || "{}".equals(st.peek().toString() + c))) {
    		st.pop();
    	} else {
    		st.push(c);
    	}
    }
		
     	if(st.isEmpty()) { // ¦�� �� �¾Ƽ� ������ٸ�
    		return true;
    	} else { // ¦�� �� ���� �ʾƼ� ���Ҵٸ�
    		return false;
    	}
	}
	
	public static int solution(String s) {
        int answer = -1;
        int cnt = 0;
        
//        if(isCorrect(s)) { // ������ ���ڿ� ���⼭ üũ
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
        
        for(int i = 0; i < s.length(); i++) { // i�� 0���� üũ�ϸ� �̵� �� ������ ���ڿ��� Ȯ�� ����
        	StringBuilder sb = new StringBuilder(s); // "[](){}"
        	String moveStr = s.substring(0, i); // �̻� ~ �̸� // "" // "["
        	sb.delete(0, i); // �̻� ~ �̸�
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
//		(0 �� x < (s�� ����)) ĭ��ŭ ȸ�������� �� s�� �ùٸ� ��ȣ ���ڿ��� �ǰ� �ϴ� x�� ������ return
		System.out.println(solution(s));
	}
}