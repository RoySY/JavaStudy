package pccp;

public class PccpTest1_2 {
	
	// PCCP ���ǰ�� 1ȸ 2�� ü����ȸ
	
	static int answer = 0; // �ִ밪 ���� answer ����
	static boolean[] selectStudentNumArr; // ��ǥ�� ���� �л����� Ȯ���� ���� boolean �迭
	static int studentCnt = 0; // �� �л� ��
	static int sportsCnt = 0; // �� ���� ��
	
	public static void dfs(int depth, int sum, int[][] ability) { // ���� index, �հ� ����, �л��� �ɷ�ġ�� ��� �迭
		
		if (depth == sportsCnt) { // �� ��° ���� �������� �ջ�� �Ķ��
			answer = Math.max(answer, sum); // �� ��° ���� �������� �ջ�� ��� �� �ִ밪�� answer ������ �ֱ�
		} else { // depth�� 0, 1, 2�� ���
			
			for (int i = 0; i < studentCnt; i++) { // 0 ~ 4
				
				if (selectStudentNumArr[i] == false) { // ���� ���õ��� ���� �л��̶��
					selectStudentNumArr[i] = true; // �ش� �л� ����
					dfs(depth + 1, sum + ability[i][depth], ability); // �ش� �л��� ���� �� index�� depth�� ������ ������ �հ迡 ���ϰ�, ���� ���� Ȯ���� ���� dfs
					selectStudentNumArr[i] = false; // dfs �������� ���� �ش� �л��� �ٽ� ���� �� ���·�
				}
			}
		}
	}
	
	public static int solution(int[][] ability) {
		selectStudentNumArr = new boolean[ability.length]; // {false, false, false, false, false}
		studentCnt = ability.length; // 5
		sportsCnt = ability[0].length; // 3
		
		dfs(0, 0, ability); // ���� index 0, �հ� ���� 0, �л��� �ɷ�ġ�� ��� �迭
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}}; // 5���� �л�, 3���� ����
		
		System.out.println(solution(ability)); // 40(0, 0) + 100(4, 1) + 70(3, 2) // 210
	}
}