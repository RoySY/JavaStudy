package study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class StandardSort1 {
	
	// 표준 정렬 알고리즘 사용
	// 두 개의 배열 A와 B가 있다. 두 배열은 N개의 원소로 구성되어 있으며, 배열의 원소는 모두 자연수이다.
	// 최대 K번의 바꿔치기 연산을 수행하여 배열 A의 원소의 값이 최대가 되도록 하라
	// 원소가 최대 10만개까지 입력될 수 있다. => 이 경우 촤악의 경우에도 O(NlogN)을 보장하는 표준 정렬 알고리즘을 사용해야 한다.
	// 5 3
	// 1 2 5 4 3
	// 5 5 6 6 5
	// 26

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = 0;
		int m = 0;
		
		n = scan.nextInt();
		m = scan.nextInt();
		
//		int[] a = new int[n];
		Integer[] a = new Integer[n];
		Integer[] b = new Integer[n]; // int와 Integer 차이 : int(자료형(primitive type), 산술 연산이 가능, null로 초기화 불가), Integer(래퍼 클래스(Wrapper class), Unboxing을 하지 않으면 산술 연산이 불가능하지만, null 처리 가능, null처리가 용이하므로 SQL과 연동할 경우 처리 용이, DB에서 자료형이 정수이지만 null값이 필요한 경우 VO에서 Integer 사용 가능)
		
		for(int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			b[i] = scan.nextInt();
		}
		
		Arrays.sort(a);
		
		Arrays.sort(b, Collections.reverseOrder()); // int는 산술 연산이 목적
		
		for(int i = 0; i < m; i++) {
			
			if(a[i] < b[i]) {
				int temp = a[i];
				a[i] = b[i];
				b[i] = temp;
			} else {
				break;
			}
		}
		
		long result = 0;
		
		for(int i = 0; i < n; i++) {
			result += a[i];
		}
		
		System.out.print(result);
	}
}