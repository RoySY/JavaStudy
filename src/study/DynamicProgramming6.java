package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DynamicProgramming6 {
	
	// DP : 병사 배치하기
	// N명의 병사가 무작위로 나열되어 있다. 각 병사는 특정한 값의 전투력을 보유
	// 병사를 배치할 대 전투력이 높은 병사를 앞쪽에 오도록 내림차순 배치를 한다.
	// 병사를 열외시키는 방법도 있다. 그러면서도 병사의 수는 최대로 하려고 한다.
	// 열외시켜야 하는 병사의 수는?
	
//	static int n = 7; // 1 <= n <= 2000
//	static int[] arr = {15, 11, 4, 8, 5, 2, 4}; // 전투력은 10000000 이하의 자연수
	
	// 가장 긴 증가하는 부분 수열(LIS)을 변형하여 푸는 문제
	// 이 문제의 LIS는 {4, 5, 8, 11, 15}
	
	static int n = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] d = new int[2000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			list.add(scan.nextInt());
		}
		
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i));
//		}
		
		Collections.reverse(list); // 가장 긴 증가하는 부분 수열 문제처럼 풀기 위해 뒤집기 4, 2, 5, 8, 4, 11, 15
		
		for (int i = 0; i < n; i++) {
			d[i] = 1;
		}
		
		for (int i = 0; i < n; i++) { // 기준 값
			
			for (int j = 0; j < i; j++) { // 기준 값 전의 값이 더 작다면 그 값의 dp값 + 1 적용해주기
				
				if (list.get(i) > list.get(j)) {
					d[i] = Math.max(d[i], d[j] + 1);
				}
			}
		}
		
		int maxValue = 0;
		
		for (int i = 0; i < n; i++) {
			maxValue = Math.max(maxValue, d[i]);
		}
		
		System.out.println(n - maxValue);
	}
}
