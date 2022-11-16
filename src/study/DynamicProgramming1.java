package study;

public class DynamicProgramming1 {
	
	// DP
	// 메모리를 적절히 사용하여 수행 시간 효율성을 비약적으로 향상시키는 방법
	// 이미 계산된 결과(작은 문제)는 별도의 메모리 영역에 저장하여 다시 계산되지 않도록 한다.
	// 일반적으로 탑다운과 보텀업으로 구성된다. 1. 최적 부분 구조(작은 문제를 모아서 큰 문제 해결 가능), 2. 중복되는 부분 문제(동일한 작은 문제를 반복적으로 해결해야 할 때)
	// 위에 1, 2 조건 모두 만족하면 DP로 풀 수 있다.
	// 탑다운(재귀 함수), 보텀업(반복문)
	// 피보나치 수열을 예로 들 수 있다.
	// 점화식을 만들 수 있는지 확인 필요
	// 피보나치 수열의 점화식 : an = an-1 + an-2, a1 = 1, a2 = 1
	// optimal solution : 최적의 해
	
	public static int[] dpArr1 = new int[100];
	public static int[] dpArr2 = new int[100];
	
	public static int fiboRecursiveFun(int n) { // 1, 1, 2, 3, 5, 8, 13, 21..
		
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fiboRecursiveFun(n-1) + fiboRecursiveFun(n-2);
				   // fiboRecursiveFun(4) 													+ fiboRecursiveFun(3)
				   // fiboRecursiveFun(3) 							+ fiboRecursiveFun(2) 	+ fiboRecursiveFun(3)
				   // fiboRecursiveFun(2) + fiboRecursiveFun(1) 	+ fiboRecursiveFun(2) 	+ fiboRecursiveFun(3)
				   //        1            +         1               +          1            + fiboRecursiveFun(3)
			 	   //        1            +         1               +          1            + fiboRecursiveFun(2) + fiboRecursiveFun(1)
				   //	     1            +         1               +          1            +          1          +           1
				   // 단순 재귀함수를 이용해 풀게 되면 계산한 것을 또 계산하기 때문에 지수 시간 복잡도를 가지게 된다.
				   // fiboRecursiveFun(5)를 구하기 위해 fiboRecursiveFun(2)가 3번 호출된다. 숫자가 커지면 더 많이 호출될 것이다.
				   // 이미 구한 값은 메모리에 저장해놓고 꺼내서 쓰기만 하면 더 효율적이다.
		}
	}
	
	// 탑다운 방식(하향식)에서 사용되는 메모이제이션(DP를 구현하는 방법 중 하나) 재귀함수를 이용할 거야
	// fiboRecursiveFun에서 구한 값을 저장해놓는 방식
	public static int fiboTopDown(int n) {
		
		if (n == 1 || n == 2) {
			return 1;
		}
		
		if (dpArr1[n] != 0) {
			return dpArr1[n];
		}
		
		dpArr1[n] = fiboTopDown(n - 1) + fiboTopDown(n - 2); // dpArr1[1], dpArr1[2]에는 1이 들어갈 것
		
		return dpArr1[n];
	}
	
	// 보텀업 방식(상향식)은 아래쪽에서부터 작은 문제를 하나씩 해결해 나가면서 다음 문제들을 해결해 나가는 방식으로 반복문을 이용한다.(전형적인 형태)
	// 결과 저장용 리스트는 DP테이블이라고 한다.
	public static int bottomUp(int n) {
		
		dpArr2[1] = 1;
		dpArr2[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			dpArr2[i] = dpArr2[i - 1] + dpArr2[i - 2];
		}
		
		return dpArr2[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fiboRecursiveFun(5)); // 재귀함수를 이용한 피보나치 // 5
		System.out.println(fiboTopDown(5)); // 재귀함수를 이용한 탑다운 DP // 5
		System.out.println(bottomUp(5)); // 반복문을 이용한 보텀업 DP // 5
		
		// 분할 정복에서는 동일한 부분 문제가 반복적으로 계산되지 않는다.(퀵 정렬이 대표적)
		// 다른 알고리즘으로 풀이 방법이 떠오르지 않으면 다이나믹 프로그래밍을 고려해보자
		// 일단 재귀 함수로 비효율적인 완전 탐색 프로그램을 작성한 뒤에 (탑다운) 작은 문제에서 구한 답이 큰 문제에서 그대로 사용될 수 있으면, 메모이제이션을 활용해 코드를 개선하도록 하자
		// 일반적인 코딩 테스트 수준에서는 기본 유형의 다이나믹 프로그래밍 문제가 출제되는 경우가 많다.
	}

}
