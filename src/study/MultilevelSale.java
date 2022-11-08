package study;

import java.util.HashMap;

public class MultilevelSale {
	
	// 다단계 칫솔 판매
	// 칫솔의 가격 100원
	// 10%를 추천인에게 주며, 원 단위에서 절사한다. 그 금액이 1원 미만인 경우 분배하지 않고 갖는다.
	// <참고>
	// 얕은 복사 : 복사된 배열이나 원본배열이 변경될 때 서로 간의 값이 같이 변경된다.
	// int[] a = { 1, 2, 3, 4 }; int[] b = a;
	// 깊은 복사 : 복사된 배열이나 원본배열이 변경될 때 서로 간의 값은 바뀌지 않는다.
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
		
//		tempIndex = Arrays.asList(globalEnroll).indexOf(member); // 11, 12, 13 테스트케이스 시간 초과의 원인으로 확인
		tempIndex = hm.get(member); // member의 인덱스 가져오기
		
		shareMoney = money / 10;
		
		if (shareMoney < 1) { // 1원 미만인 경우 분배하지 않고 갖는다.
			answer[tempIndex] += money;
		} else {
			answer[tempIndex] += (money - shareMoney); // 90%에 해당하는 금액 더하기
			RevenueShare(globalReferral[tempIndex], shareMoney); // 추천인, 10%에 해당하는 금액으로 수익 분배
		}
	}
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		answer = new int[enroll.length]; // 구성원 배열과 순서 일치
		globalEnroll = enroll; // enroll 배열은 참고에만 사용하므로 얕은 복사
		globalReferral = referral; // referral 배열은 참고에만 사용하므로 얕은 복사
		
		// STEP 1. 구성원의 인덱스 확인을 위해 HashMap 활용
		// RevenueShare 함수에서 Arrays.asList(globalEnroll).indexOf(member)를 활용해 인덱스를 가져온 결과 11, 12, 13 테스트케이스 시간초과 발생하여 HashMap 활용 방법으로 변경
		hm = new HashMap<>();
		
		for (int i = 0; i < enroll.length; i++) {
			hm.put(enroll[i], i);
		}
		
		// STEP 2. 판매자의 수익 분배
		for (int i = 0; i < seller.length; i++) {
			RevenueShare(seller[i], amount[i] * 100);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}; // 구성원
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}; // 구성원의 추천인
		String[] seller = {"young", "john", "tod", "emily", "mary"}; // 판매한 구성원
		int[] amount = {12, 4, 2, 5, 10}; // 판매한 개수
		
		System.out.println(solution(enroll, referral, seller, amount)); // 360, 958, 108, 0, 450, 18, 180, 1080
	}
}