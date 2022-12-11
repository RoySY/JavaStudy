package baekjoon;

import java.util.*;

public class B1026 {

	// 보물 - Greedy 1026번
	
	public static int minVal(int n, int[] arrA, int[] arrB) {
		
		int[] arrTempA = arrA;
		
		Integer[] tempB = Arrays.stream(arrB).boxed().toArray(Integer[]::new);
		
		Arrays.sort(tempB, Collections.reverseOrder());
		
		int[] arrTempB = Arrays.stream(tempB).mapToInt(Integer::intValue).toArray();
		
		Arrays.sort(arrTempA);
		
		int numVal = 0;
		
//		for (int i = 0; i < arrTempA.length; i++) {
//			System.out.print(arrTempA[i]);
//		}
//		
//		for (int i = 0; i < arrTempB.length; i++) {
//			System.out.print(arrTempB[i]);
//		}
		
		for (int i = 0; i < n; i++) {
			numVal += (arrTempA[i] * arrTempB[i]);
		}
		
		return numVal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		5
//		1 1 1 6 0
//		2 7 8 3 1
		// 답 18
//		int n = 5;
//		int[] arrA = {1, 1, 1, 6, 0};
//		int[] arrB = {2, 7, 8, 3, 1};
		
//		3
//		1 1 3
//		10 30 20
		// 답 80
		
		int n = 3;
		int[] arrA = {1, 1, 3};
		int[] arrB = {10, 30, 20};
		
		System.out.println(minVal(n, arrA, arrB));
	}
}