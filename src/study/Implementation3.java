package study;

import java.util.ArrayList;
import java.util.Collections;

public class Implementation3 {
	
	// ���� : ���ڿ� ������
	// ���ĺ� �빮�ڿ� ����(0~9)�θ� ������ ���ڿ��� �Է����� �־�����. �̶� ��� ���ĺ��� ������������ �����Ͽ� �̾ ����� ��
	// �� �ڿ� ��� ���ڸ� ���� ���� �̾ ����Ѵ�. ���� ��� K1KA5CB7�̶�� ���� ������ ABCKK13�� ����Ѵ�.
	
	public static void solution(String s) {
		
		ArrayList<Character> engList = new ArrayList<>();
		
		int sumNum = 0;
		
//		System.out.println((int)'A'); // 65
//		System.out.println((int)'Z'); // 90
		
		for (int i = 0; i < s.length(); i++) {
			
			if ((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90) { // ���� �빮�ڶ��
				engList.add(s.charAt(i));
			} else { // ���빮�ڿ� ���ڸ� �Է����� �޴µ� ���빮�ڰ� �ƴ϶��, ��, ���ڶ��
				sumNum += (int) s.charAt(i) - '0';
			}
		}
		
		Collections.sort(engList); // �������� ����
		
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
		
		solution(s); // �׸��� & ���� ���� Ǯ�̴� �Ϸ�
	}
}