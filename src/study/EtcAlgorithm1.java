package study;

import java.util.Arrays;

public class EtcAlgorithm1 {
	
	// 소수(Prime Number) : 동빈나
	
	// x가 소수인지 체크
	public static boolean isPrimeNumber1(int x) { // 시간 복잡도 O(N)
		
		for (int i = 2; i < x; i++) { // 2부터 자기 자신 숫자전까지 체크
			
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// 약수의 성질 : 모든 약수가 가운데 약수를 기준으로 곱셈 연산에 대해 대칭을 이룬다는 것을 이용하면 시간 복잡도를 줄일 수 있다.
	// 제곱근까지만 확인하면 된다는 것이다.
	
	// x가 소수인지 체크(더 효율적)
	public static boolean isPrimeNumber2(int x) { // 시간 복잡도 O(제곱근N)
		
		for (int i = 2; i <= Math.sqrt(x); i++) { // 2부터 제곱근 수 이하까지 체크
			
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// 다수의 소수 판별
	// 에라토스테네스의 체 알고리즘 사용
	// 2부터 N까지의 모든 자연르르르 나열
	// 남은 수 중에서 아직 처리하지 않은 가장 작은 수 i를 찾는다.
	// 남은 수 중에서 i의 배수를 모두 제거한다. (i는 제거하지 않은다.)
	// 더 이상 반복할 수 없을 때까지 2번과 3번의 과정을 반복한다.
	
	// 26까지의 숫자 중 소수의 개수는?
	// 2를 제외한 2의 배수를 제거
	// 3을 제외한 3의 배수를 제거
	// 5를 제외한 5의 배수를 제거
	// 제곱근 26은 5와 6 사이이므로 5.xxxx (이 이하까지만 체크하면 된다.)
	// 제외되지 않은 수들은 모두 소수
	
	// x까지의 양의 정수 중 소수 나열하기
	public static void primeNumbers(int x) { // 26
		boolean[] arr = new boolean[x + 1]; // 26까지 체크해야 하므로 배열의 크기 +1
		
		Arrays.fill(arr, true); // 일단 모든 수를 소수라고 체크
		
		arr[0] = false; // 0은 소수가 아님
		arr[1] = false; // 1은 소수가 아님
		
		for (int i = 2; i <= Math.sqrt(x); i++) {
			
			// x까지의 2의 배수부터 지우자
			if (arr[i] == true) {
				
				int j = 2;
				
				while (i * j <= x) {
					arr[i * j] = false;
					j++;
				}
			}
		}
		
		for (int i = 2; i <= x; i++) {
			
			if (arr[i] == true) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPrimeNumber1(6));
		System.out.println(isPrimeNumber2(7));
		primeNumbers(26);
	}

}
