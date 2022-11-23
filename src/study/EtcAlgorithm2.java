package study;

public class EtcAlgorithm2 {
	
	// 투 포인터(Two Pointers)
	// 특정한 합을 가지는 부분 연속 수열 찾기
	
	public static int n = 5;
	public static int m = 5;
	public static int[] arr = {1, 2, 3, 2, 5};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0;
		int intervalSum = 0;
		int end = 0;
		
		for (int start = 0; start < n; start++) {
			
			while (intervalSum < m && end < n) {
				intervalSum += arr[end];
				end++;
			}
			
			if (intervalSum == m) {
				cnt++;
			}
			
			intervalSum -= arr[start];
		}
		
		System.out.println(cnt);
	}
}