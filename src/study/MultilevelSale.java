package study;

import java.util.HashMap;

public class MultilevelSale {
	
	// �ٴܰ� ĩ�� �Ǹ�
	// ĩ���� ���� 100��
	// 10%�� ��õ�ο��� �ָ�, �� �������� �����Ѵ�. �� �ݾ��� 1�� �̸��� ��� �й����� �ʰ� ���´�.
	// <����>
	// ���� ���� : ����� �迭�̳� �����迭�� ����� �� ���� ���� ���� ���� ����ȴ�.
	// int[] a = { 1, 2, 3, 4 }; int[] b = a;
	// ���� ���� : ����� �迭�̳� �����迭�� ����� �� ���� ���� ���� �ٲ��� �ʴ´�.
	// int[] a = { 1, 2, 3, 4 }; int[] b = new int[a.length]; for (int i = 0; i < a.length; i++) { b[i] = a[i]; }
	// int[] a = { 1, 2, 3, 4 }; int[] b = a.clone();
	// int[] a = { 1, 2, 3, 4 }; int[] b = Arrays.copyOf(a, a.length);
	// int[] a = { 1, 2, 3, 4 }; int[] b = Arrays.copyOfRange(a, 1, 3);
	
	static int[] answer = {};
	static String[] globalEnroll = {};
	static String[] globalReferral = {};
	static HashMap<String, Integer> hm;
	
	public static void RevenueShare(String member, int money) {
		int tempIndex = 0;
		int shareMoney = 0;
		
		if ("-".equals(member) || money == 0) {
			return;
		}
		
//		tempIndex = Arrays.asList(globalEnroll).indexOf(member); // 11, 12, 13 �׽�Ʈ���̽� �ð� �ʰ��� �������� Ȯ��
		tempIndex = hm.get(member); // member�� �ε��� ��������
		
		shareMoney = money / 10;
		
		if (shareMoney < 1) { // 1�� �̸��� ��� �й����� �ʰ� ���´�.
			answer[tempIndex] += money;
		} else {
			answer[tempIndex] += (money - shareMoney); // 90%�� �ش��ϴ� �ݾ� ���ϱ�
			RevenueShare(globalReferral[tempIndex], shareMoney); // ��õ��, 10%�� �ش��ϴ� �ݾ����� ���� �й�
		}
	}
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		answer = new int[enroll.length]; // ������ �迭�� ���� ��ġ
		globalEnroll = enroll; // enroll �迭�� ������ ����ϹǷ� ���� ����
		globalReferral = referral; // referral �迭�� ������ ����ϹǷ� ���� ����
		
		// STEP 1. �������� �ε��� Ȯ���� ���� HashMap Ȱ��
		// RevenueShare �Լ����� Arrays.asList(globalEnroll).indexOf(member)�� Ȱ���� �ε����� ������ ��� 11, 12, 13 �׽�Ʈ���̽� �ð��ʰ� �߻��Ͽ� HashMap Ȱ�� ������� ����
		hm = new HashMap<>();
		
		for (int i = 0; i < enroll.length; i++) {
			hm.put(enroll[i], i);
		}
		
		// STEP 2. �Ǹ����� ���� �й�
		for (int i = 0; i < seller.length; i++) {
			RevenueShare(seller[i], amount[i] * 100);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}; // ������
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}; // �������� ��õ��
		String[] seller = {"young", "john", "tod", "emily", "mary"}; // �Ǹ��� ������
		int[] amount = {12, 4, 2, 5, 10}; // �Ǹ��� ����
		
		System.out.println(solution(enroll, referral, seller, amount)); // 360, 958, 108, 0, 450, 18, 180, 1080
	}
}