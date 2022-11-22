package study;

import java.util.HashMap;

public class EqualsAndHashCode {
	
	// hashCode�� ����ϴ� ���� �߿� �ϳ���, ��ü�� ���� �� ��� ����� ���߱� ���ؼ�
	// �ڹٿ��� 2���� ��ü�� ������ ���� �� equals()�� ����ϴµ�, ���� ��ü�� ���� �� equals()�� ����ϸ� Integer�� ���ϴ� �Ϳ� ���� ���� �ð��� �ҿ�
	// �� ��ü�� hashCode�� �ٸ��� �� ��ü�� ���� �ʴ�. ����, ��ü�� ���� �� ���� hashCode�� ���ϸ�, ���� ���� �� ���� ��츦 ���� �������� Ȯ���� �� �ִ�.
	// hashCode�� �ٸ���, �ΰ��� ��ü�� ���� �ʴ�.
	// hashCode�� ������, �ΰ��� ��ü�� ���ų� �ٸ� �� �ִ�.
	// HashMap�� ���� �ٸ� ��ü�� ���� hashCode�� ���ؼ��� ������ �� ó�����ֵ��� �����Ǿ� �ִ�.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "Z@S.ME";
		String str2 = "Z@RN.E";
		
		HashMap<String, Integer> hm1 = new HashMap<>();
		
		hm1.put(str1, 30);
		hm1.put(str2, 40);
		System.out.println(str1.equals(str2)); // false
		System.out.println(str1.hashCode()); // -1656719047
		System.out.println(str2.hashCode()); // -1656719047
		System.out.println(hm1.size()); // 2
		System.out.println(hm1.get(str1)); // 30
		System.out.println(hm1.get(str2)); // 40
		
		Sample sample1 = new Sample("abcd");
		Sample sample2 = new Sample(new String("abcd"));
		
		HashMap<Sample, Integer> hm2 = new HashMap<>();
		
		hm2.put(sample1, 10);
		hm2.put(sample2, 20);
		System.out.println(sample1.equals(sample2)); // equals�� ������ true // hashCode�� ������ false // equals�� hashCode ��� ������ true
		System.out.println(sample1.hashCode()); // equals�� ������ 474675244 // hashCode�� ������ 2987074 // equals�� hashCode ��� ������ 2987074
		System.out.println(sample2.hashCode()); // equals�� ������ 932583850 // hashCode�� ������ 2987074 // equals�� hashCode ��� ������ 2987074
		System.out.println(hm2.size()); // equals�� ������ 2 // hashCode�� ������ 2 // equals�� hashCode ��� ������ 1
		System.out.println(hm2.get(sample1)); // equals�� ������ 10 // hashCode�� ������ 10 // equals�� hashCode ��� ������ 20
		System.out.println(hm2.get(sample2)); // equals�� ������ 20 // hashCode�� ������ 20 // equals�� hashCode ��� ������ 20
	}
}