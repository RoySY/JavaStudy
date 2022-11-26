package pccp;

public class PccpTest1_2 {
	
	// PCCP 모의고사 1회 2번 체육대회
	
	static int answer = 0; // 최대값 담을 answer 변수
	static boolean[] selectStudentNumArr; // 대표로 뽑힌 학생인지 확인을 위한 boolean 배열
	static int studentCnt = 0; // 총 학생 수
	static int sportsCnt = 0; // 총 종목 수
	
	public static void dfs(int depth, int sum, int[][] ability) { // 종목 index, 합계 점수, 학생별 능력치가 담긴 배열
		
		if (depth == sportsCnt) { // 세 번째 종목 점수까지 합산된 후라면
			answer = Math.max(answer, sum); // 세 번째 종목 점수까지 합산된 결과 중 최대값을 answer 변수에 넣기
		} else { // depth가 0, 1, 2인 경우
			
			for (int i = 0; i < studentCnt; i++) { // 0 ~ 4
				
				if (selectStudentNumArr[i] == false) { // 아직 선택되지 않은 학생이라면
					selectStudentNumArr[i] = true; // 해당 학생 선택
					dfs(depth + 1, sum + ability[i][depth], ability); // 해당 학생의 종목 중 index가 depth인 종목의 점수를 합계에 더하고, 다음 종목 확인을 위해 dfs
					selectStudentNumArr[i] = false; // dfs 빠져나온 이후 해당 학생은 다시 선택 전 상태로
				}
			}
		}
	}
	
	public static int solution(int[][] ability) {
		selectStudentNumArr = new boolean[ability.length]; // {false, false, false, false, false}
		studentCnt = ability.length; // 5
		sportsCnt = ability[0].length; // 3
		
		dfs(0, 0, ability); // 종목 index 0, 합계 점수 0, 학생별 능력치가 담긴 배열
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}}; // 5명의 학생, 3개의 종목
		
		System.out.println(solution(ability)); // 40(0, 0) + 100(4, 1) + 70(3, 2) // 210
	}
}