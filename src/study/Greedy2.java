package study;

public class Greedy2 {
	
	// 그리디 : 1이 될 때까지
	// 어떠한 수 N이 1이 될 때까지 다음 두 과정 중 하나를 반복적으로 선택하여 수행하려고 한다.
	// N에서 1을 뺀다. N을 K로 나눈다.(N이 K로 나누어질 경우에만)
	// N과 K가 주어질 때 1이 될 때까지 과정을 수행해야 하는 최소 횟수는?
	
	public static void solution(int n, int k) {
		int cnt = 0;
		
		while (n > 1) {
			if (n % k == 0 && k != 1) {
				n = n / k;
				cnt++;
			} else {
				n = n - 1;
				cnt++;
			}
			
			if (n == 1) {
				System.out.println(cnt + "횟수로 1을 만들 수 있다.");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 37;
		int K = 2; //36, 18, 9, 8, 4, 2, 1
		
		solution(N,K);
	}

}
