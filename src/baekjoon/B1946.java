package baekjoon;

import java.util.*;

public class B1946 {

	// ���� ��� - Greedy 1946��
	
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
			
			if (i == 0) { // �� ���� 1���� ������ PASS
				cnt++;
				continue;
			}
			
			secondRank = arr[i][1];
			
			for (int j = 0; j < i; j++) {
				
				if (secondRank > arr[j][1]) { // 2 // 4 5 6 ��
					break; // �� for�� ���̻� �� �ʿ� ����
				} else {
					
					if (j == i - 1) {
						cnt++; // �ٷ� �������� �˻��������� ���ͼ� ź�Ÿ� cnt++
					}
					
					continue; // �ٷ� ���� ������ ��� �˻�
				}
			}
		}
		
		System.out.println(cnt); // 3
	}
}