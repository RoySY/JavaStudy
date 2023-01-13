package study;

import java.util.ArrayList;
import java.util.Scanner;

public class Implementation4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 풀이를 떠올리는 것은 쉽지만 소스코드로 옮기기 어려운 문제를 구현이라 한다.
		// 일반적으로 알고리즘 문제에서 2차원 공간은 행렬(Matrix)의 의미로 사용된다.
		// 대표적인 구현 문제
		// 여행가 A는 N x N 크기의 정사각형 공간 위에 서 있다. 가장 왼쪽 위 좌표는(1, 1)이다.
		// 시뮬레이션 유형, 구현 유형, 완전 탐색 유형은 서로 유사한 점이 많다.
		
		int[][] testArr = new int[100][100];
		ArrayList<String> arr = new ArrayList<String>();
		// 상, 하, 좌, 우
		int[] dx = {-1, 1, 0, 0}; // (1, 1)에서 행, 렬이므로 상으로 이동 시 행이 -1
		int[] dy = {0, 0, -1, 1}; // (1, 1)에서 행, 렬이므로 좌로 이동 시 열이 -1
		
		int n = 0;
		
		int startX = 1;
		int startY = 1;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("크기를 입력하세요 (1 <= N <= 100) : ");
		
		n = scan.nextInt();
		
		System.out.println(n + "크기 만큼의 이동 좌표를 입력하세요 (상U 하D 좌L 우R) : ");
		
		for(int i = 0; i < n; i++) {
			arr.add(scan.next());
		}
		
		System.out.println(n);
		System.out.println(arr);
		
//		for(int j = 0; j < n; j++) {
//
//			if("U".equals(arr.get(j))) {
//				
//				if(startX + dx[0] < 1) {
//					continue;
//				} else {
//					startX += dx[0];
//				}
//			} else if("D".equals(arr.get(j))) {
//				if(startX + dx[1] > n) {
//					continue;
//				} else {
//					startX += dx[1];
//				}
//			} else if("L".equals(arr.get(j))) {
//				if(startY + dy[2] < 1) {
//					continue;
//				} else {
//					startY += dy[2];
//				}
//			} else if("R".equals(arr.get(j))) {
//				if(startY + dy[3] > n) {
//					continue;
//				} else {
//					startY += dy[3];
//				}
//			}
//		}
		
		int arrIdx = 0;
		
		for(int j = 0; j < n; j++) {

			if("U".equals(arr.get(j))) {
				arrIdx = 0;
			} else if("D".equals(arr.get(j))) {
				arrIdx = 1;
			} else if("L".equals(arr.get(j))) {
				arrIdx = 2;
			} else if("R".equals(arr.get(j))) {
				arrIdx = 3;
			}
			
			if(startX + dx[arrIdx] < 1 || startX + dx[arrIdx] > n || startY + dy[arrIdx] < 1 || startY + dy[arrIdx] > n) {
				continue;
			} else {
				startX += dx[arrIdx];
				startY += dy[arrIdx];
			}
		}
		
		System.out.println("이동 후 좌표는 : (" + startX + ", " + startY + ")");
	}
}