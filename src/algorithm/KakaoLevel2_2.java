package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoLevel2_2 {
	
	// �� ť �� ���� �����
	
	public static int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		int length = queue1.length;
		long queue1Sum = 0; // queue1�� �հ踸�� ����� ��
		long totalSum = 0;
		long targetSum = 0;
		
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
        
		queue1Sum = Arrays.stream(queue1).sum(); // 6
        
		totalSum = queue1Sum + Arrays.stream(queue2).sum(); // 20

		if (totalSum % 2 == 1) return -1; // �Ȱ��� ���� �� ���ٸ� -1 ����
        
		targetSum = totalSum / 2; // 10 // �ϳ��� ť�� ���� ���� ����ٸ� okay, ���� ���� �̿�
        
		for (int i = 0; i < length; i++) {
			q1.offer(queue1[i]); // 1, 2, 1, 2
			q2.offer(queue2[i]); // 1, 10, 1, 2
		}
        
		int tempNum = 0;
        
		while (queue1Sum != targetSum) {
        	
			if (queue1Sum < targetSum) {
				tempNum = q2.poll();
				q1.offer(tempNum);
				queue1Sum += tempNum;
			} else {
				tempNum = q1.poll();
				q2.offer(tempNum);
				queue1Sum -= tempNum;
			}
        	
			answer++;
        	
			// queue1, queue2�� ��� ���Ұ� �ڸ��ٲ��Ͽ� �ٽ� ������ ��ġ�� ���� ���� Ƚ�� (queue1.length + queue2.length) * 2 = 16
			// �� 16�� �ȴٴ� ���� �ٽ� ó���� ���� ���������� �ǹ��ϰ�, ���̻� �ݺ��� �ʿ䰡 ������ ���Ѵ�.
			if (answer > length * 4 - 1) return -1;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] queue1 = {1, 2, 1, 2};
		int[] queue2 = {1, 10, 1, 2};
		
		System.out.println(solution(queue1, queue2)); // 7
	}

}
