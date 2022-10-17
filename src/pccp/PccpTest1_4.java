package pccp;

import java.util.PriorityQueue;

public class PccpTest1_4 {
	
	// PCCP 모의고사 1회 4번 운영체제
	
	public static long[] solution(int[][] program) {
		long[] answer = {};
		long callTime = 0; // OS 호출 시각
		int runningTime = 0; // OS 수행 시간
		long totalRunningTime = 0; // 전체 OS 종료까지 총 소요 시간
		long blankTime = 0; // OS가 실행중이지 않은 시간
		
		answer = new long[11]; // 크기 11 고정
		
		// STEP 1. ORDER BY 호출 시각, 점수인 우선순위 큐 만들기(전체 OS 담을 우선순위 큐)
		PriorityQueue<Os> osQ = new PriorityQueue<>();
		
		// STEP 2. 1번 우선순위 큐에 program 배열의 OS 담기
		for (int i = 0; i < program.length; i++) {
			osQ.add(new Os(program[i][0], program[i][1], program[i][2]));
		}
		
		// STEP 3. ORDER BY 점수, 호출 시각인 우선순위 큐 만들기(호출 시각 지난 OS 담을 우선순위 큐) => 호출 시각이 지난 OS들은 점수가 낮은 순서대로 실행된다.
		PriorityQueue<WaitingOs> waitingOsQ = new PriorityQueue<>();
		
		// STEP 4. 시간 계산에 사용될 임시 Os, WaitingOs 변수 선언
		Os tempOs = null;
		WaitingOs tempWaitingOs = null;
		
		// STEP 5. 제일 처음 실행될 OS 꺼내기
		Os os = osQ.poll();
		
		callTime = os.getCallTime();
		runningTime = os.getRunningTime();
		
		blankTime = callTime; // 0초에 바로 실행되지 않는 경우도 있을 수 있기 때문에 blankTime 계산해주기
		
		totalRunningTime += blankTime; // 총 소요 시간에 blankTime 더하기
		totalRunningTime += runningTime; // 총 소요 시간에 수행 시간 더하기
		
		// STEP 6. 두 개의 큐가 모두 비워질 때까지 반복
		while (!osQ.isEmpty() || !waitingOsQ.isEmpty()) { // 두 개의 큐 중 어느 하나라도 OS가 담겨있다면 반복
			
			// osQ에 OS가 담겨있다면
			if (!osQ.isEmpty()) {
				
				// 실행 중인 OS로 인해 호출 시각이 지난 OS가 있다면 waitingOsQ(호출 시각이 지난 OS들만 모여있으며, 이 경우 점수가 낮은 OS가 우선적으로 실행될 수 있게 배치)로 보내기
				if (totalRunningTime >= osQ.peek().getCallTime()) {
					tempOs = osQ.poll();
					waitingOsQ.offer(new WaitingOs(tempOs.getGrade(), tempOs.getCallTime(), tempOs.getRunningTime()));
					continue; // 더 있다면 반복 수행되도록 처리
				}
				
				// 이 곳으로 내려왔다는 것은 osQ에 OS가 남아 있으며, waitingOsQ로 보낼 조건에 부합하는 OS가 없다는 것을 의미
				// 여기서 waitingOsQ가 비어있다면 => 즉, 다음 실행될 osQ의 OS가 바로 이어서 실행되지 않기 때문에 waitingOsQ에 보내지 못한 거라면
				if (waitingOsQ.isEmpty()) {
					// blankTime과 runningTime 계산
					tempOs = osQ.poll();
					
					blankTime = (tempOs.getCallTime() - totalRunningTime); // blankTime이 있다는 것을 의미하므로 blankTime 계산해주기
					
					totalRunningTime += (blankTime + tempOs.getRunningTime()); // 총 소요 시간에 blankTime과 수행 시간 더하기
				}
			}
			
			// waitingOsQ에 OS가 담겨있다면
			if (!waitingOsQ.isEmpty()) {
				tempWaitingOs = waitingOsQ.poll();
				
				answer[tempWaitingOs.getGrade()] += (totalRunningTime - tempWaitingOs.getCallTime()); // 해당 점수의 대기 시간 더하기
				
				totalRunningTime += tempWaitingOs.getRunningTime(); // 총 소요 시간에 해당 점수의 수행 시간 더하기
			}
		}
		
		answer[0] = totalRunningTime; // answer[0]에는 총 소요 시간을 넣어준다.
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] program = {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}}; // 점수, 호출 시각, 수행 시간 // 20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0 // 종료 시각, 점수 1 ~ 10 총 대기 시간
//		int[][] program = {{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}}; // 19 0 0 4 3 14 0 0 0 0 0
//		int[][] program = {{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {4, 1, 10}, {5, 0, 5}, {2, 0, 8}}; // 37 0 5 7 41 32 0 0 0 0 0
		
		System.out.println(solution(program));
	}
}