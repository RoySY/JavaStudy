package baekjoon;

import java.util.ArrayList;

public class B2606 {
	
	// ���̷��� - DFS 2606��
	
	static boolean[] boolArr = {};
	
	public static void dfs(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			boolArr[arr[i] - 1] = true;
		}
	}
	
	public static void solution(int n, int m, int[][] arr) {
		
		boolArr = new boolean[n + 1];
		
//		ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // list�� Ʋ ����
//		
//		list.add(0, new ArrayList<>()); // {}
//		
//		for (int i = 0; i < arr.length; i++) {
//			
//			list.add(i + 1, new ArrayList<>()); // list�� i��°�� ArrayList ����
//			
//			for (int j = 0; j < arr[i].length; j++) { // 1, 2, 2, 3
//				
//				if (i + 1 == arr[i][j]) {
//					
//				}
//			}
//		}
		
		boolArr[0] = true; // 1�� ��ǻ�� ���̷���
		
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[i].length; j++) {
				
				if (boolArr[arr[i][j] - 1] == true) { // �� �� �ϳ��� true���� ����
					dfs(arr[i]); // {1, 2}�� ������
				}
			}
		}
		
		int cnt = -1;
		
		for (int i = 0; i < boolArr.length; i++) {
//			System.out.print(boolArr[i]);
			
			if (boolArr[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt + "��");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7; // 1, 2, 3, 4, 5, 6, 7
		int m = 6; // 6��
		int[][] arr = {{1,2}, {2,3}, {1,5}, {5,2}, {5,6}, {4,7}}; // 1�κ��� ����� �������� ��(1�� ����)
		
		// 0 : {}
		// 1 : {2, 5}
		// 2 : {1, 3, 5}
		// 3 : {2}
		// 4 : {7}
		// 5 : {1, 2, 6}
		// 6 : {5}
		// 7 : {4}
		// �̰� dfs ���⿡�� �� ������
		
		solution(n, m, arr);
	}
}