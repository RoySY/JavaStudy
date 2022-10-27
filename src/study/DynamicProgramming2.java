package study;

public class DynamicProgramming2 {
	
	// DP : 개미전사
	// 연속된 창고는 공격할 수 없다.
	// 창고가 1, 3, 1, 5일 때 가장 많은 식량을 얻을 수 있는 방법은? 
	// 8
	
	static int n = 4;
	static int[] arr = {1, 3, 1, 5};
	static int[] d = {};
	
	// 점화식 ai = max(ai-1, ai-2 + ki)
	
	public static void dp() {
		
		d = new int[n];
		
		d[0] = arr[0];
		d[1] = Math.max(arr[0], arr[1]);
		
		for (int i = 2; i < n; i++) {
			d[i] = Math.max(arr[i - 1], arr[i - 2] + arr[i]);
		}
		
		System.out.println(d[n - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp();
	}

}
