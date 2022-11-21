package study;

import java.util.Arrays;

public class Greedy6 {
	
	// 그리디 : 모험가 길드
	// 한 마을에 모험가가 n명 있다.
	// 각 모험가의 공포도 2,3,1,2,2일 때
	// 공포도가 x인 모험가는 반드시 x명 이상으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있다.
	// 인력을 남겨도 된다.
	
	public static void solution(int n, int[] arr) {
		
		int cnt = 0;
		int result = 0;
		
		Arrays.sort(arr); // 오름차순 정렬 // 1, 2, 2, 2, 3
		
		for (int i = 0; i < arr.length; i++) {
			cnt++;
			
			if (cnt >= arr[i]) {
				result++;
				cnt = 0;
			}
		}
		
		System.out.println(result); // (1), (2,2) 2개의 묶음으로 여행을 떠날 수 있음
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] arr = {2,3,1,2,2};
		
		solution(n, arr);
	}
}