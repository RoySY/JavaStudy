package pccp;

public class WaitingOs implements Comparable<WaitingOs> { // 점수, 호출 시각 기준
	
	private int grade = 0; // 점수
	private long callTime = 0; // 호출 시각
	private int runningTime = 0; // 수행 시간
	
	public WaitingOs(int grade, long callTime, int runningTime) {
		this.grade = grade;
		this.callTime = callTime;
		this.runningTime = runningTime;
	}
	
	public int getGrade() {
		return this.grade;
	}
	
	public long getCallTime() {
		return this.callTime;
	}
	
	public int getRunningTime() {
		return this.runningTime;
	}

	@Override
	public int compareTo(WaitingOs otherNode) { // ORDER BY grade, callTime
		// TODO Auto-generated method stub
		if (this.grade == otherNode.grade) { // grade가 같을 경우
			
			if (this.callTime - otherNode.callTime >= 0) { // callTime 기준 오름차순 정렬
				return 1;
			} else {
				return -1;
			}
		} else { // grade가 같지 않을 경우
			
			if (this.grade - otherNode.grade >= 0) { // grade 기준 오름차순 정렬
				return 1;
			} else {
				return -1;
			}
		}
	}
}