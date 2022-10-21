package study;

import java.util.LinkedList;
import java.util.Queue;

public class CorrectParenthesis {
	
	// �ùٸ� ��ȣ
	
	static boolean solution(String s) {
		boolean answer = true;
		char tempChar;
        
		Queue<Character> q = new LinkedList<>();
        
		for (int i = 0; i < s.length(); i++) {
			
			tempChar = s.charAt(i);
			
			if (tempChar == '(') { // '('���
				
				q.offer(tempChar); // ť�� �ֱ�
				
			} else { // ')'���
        		
				if (q.isEmpty()) { // �� ������ ť�� ����ִ� ���¶�� ¦�� ���� �ʴ� ���̹Ƿ� answer = false �� break
					answer = false;
					break;
				}
        		
				q.poll(); // ť�� �ִ� '(' ��ȣ ������
			}
		}
        
		if (!q.isEmpty()) { // ¦�� �¾Ҵٸ� '(' ��ȣ�� ��� ���ŵǾ���� �Ѵ�. ť�� ����ִ� ���°� �ƴ϶�� ���� ¦�� ���� �ʾҴٴ� ���̹Ƿ� answer = false
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
