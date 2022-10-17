package pccp;

public class WaitingOs implements Comparable<WaitingOs> { // ����, ȣ�� �ð� ����
	
	private int grade = 0; // ����
	private long callTime = 0; // ȣ�� �ð�
	private int runningTime = 0; // ���� �ð�
	
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
		if (this.grade == otherNode.grade) { // grade�� ���� ���
			
			if (this.callTime - otherNode.callTime >= 0) { // callTime ���� �������� ����
				return 1;
			} else {
				return -1;
			}
		} else { // grade�� ���� ���� ���
			
			if (this.grade - otherNode.grade >= 0) { // grade ���� �������� ����
				return 1;
			} else {
				return -1;
			}
		}
	}
}