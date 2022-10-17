package pccp;

public class PccpTest1_2 {
	
	// PCCP ���ǰ�� 1ȸ 2�� ü����ȸ
	
	public static int[][] studentAbility;
	public static int studentCnt = 0;
	public static int sportsCnt = 0;
	public static int[] exceptCmbMax;
	
	public static int getMaxAbility(int studentCmbNum, int sportsIndex) { // studentCmbNum : ���õ� �л� �Ǵ� �л����� ����, sportsIndex : ���� // sportsIndex�� 0�� �� 1���� �л� ����, sportsIndex�� 1�� �� 2���� �л� ����, sportsIndex�� 2�� �� 3���� �л� ���� ����
		int maxScore = 0;
		int score = 0;
		int checkNum = 0;
		
		if (sportsIndex == sportsCnt) { // sportsIndex 0 ~ 2������ üũ�ϵ��� ��
			return 0;
		}
		
		if (exceptCmbMax[studentCmbNum] == 0) { // exceptCmbMax[studentCmbNum] ���� 0�� ��쿡�� üũ�ϵ��� ��
			
			for (int i = 0; i < studentCnt; i++) { // 0 ~ 4
				
				checkNum = (1 << i); // 1, 2, 4, 8, 16
				
				if ((studentCmbNum & checkNum) > 0) { // �ռ� ���õ� �л��̶�� continue
					continue;
				}
				
				score = studentAbility[i][sportsIndex] + getMaxAbility((studentCmbNum | checkNum), sportsIndex + 1); // �ݺ����� ���� ���õ��� ���� �л����� ���� ���� ������ Ȯ��(������ 0, 1, 2 ������ ���� => �л��� ���� ���ø� ���)
				
				if (score > maxScore) {
					maxScore = score;
				}
				
				exceptCmbMax[studentCmbNum] = maxScore; // ���� : {210, 170, 170, 100, 170, 100, 100, 0, 130, 100, 100, 0, 100, 0, 0, 0, 100, 70, 70, 0, 70, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0}
			}
		}
		
		return exceptCmbMax[studentCmbNum];
	}
	
	public static int solution(int[][] ability) {
		int answer = 0;
		studentCnt = ability.length; // �л� �� // 5
		sportsCnt = ability[0].length; // ���� �� // 3
		exceptCmbMax = new int[1 << studentCnt]; // 2 ^ 5 ũ���� �迭 ����
		studentAbility = ability;
		
		answer = getMaxAbility(0, 0);
		// exceptCmbMax[0] : ��ü���� ���� ��� �� �ִ��� ��(studentAbility[0][0] + exceptCmbMax[1] OR studentAbility[1][0] + exceptCmbMax[2] OR studentAbility[2][0] + exceptCmbMax[4] OR studentAbility[3][0] + exceptCmbMax[8] OR studentAbility[4][0] + exceptCmbMax[16])
		// exceptCmbMax[1] : (0, 0) �� �� ������ ���� ��� �� �ִ��� ��(studentAbility[1][1] + exceptCmbMax[3] OR studentAbility[2][1] + exceptCmbMax[5] OR studentAbility[3][1] + exceptCmbMax[9] OR studentAbility[4][1] + exceptCmbMax[17])
		// exceptCmbMax[2] : (1, 0) �� �� ������ ���� ��� �� �ִ��� ��
		// exceptCmbMax[3] : (0, 0), (1, 1) �� �� ������ ���� ��� �� �ִ��� ��(studentAbility[2][2] OR studentAbility[3][2] OR studentAbility[4][2])
		// exceptCmbMax[4] : (2, 0) �� �� ������ ���� ��� �� �ִ��� ��(studentAbility[0][1] + exceptCmbMax[5] OR studentAbility[1][1] + exceptCmbMax[6] OR studentAbility[3][1] + exceptCmbMax[12] OR studentAbility[4][1] + exceptCmbMax[20])
		// exceptCmbMax[N] : N�� ���õ� �л� �Ǵ� �л����� ����, exceptCmbMax[N]�� �� ������ �������� �� �ִ밡 �Ǵ� �� // ������ 0, 1, 2 ������ �����߱� ������ �л��� ���� ���ø� ���
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
		
		System.out.println(solution(ability)); // 40(0, 0) + 100(4, 1) + 70(3, 2) // 210
	}
}
