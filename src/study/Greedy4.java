package study;
import java.util.Scanner;

public class Greedy4 {
	
	// [그리디 알고리즘]
	// 문제2. 인하은행에는 ATM이 1대밖에 없다. 지금 이 ATM앞에 N명의 사람들이 줄을 서있다.
	// 사람은 1번부터 N번까지 번호가 매겨져 있으며, i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분이다.
	// 사람들이 줄을 서는 순서에 따라서, 돈을 인출하는데 필요한 시간의 합이 달라지게 된다.
	// 예를 들어, 총 5명이 있고, P1 = 3, P2 = 1, P3 = 4, P4 = 3, P5 = 2 인 경우를 생각해보자.
	// [1, 2, 3, 4, 5] 순서로 줄을 선다면, 1번 사람은 3분만에 돈을 뽑을 수 있다.
	// 2번 사람은 1번 사람이 돈을 뽑을 때 까지 기다려야 하기 때문에, 3+1 = 4분이 걸리게 된다.
	// 3번 사람은 1번, 2번 사람이 돈을 뽑을 때까지 기다려야 하기 때문에, 총 3+1+4 = 8분이 필요하게 된다.
	// 4번 사람은 3+1+4+3 = 11분, 5번 사람은 3+1+4+3+2 = 13분이 걸리게 된다.
	// 이 경우에 각 사람이 돈을 인출하는데 필요한 시간의 합은 3+4+8+11+13 = 39분이 된다.
	// 줄을 [2, 5, 1, 4, 3] 순서로 줄을 서면, 2번 사람은 1분만에, 5번 사람은 1+2 = 3분, 1번 사람은 1+2+3 = 6분,
	// 4번 사람은 1+2+3+3 = 9분, 3번 사람은 1+2+3+3+4 = 13분이 걸리게 된다. 각 사람이 돈을 인출하는데 필요한 시간의 합은 1+3+6+9+13 = 32분이다.
	// 이 방법보다 더 필요한 시간의 합을 최소로 만들 수는 없다.
	// 줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어졌을 때,
	// 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램을 작성하시오.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cnt = 0;
		String totalMinutes = "";
		
		Scanner scan = new Scanner(System.in);
		Scanner minScan = new Scanner(System.in);
		
		System.out.print("돈을 인출하기 위해 기다리는 사람 수 : ");
		
		cnt = scan.nextInt();
		
		System.out.print("각 사람이 돈을 인출하는데 걸리는 시간 (띄어쓰기로 값 구분 ex)2 6 9 : ");
		
		totalMinutes = minScan.nextLine(); // 빈 문자열 포함 개행 전까지 입력받는다.
//		totalMinutes = scan.next(); // next는 빈 문자열 전까지만 입력받는다.
//		totalMinutes = "power over whelming"; // totalMinutes.split("\\s+"); // 공백 split 정상
		
		String[] array = totalMinutes.split(" "); // 정상
		int[] tempArray = new int[cnt];
		int[] resultArray = new int[cnt];
		int tempNum = 0;
		int minIdx = 0;
		int totalSum = 0;
		
		for (int i = 0; i < cnt; i++) { // 시간을 사람 수보다 더 입력했어도 사람 수만큼만 체크
			tempArray[i] = Integer.parseInt((array[i])); // tempArray에 현재 시간 들어있음
		}
		
		for (int k = 0; k < tempArray.length; k++) { // 배열의 모든 값 한 번씩 나올 거야
			tempNum = tempArray[k];
			minIdx = k;
			
			for (int j = k; j < tempArray.length; j++) {
				
				if (tempNum > tempArray[j]) {
					minIdx = j;
					tempNum = tempArray[minIdx];
				}
			}
			
			tempArray[minIdx] = tempArray[k];
			tempArray[k] = tempNum;
		}
		
//		for (int i = 0; i < tempArray.length; i++) { // 정렬 올바르게 되었는지 확인
//			System.out.println(tempArray[i]);
//		}
		
		for (int z = 0; z < tempArray.length; z++) {
			
			resultArray[z] = tempArray[z];
					
			for (int k = 0; k < z; k++) {
				resultArray[z] += tempArray[k];
			}
		}
		
		for (int x = 0; x < resultArray.length; x++) {
			totalSum += resultArray[x];
		}
		
		System.out.println("총 합계 시간 : " + totalSum);
	}
}
