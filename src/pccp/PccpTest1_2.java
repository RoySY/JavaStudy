package pccp;

public class PccpTest1_2 {
	
	// PCCP 모의고사 1회 2번 체육대회
	
	public static int[][] studentAbility;
	public static int studentCnt = 0;
	public static int sportsCnt = 0;
	public static int[] exceptCmbMax;
	
	public static int getMaxAbility(int studentCmbNum, int sportsIndex) { // studentCmbNum : 선택된 학생 또는 학생들의 조합, sportsIndex : 종목 // sportsIndex가 0일 때 1명의 학생 조합, sportsIndex가 1일 때 2명의 학생 조합, sportsIndex가 2일 때 3명의 학생 조합 생김
		int maxScore = 0;
		int score = 0;
		int checkNum = 0;
		
		if (sportsIndex == sportsCnt) { // sportsIndex 0 ~ 2까지만 체크하도록 함
			return 0;
		}
		
		if (exceptCmbMax[studentCmbNum] == 0) { // exceptCmbMax[studentCmbNum] 값이 0일 경우에만 체크하도록 함
			
			for (int i = 0; i < studentCnt; i++) { // 0 ~ 4
				
				checkNum = (1 << i); // 1, 2, 4, 8, 16
				
				if ((studentCmbNum & checkNum) > 0) { // 앞서 선택된 학생이라면 continue
					continue;
				}
				
				score = studentAbility[i][sportsIndex] + getMaxAbility((studentCmbNum | checkNum), sportsIndex + 1); // 반복문을 돌며 선택되지 않은 학생들의 다음 종목 점수를 확인(종목은 0, 1, 2 순서로 고정 => 학생에 대한 선택만 고려)
				
				if (score > maxScore) {
					maxScore = score;
				}
				
				exceptCmbMax[studentCmbNum] = maxScore; // 최종 : {210, 170, 170, 100, 170, 100, 100, 0, 130, 100, 100, 0, 100, 0, 0, 0, 100, 70, 70, 0, 70, 0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0}
			}
		}
		
		return exceptCmbMax[studentCmbNum];
	}
	
	public static int solution(int[][] ability) {
		int answer = 0;
		studentCnt = ability.length; // 학생 수 // 5
		sportsCnt = ability[0].length; // 종목 수 // 3
		exceptCmbMax = new int[1 << studentCnt]; // 2 ^ 5 크기의 배열 생성
		studentAbility = ability;
		
		answer = getMaxAbility(0, 0);
		// exceptCmbMax[0] : 전체에서 고르는 경우 중 최대인 값(studentAbility[0][0] + exceptCmbMax[1] OR studentAbility[1][0] + exceptCmbMax[2] OR studentAbility[2][0] + exceptCmbMax[4] OR studentAbility[3][0] + exceptCmbMax[8] OR studentAbility[4][0] + exceptCmbMax[16])
		// exceptCmbMax[1] : (0, 0) 고른 후 나머지 고르는 경우 중 최대인 값(studentAbility[1][1] + exceptCmbMax[3] OR studentAbility[2][1] + exceptCmbMax[5] OR studentAbility[3][1] + exceptCmbMax[9] OR studentAbility[4][1] + exceptCmbMax[17])
		// exceptCmbMax[2] : (1, 0) 고른 후 나머지 고르는 경우 중 최대인 값
		// exceptCmbMax[3] : (0, 0), (1, 1) 고른 후 나머지 고르는 경우 중 최대인 값(studentAbility[2][2] OR studentAbility[3][2] OR studentAbility[4][2])
		// exceptCmbMax[4] : (2, 0) 고른 후 나머지 고르는 경우 중 최대인 값(studentAbility[0][1] + exceptCmbMax[5] OR studentAbility[1][1] + exceptCmbMax[6] OR studentAbility[3][1] + exceptCmbMax[12] OR studentAbility[4][1] + exceptCmbMax[20])
		// exceptCmbMax[N] : N은 선택된 학생 또는 학생들의 조합, exceptCmbMax[N]는 그 조합을 제외했을 때 최대가 되는 값 // 종목은 0, 1, 2 순서로 고정했기 때문에 학생에 대한 선택만 고려
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
		
		System.out.println(solution(ability)); // 40(0, 0) + 100(4, 1) + 70(3, 2) // 210
	}
}
