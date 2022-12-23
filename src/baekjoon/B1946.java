package baekjoon;

import java.util.*;

public class B1946 {

	// 신입 사원 - Greedy 1946번
	
	static int n = 7;
	static int[][] arr = {{3, 6}, {7, 3}, {4, 2}, {1, 4}, {5, 7}, {2, 5}, {6, 1}};
	static int cnt = 0;
	static int secondRank = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		for (int i = 0; i < arr.length; i++) {
			
			if (i == 0) { // 앞 성적 1등은 무조건 PASS
				cnt++;
				continue;
			}
			
			secondRank = arr[i][1];
			
			for (int j = 0; j < i; j++) {
				
				if (secondRank > arr[j][1]) { // 2 // 4 5 6 비교
					break; // 이 for문 더이상 돌 필요 없음
				} else {
					
					if (j == i - 1) {
						cnt++; // 바로 직전까지 검사했음에도 들어와서 탄거면 cnt++
					}
					
					continue; // 바로 직전 값까지 계속 검사
				}
			}
		}
		
		System.out.println(cnt); // 3
	}
}