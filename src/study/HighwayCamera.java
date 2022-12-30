package study;

import java.util.Arrays;
import java.util.Comparator;

public class HighwayCamera {
	
	// 단속카메라
	
	public static boolean intersactionCheck(int[] A, int[] B) { // 배열 A와 B가 교집합을 갖는지 확인
		int startA = A[0];
		int endA = A[1];
		int startB = B[0];
		int endB = B[1];
		int startPoint = 0;
		int endPoint = 0;
		
		startPoint = startA <= startB ? startB : startA; // 진입 지점은 둘 중 더 큰 지점
		endPoint = endA <= endB ? endA : endB; // 진출 지점은 둘 중 더 작은 지점
		
		if (startPoint <= endPoint) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int solution(int[][] routes) {
		int answer = 0;
		
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1]; // 진출 지점 기준 오름차순 정렬
			}
		});
		
		int cam = Integer.MIN_VALUE;
		
		for (int[] route : routes) { // 진출 지점 기준 오름차순 정렬된 상태
			
			if (cam < route[0]) { // 최초 무조건 if문에 걸리게 됨 // 다음 차량의 진입 지점이 카메라 위치보다 전이라면 설치할 필요 없고, 만약 설치한 카메라 이후 진입했다면 다시 설치를 위해 if문
				cam = route[1]; // 가장 작은 진출 지점에 단속용 카메라 설치 // 다음 차량의 진출 지점에 카메라 설치
				System.out.println(cam + "번 지점 단속용 카메라 설치");
				answer++; // 카메라 + 1
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
		
		System.out.println(solution(routes)); // 2 // -15, -5 설치
	}
}