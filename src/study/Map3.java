package study;

import java.util.*;

public class Map3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap hm = new HashMap();
		
		hm.put("���ڹ�", new Integer(90));
		hm.put("���ڹ�", new Integer(100));
		hm.put("���ڹ�", new Integer(80));
		hm.put("���ڹ�", new Integer(90));
		
		Set set = hm.entrySet();
		// ��� �÷��� �������̽��� �����ϰ� �ִ� Ŭ�������� ���������� ���� API(�������̽�) �� Iterator // List, Set ��(�÷��� �������̽��� ����)���� ��� ����
		Iterator it = set.iterator(); // �ݺ��� // �����̳ʿ� ������ִ� ������ �ϳ��ϳ� ������ �ϳ��ϳ� ��� ó���� �� �� �ֵ��� ����
		// Iterator�� �������̽��̸�, 3���� �޼ҵ带 ������. hasNext(), next(), remove()
		
		System.out.println(set); // [���ڹ�=90, ���ڹ�=80, ���ڹ�=90, ���ڹ�=100]
		
		while(it.hasNext()) {
			// ���⼭ it�� ������ �����̳��̸� next�� �� ������ it���� �ϳ��� �������.
			System.out.println(it.next()); // ���ڹ�=90 // ���ڹ�=80 // ���ڹ�=90 // ���ڹ�=100
		}
		
		Collection values = hm.values();
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			int i = (int)it.next();
			total += i;
		}
		
		System.out.println("���� : " + total); // ���� : 360
		
		// �÷��� �����ӿ�ũ
		ArrayList<Integer> A = new ArrayList<Integer>(); // �캯�� ���ų� �� �������ؾ���
		HashSet<Integer> B = new HashSet<Integer>(); // �캯�� ���ų� �� �������ؾ���
		Collection<Integer> C = new ArrayList<Integer>(); // �캯�� ���ų� �� �������ؾ���
		Collection<Integer> D = new HashSet<Integer>(); // �캯�� ���ų� �� �������ؾ���
		
		Iterator itA = A.iterator();
		Iterator itB = B.iterator();
		Iterator itC = C.iterator();
		Iterator itD = D.iterator();
	}
}