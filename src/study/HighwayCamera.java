package study;

import java.util.Arrays;
import java.util.Comparator;

public class HighwayCamera {
	
	// �ܼ�ī�޶�
	
	public static boolean intersactionCheck(int[] A, int[] B) { // �迭 A�� B�� �������� ������ Ȯ��
		int startA = A[0];
		int endA = A[1];
		int startB = B[0];
		int endB = B[1];
		int startPoint = 0;
		int endPoint = 0;
		
		startPoint = startA <= startB ? startB : startA; // ���� ������ �� �� �� ū ����
		endPoint = endA <= endB ? endA : endB; // ���� ������ �� �� �� ���� ����
		
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
				return o1[1] - o2[1]; // ���� ���� ���� �������� ����
			}
		});
		
		int cam = Integer.MIN_VALUE;
		
		for (int[] route : routes) { // ���� ���� ���� �������� ���ĵ� ����
			
			if (cam < route[0]) { // ���� ������ if���� �ɸ��� �� // ���� ������ ���� ������ ī�޶� ��ġ���� ���̶�� ��ġ�� �ʿ� ����, ���� ��ġ�� ī�޶� ���� �����ߴٸ� �ٽ� ��ġ�� ���� if��
				cam = route[1]; // ���� ���� ���� ������ �ܼӿ� ī�޶� ��ġ // ���� ������ ���� ������ ī�޶� ��ġ
				System.out.println(cam + "�� ���� �ܼӿ� ī�޶� ��ġ");
				answer++; // ī�޶� + 1
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
		
		System.out.println(solution(routes)); // 2 // -15, -5 ��ġ
	}
}