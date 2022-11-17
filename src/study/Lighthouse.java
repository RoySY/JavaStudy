package study;

import java.util.HashSet;

public class Lighthouse {
	
	// ���
	
	public static int solution(int n, int[][] lighthouse) {
		int answer = 0;
		int[] linkedCntArr; // �� ��뿡 ����� ����� ���� �Է¹ޱ� ���� �迭
		
		HashSet<Integer> edgeHs = new HashSet<>(); // �����ڸ�(�ѷ��� ���� �ش�Ǵ� �κ�)�� ��ġ�� ����� ��ȣ�� ���� HashSet
		HashSet<Integer> turnOnHs = new HashSet<>(); // �����ڸ�(�ѷ��� ���� �ش�Ǵ� �κ�)�� ��ġ�� ���� �����, �ݵ�� �Ѿ� �ϴ� ����� ��ȣ�� ���� HashSet
		int[][] remainingLightHouse; // �ݵ�� �Ѿ� �ϴ� ��븦 Ų �� ���� ��� ���� ���� 2���� �迭
		int remainingCnt; // remainingLightHouse�� ��� ��� ���� ��
		
		// CASE 1�� �������� ����
		
		for (int a = 0; a < n; a++) { // ���� �ݺ�
			
			// ���� turnOnHs�� ������� ���� ��Ȳ�̶��, turnOnHs�� ��� ��ȣ�� ��븦 Ų ��Ȳ����, ���� ����� ������ �޴� ���� ����ؾ� �� ��󿡼� �����Ѵ�.(lighthouse�� ���̰� �پ��� ��)
			
			linkedCntArr = new int[n + 1]; // linkedCntArr �ʱ�ȭ // 0 ~ n
			remainingLightHouse = new int[lighthouse.length][2]; // remainingLightHouse �ʱ�ȭ
			remainingCnt = 0; // remainingCnt �ʱ�ȭ
			
			for (int i = 0; i < lighthouse.length; i++) {
				linkedCntArr[lighthouse[i][0]]++;
				linkedCntArr[lighthouse[i][1]]++;
			}
			
			// linkedCntArr : {0, 4, 2, 1, 1, 3, 3, 1, 1, 2, 2, 1, 3, 1, 1}
			
			for (int i = 0; i < linkedCntArr.length; i++) {
				
				if (linkedCntArr[i] == 1) { // ����� ��밡 �ϳ����̶�� �����ڸ�(�ѷ��� ���� �ش�Ǵ� �κ�)�� ��ġ�� ���
					edgeHs.add(i); // edgeHs�� ��� ��ȣ ���
				}
			}
			
			// edgeHs : [3, 4, 7, 8, 11, 13, 14]
			
			for (int i = 0; i < lighthouse.length; i++) {
				
				// �����ڸ�(�ѷ��� ���� �ش�Ǵ� �κ�)�� ��ġ�� ���� ����� ��� ��ȣ�� turnOnHs�� ��� // �ݵ�� �Ѿ� �ϴ� ��� ��ȣ
				
				if (edgeHs.contains(lighthouse[i][0]) || edgeHs.contains(lighthouse[i][1])) {
					
					if (edgeHs.contains(lighthouse[i][0])) {
						turnOnHs.add(lighthouse[i][1]);
					} else {
						turnOnHs.add(lighthouse[i][0]);
					}
				}
			}
			
			// turnOnHs : [1, 6, 10, 12]
			
			for (int i = 0; i < lighthouse.length; i++) {
				
				// turnOnHs�� ��� ���� ����� �������� ���� �� ���� ��� ���� �ִ��� Ȯ��
				
				if (!turnOnHs.contains(lighthouse[i][0]) && !turnOnHs.contains(lighthouse[i][1])) {
					remainingLightHouse[remainingCnt] = lighthouse[i];
					remainingCnt++;
				}
			}
			
			// remainingLightHouse : {{2, 9}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}
			// remainingCnt == 1
			
			if (remainingCnt == 0) { // ���� ���� ���� ��� ��븦 ���� �� �ִٸ�
				break;
			}
			
			if (remainingCnt == 1) { // ���� ���� ����� �������� ���� �� ���� ��� ���� 1�� �����Ѵٸ�
				answer += 1; // ���� 1���� ��� �� � ��븦 �ѵ� �Ǳ� ������ 1�� ����
				break;
			}
			
			if (remainingCnt < lighthouse.length) { // ���� ���� ����� �������� ���� �� ���� ��� ���� ���� 2 �̻� lighthouse.length �̸��̶��
				lighthouse = new int[remainingCnt][2]; // lighthouse�� ���� ���̱�
				
				for (int i = 0; i < remainingCnt; i++) { // ���� ���� ����� �������� ���� �� ���� ��� �ָ� ����ϸ� �ȴ�.
					lighthouse[i] = remainingLightHouse[i];
				}
			}
			
			// �ٽ� for������ �� ���� �ݺ�
		}
		
		answer += turnOnHs.size(); // ���� ����� ���� �����ش�.
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// CASE 1
		int n = 14;
		int[][] lighthouse = {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}, {10, 11}, {5, 12}, {12, 13}, {12, 14}};
		// CASE 2
//		int n = 10;
//		int[][] lighthouse = {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}};
		// CASE 3
//		int n = 8;
//		int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
		
		System.out.println(solution(n, lighthouse));
	}
}