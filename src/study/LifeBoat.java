package study;

import java.util.Arrays;

public class LifeBoat {
	
	// ����Ʈ
	
	public static int solution(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people); // 50, 50, 70, 80
		
		int maxWeightIndex = people.length - 1; // �������� ���� ��� �� ���� ���ſ� ���Ը� ���� ����� �ε���
		int minWeightIndex = 0; // �������� ���� ��� �� ���� ������ ���Ը� ���� ����� �ε���
		
		for (int i = maxWeightIndex; i >= 0; i--) { // �������� ���� ��� �� ���� ���ſ� ���Ը� ���� ������� ������� ����
			
			answer++; // ��Ʈ�� Ÿ�� ���ϴ� ���� �����Ƿ� 1 ���� // �������� ���� ��� �� ���� ���ſ� ���Ը� ���� ��� ������ ��Ʈ�� �¿��
			
			if (i == minWeightIndex) { // max �ε��� ���� �� min �ε����� ���� ���ٴ� ���� �ش� ��ġ�� ȥ�� ���� ��츦 �ǹ��ϸ� ������ ���� ��Ʈ�� �̹� ���� ������(answer����) �ٷ� break
				break;
			}
			
			if (people[i] + people[minWeightIndex] <= limit) { // ��Ʈ���� �ִ� 2����� Ż �� �ְ� �������� ���� ��� �� ���� ���ſ� ���Ը� ���� ����� ź ��Ʈ�� ���� ���� ������ ��� ���� �Բ� Ż �� �ִٸ�
				minWeightIndex++; // ���� ���� ������ ����� �Բ� ������ ������ �����ϰ� min �ε��� 1 ���� => ���� ������ ������� ������ �ѱ�
			}
			
			if (i == minWeightIndex) { // min �ε��� ���� �� max �ε����� ���� ���ٸ� ��� �ο��� ���� ������ ���� ��Ȳ�̹Ƿ� �ٷ� break
				break;
			}
			
//			if (i <= minWeightIndex) { // ���� break if�� 2���� ��� �ּ�ó�� �ϰ� �� if���� ����� ����� ����.
//				break;
//			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		
		System.out.println(solution(people, limit));
	}
}