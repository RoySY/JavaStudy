package study;

import java.util.HashMap;

public class EqualsAndHashCode {
	
	// hashCode를 사용하는 이유 중에 하나는, 객체를 비교할 때 드는 비용을 낮추기 위해서
	// 자바에서 2개의 객체가 같은지 비교할 때 equals()를 사용하는데, 여러 객체를 비교할 때 equals()를 사용하면 Integer를 비교하는 것에 비해 많은 시간이 소요
	// 두 객체의 hashCode가 다르면 두 객체는 같지 않다. 따라서, 객체를 비교할 때 먼저 hashCode를 비교하면, 절대 같을 수 없는 경우를 빠른 연산으로 확인할 수 있다.
	// hashCode가 다르면, 두개의 객체가 같지 않다.
	// hashCode가 같으면, 두개의 객체가 같거나 다를 수 있다.
	// HashMap은 서로 다른 객체의 같은 hashCode에 대해서도 적절히 잘 처리해주도록 구성되어 있다.

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
		System.out.println(sample1.equals(sample2)); // equals만 재정의 true // hashCode만 재정의 false // equals와 hashCode 모두 재정의 true
		System.out.println(sample1.hashCode()); // equals만 재정의 474675244 // hashCode만 재정의 2987074 // equals와 hashCode 모두 재정의 2987074
		System.out.println(sample2.hashCode()); // equals만 재정의 932583850 // hashCode만 재정의 2987074 // equals와 hashCode 모두 재정의 2987074
		System.out.println(hm2.size()); // equals만 재정의 2 // hashCode만 재정의 2 // equals와 hashCode 모두 재정의 1
		System.out.println(hm2.get(sample1)); // equals만 재정의 10 // hashCode만 재정의 10 // equals와 hashCode 모두 재정의 20
		System.out.println(hm2.get(sample2)); // equals만 재정의 20 // hashCode만 재정의 20 // equals와 hashCode 모두 재정의 20
	}
}