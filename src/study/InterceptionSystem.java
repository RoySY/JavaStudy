package study;

import java.util.Arrays;

public class InterceptionSystem {
	
	// ��� �ý���
	
	public static int solution(int[][] targets) {
		int answer = 0;
		
		// ������ (s, e)�� ǥ���Ǵ� ���� �̻����� s�� e���� �߻��ϴ� ��� �̻��Ϸδ� ����� �� ���� ������ ������ ���ҿ� 10�� ���� ��
		// ù ��° ���ҿ����� +1��, �� ��° ���ҿ����� -1�� �Ͽ� �󱸰� [r, f]�� ���� �� [Java] ���α׷��ӽ� [Level-3] �ܼ�ī�޶� ����ó�� Ǯ���� �Ѵ�.
		int[][] tempTargets = new int[targets.length][targets[0].length];
		
		for (int i = 0; i < targets.length; i++) {
			tempTargets[i][0] = targets[i][0] * 10 + 1;
			tempTargets[i][1] = targets[i][1] * 10 - 1;
		}
		
		// int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
		// int[][] tempTargets = {{41, 49}, {41, 79}, {101, 139}, {111, 129}, {51, 119}, {31, 69}, {11, 39}};
		
		// ������ �迭 tempTargets ����
		Arrays.sort(tempTargets, (o1, o2) -> {
			if (o1[1] == o2[1]) { // �� ���Ұ� ���� ���
				return o1[0] - o2[0]; // �� ���� ���� ��������
			} else { // �� ���Ұ� ���� ���� ���
				return o1[1] - o2[1]; // �� ���� ���� ��������
			}
		});
		
		// int[][] tempTargets = {{11, 39}, {41, 49}, {31, 69}, {41, 79}, {51, 119}, {111, 129}, {101, 139}};
		
		int missilePoint = tempTargets[0][0] - 1; // 10 // ���� �� ù ��° ù ���Һ��� ���� ���� �ֱ� ���� -1 => ���� ������ �Ʒ� if���� �ɸ��� ��
		
		for (int i = 0; i < tempTargets.length; i++) {
			
			if (missilePoint < tempTargets[i][0]) {
				missilePoint = tempTargets[i][1];
				System.out.println(missilePoint + "�� ��ġ�� �̻��� ��ġ");
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
		
		System.out.println(solution(targets)); // 3
	}
}