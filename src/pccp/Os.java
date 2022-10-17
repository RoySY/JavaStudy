package pccp;

public class Os implements Comparable<Os> { // ȣ�� �ð�, ���� ����
	
	private int grade = 0; // ����
	private long callTime = 0; // ȣ�� �ð�
	private int runningTime = 0; // ���� �ð�
	
	public Os(int grade, long callTime, int runningTime) {
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
	public int compareTo(Os otherNode) { // ORDER BY callTime, grade
		// TODO Auto-generated method stub
		if (this.callTime == otherNode.callTime) { // callTime�� ���� ���
			
			if (this.grade - otherNode.grade >= 0) { // grade ���� �������� ����
				return 1;
			} else {
				return -1;
			}
		} else { // callTime�� ���� ���� ���
			
			if (this.callTime - otherNode.callTime >= 0) { // callTime ���� �������� ����
				return 1;
			} else {
				return -1;
			}
		}
	}
}