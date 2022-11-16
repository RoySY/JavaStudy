package study;

public class DynamicProgramming3 {
	
	// DP : 1로 만들기
	// 정수 X가 주어졌을 때 다음 연산을 사용하여 1로 만들 수 있는 최소 횟수
	// X가 5로 나누어 떨어지면, 5로 나눈다.
	// X가 3으로 나누어 떨어지면, 3으로 나눈다.
	// X가 2로 나누어 떨어지면, 2로 나눈다.
	// X에서 1을 뺀다.
	// 이 문제는 최적 부분 구조가 성립한다.
	// 최대 4가지의 경우에 대한 최소 연산 수 + 1로 자신의 옵티멀 솔루션 값을 정할 수 있는 것
	// 6을 예로 들면 1을 뺀 5, 2로 나눈 3, 3으로 나눈 2 이 3가지 경우에 대해 최소 연산 수를 구한 후 거기에 5, 3, 2를 만든 연산 1을 추가하면 된다.
	
	static int n = 26;
	static int[] d = new int [30001];
	
	// 점화식 ai = min(ai-1, ai/2, ai/3, ai/5) + 1
	
	public static void dp() {
		
		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + 1; // d[1] = 0, d[2] = 1
			
			if (i % 2 == 0) {
				d[i] = Math.min(d[i], d[i / 2] + 1);
			}
			
			if (i % 3 == 0) {
				d[i] = Math.min(d[i], d[i / 3] + 1);
			}

			if (i % 5 == 0) {
				d[i] = Math.min(d[i], d[i / 5] + 1);
			}
		}
		
		System.out.println(d[n]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp();
	}

}
