package pccp;

import java.util.PriorityQueue;

public class PccpTest1_4 {
	
	// PCCP ���ǰ�� 1ȸ 4�� �ü��
	
	public static long[] solution(int[][] program) {
		long[] answer = {};
		long callTime = 0; // OS ȣ�� �ð�
		int runningTime = 0; // OS ���� �ð�
		long totalRunningTime = 0; // ��ü OS ������� �� �ҿ� �ð�
		long blankTime = 0; // OS�� ���������� ���� �ð�
		
		answer = new long[11]; // ũ�� 11 ����
		
		// STEP 1. ORDER BY ȣ�� �ð�, ������ �켱���� ť �����(��ü OS ���� �켱���� ť)
		PriorityQueue<Os> osQ = new PriorityQueue<>();
		
		// STEP 2. 1�� �켱���� ť�� program �迭�� OS ���
		for (int i = 0; i < program.length; i++) {
			osQ.add(new Os(program[i][0], program[i][1], program[i][2]));
		}
		
		// STEP 3. ORDER BY ����, ȣ�� �ð��� �켱���� ť �����(ȣ�� �ð� ���� OS ���� �켱���� ť) => ȣ�� �ð��� ���� OS���� ������ ���� ������� ����ȴ�.
		PriorityQueue<WaitingOs> waitingOsQ = new PriorityQueue<>();
		
		// STEP 4. �ð� ��꿡 ���� �ӽ� Os, WaitingOs ���� ����
		Os tempOs = null;
		WaitingOs tempWaitingOs = null;
		
		// STEP 5. ���� ó�� ����� OS ������
		Os os = osQ.poll();
		
		callTime = os.getCallTime();
		runningTime = os.getRunningTime();
		
		blankTime = callTime; // 0�ʿ� �ٷ� ������� �ʴ� ��쵵 ���� �� �ֱ� ������ blankTime ������ֱ�
		
		totalRunningTime += blankTime; // �� �ҿ� �ð��� blankTime ���ϱ�
		totalRunningTime += runningTime; // �� �ҿ� �ð��� ���� �ð� ���ϱ�
		
		// STEP 6. �� ���� ť�� ��� ����� ������ �ݺ�
		while (!osQ.isEmpty() || !waitingOsQ.isEmpty()) { // �� ���� ť �� ��� �ϳ��� OS�� ����ִٸ� �ݺ�
			
			// osQ�� OS�� ����ִٸ�
			if (!osQ.isEmpty()) {
				
				// ���� ���� OS�� ���� ȣ�� �ð��� ���� OS�� �ִٸ� waitingOsQ(ȣ�� �ð��� ���� OS�鸸 ��������, �� ��� ������ ���� OS�� �켱������ ����� �� �ְ� ��ġ)�� ������
				if (totalRunningTime >= osQ.peek().getCallTime()) {
					tempOs = osQ.poll();
					waitingOsQ.offer(new WaitingOs(tempOs.getGrade(), tempOs.getCallTime(), tempOs.getRunningTime()));
					continue; // �� �ִٸ� �ݺ� ����ǵ��� ó��
				}
				
				// �� ������ �����Դٴ� ���� osQ�� OS�� ���� ������, waitingOsQ�� ���� ���ǿ� �����ϴ� OS�� ���ٴ� ���� �ǹ�
				// ���⼭ waitingOsQ�� ����ִٸ� => ��, ���� ����� osQ�� OS�� �ٷ� �̾ ������� �ʱ� ������ waitingOsQ�� ������ ���� �Ŷ��
				if (waitingOsQ.isEmpty()) {
					// blankTime�� runningTime ���
					tempOs = osQ.poll();
					
					blankTime = (tempOs.getCallTime() - totalRunningTime); // blankTime�� �ִٴ� ���� �ǹ��ϹǷ� blankTime ������ֱ�
					
					totalRunningTime += (blankTime + tempOs.getRunningTime()); // �� �ҿ� �ð��� blankTime�� ���� �ð� ���ϱ�
				}
			}
			
			// waitingOsQ�� OS�� ����ִٸ�
			if (!waitingOsQ.isEmpty()) {
				tempWaitingOs = waitingOsQ.poll();
				
				answer[tempWaitingOs.getGrade()] += (totalRunningTime - tempWaitingOs.getCallTime()); // �ش� ������ ��� �ð� ���ϱ�
				
				totalRunningTime += tempWaitingOs.getRunningTime(); // �� �ҿ� �ð��� �ش� ������ ���� �ð� ���ϱ�
			}
		}
		
		answer[0] = totalRunningTime; // answer[0]���� �� �ҿ� �ð��� �־��ش�.
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] program = {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}}; // ����, ȣ�� �ð�, ���� �ð� // 20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0 // ���� �ð�, ���� 1 ~ 10 �� ��� �ð�
//		int[][] program = {{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}}; // 19 0 0 4 3 14 0 0 0 0 0
//		int[][] program = {{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {4, 1, 10}, {5, 0, 5}, {2, 0, 8}}; // 37 0 5 7 41 32 0 0 0 0 0
		
		System.out.println(solution(program));
	}
}