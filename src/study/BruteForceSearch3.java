package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BruteForceSearch3 {
	
	// ���� ������ ����
	// ���� 99, 100, 1000
	// ���ڴ� 0 ~ 9 (�� ���ڷ� �� �� ������)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strVal = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�빮�ڿ� ���ڸ� ��� �Է��ϼ��� (���̴� 1 <= S <= 10000) : ");
		
		strVal = scan.next(); // �빮�ڿ� ���� ����
		
		ArrayList<Character> strArr = new ArrayList<>(); // �ڡڡڡڡڡڡڡڡڡ�
		int resultNum = 0;
		
//		System.out.println((strVal.charAt(0) - 'A') + 1);
		
		for (int i = 0; i < strVal.length(); i++) {
			
//			if ((strVal.charAt(i) - 'A') + 1 > 0 && (strVal.charAt(i) - 'A') + 1 < 27) { // �� ��� �빮�ھ�
//				strArr.add(strVal.charAt(i));
//			}
			
			if (Character.isLetter(strVal.charAt(i))) { // �빮�ڰ� �ƴ� ���ĺ��� �� ���� // �ڡڡڡڡڡڡڡڡڡ�
				strArr.add(strVal.charAt(i));
			} else {
				resultNum += strVal.charAt(i) - '0';
			}
		}
		
		Collections.sort(strArr);
		
		for (int j = 0; j < strArr.size(); j++) {
			System.out.print(strArr.get(j));
		}
		
		if (resultNum != 0) {
			System.out.print(resultNum);
		}
	}
}