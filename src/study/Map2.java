package study;

import java.util.HashMap;
import java.util.Scanner;

public class Map2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap hm = new HashMap();
		
		hm.put("sylee", "1006");
		hm.put("test", "1234");
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("id�� pw�� �Է����ּ���.");
			System.out.println("id : ");
			String strId = scan.nextLine().trim(); // "  1234  " => "1234"�� �ν�(���ڿ� �� ���� ���� ����, ���ڿ� �߰��� �ִ� ������ �������� ����)
			// ���ڿ� �߰��� �ִ� ������ �����Ϸ��� replace()�� ����ؾ� ��
//			String strId = scan.nextLine().replace(" ", ""); // " By default " => "Bydefault"
//			String strId = scan.nextLine().replaceAll(" ", ""); // " By default " => "Bydefault"
//			String strId = scan.nextLine().replaceFirst(" ", ""); // " By default " => "By default "
			System.out.println("�빮�� ���� : " + strId.toUpperCase());
			System.out.println("�ҹ��� ���� : " + strId.toLowerCase());
			System.out.println("pw : ");
			String strPw = scan.nextLine().trim();
			System.out.println();
			
			if(!hm.containsKey(strId)) {
				System.out.println("�Է��Ͻ� id�� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���");
				continue;
			}
			
			if(!hm.get(strId).equals(strPw)) {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���");
			} else {
				System.out.println("id�� pw�� ��ġ�մϴ�.");
				break;
			}
		}
	}
}