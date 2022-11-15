package study;

public class Greedy1 {
	
	// 그리디 : 거스름돈 문제
	// 금액 n과 거스름돈 단위 배열 arr이 주어질 때 최소한의 동전 갯수로 거스름돈을 주려고 한다.
	
	public static void solution(int n, int[] arr) {
		int cnt = 0;
		int val = 0;
		
		for (int i = 0; i < arr.length; i++) {
			cnt += n / arr[i];
			n = n % arr[i];
			
			if (n == 0) {
				System.out.println(cnt + "개의 동전만으로 거스름돈 가능");
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1260;
		int[] arr = {500, 100, 50, 10}; // 큰 단위가 작은 단위의 배수이므로 큰 단위부터 나눠도 최적의 해 보장(정당성 분석)
		
		solution(n, arr);
	}

}
