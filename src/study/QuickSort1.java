package study;

public class QuickSort1 {
	
	// 퀵 정렬
	// 굉장히 빠른 정렬 알고리즘 중 하나
	// 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
	// 일반적인 상황에서 가장 많이 사용되는 정렬 알고리즘 중 하나
	// 병합 정렬과 더불어 대부분의 프로그래밍 언어의 정렬 라이브러리의 근간이 되는 알고리즘
	// 가장 기본적인 퀵 정렬은 첫 번째 데이터를 기준 데이터(Pivot : 중심점)로 설정
	// 다이나믹 프로그래밍과 분할 정복의 차이점은 부분 문제의 중복이다.
	// 분할 정복 문제에서는 동일한 부분 문제가 반복적으로 계산되지 않는다.
	// 분할 정복의 대표적인 예시
	// 퀵 정렬 알고리즘
	
	public static void quickSort(int[] arr, int start, int end) {
		
		if(start >= end) {
			return; // 원소가 1개인 경우 종료
		}
		
		int pivot = start; // 피벗은 첫 번째 원소로 설정
		int left = start + 1;
		int right = end;
		
		while(left <= right) { // 엇갈리는 경우까지 반복(이 때 양쪽으로 분할)
			
			while(left <= end && arr[left] <= arr[pivot]) {
				left++; // 좌측에선 pivot보다 큰 값의 인덱스 찾기
			}
			
			while(right > start && arr[right] >= arr[pivot]) {
				right--; // 우측에선 pivot보다 작은 값의 인덱스 찾기
			}
			
			if(left > right) {
				int temp = arr[pivot];
				arr[pivot] = arr[right];
				arr[right] = temp;
			} else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		
		quickSort(arr, start, right - 1);
		quickSort(arr, right + 1, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
		
		// step1 : 5를 피벗으로 설정하고 7 ~ 8의 데이터를 대상으로 한다.
		// step2 : 좌측에서 5보다 큰 값을 바로 선택, 우측에서 5보다 작은 값을 바로 선택(7과 4)
		// step3 : 7과 4의 위치 변경
		// step4 : 5, 4, 9, 0, 3, 1, 6, 2, 7, 8이 된다.
		// step5 : 좌측에서 5보다 큰 값을 바로 선택, 우측에서 5보다 작은 값을 바로 선택(9와 2)
		// step6 : 5, 4, 2, 0, 3, 1, 6, 9, 7, 8(이 과정 반복)
		// step7 : 5, 4, 2, 0, 3, 1, 6, 9, 7, 8에서 좌측에서 6을 선택, 우측에서 1을 선택하여 엇갈리는 경우가 발생하면
		// step8 : 작은 데이터인 1과 피벗 값인 5의 위치를 바꿔준다.
		// step9 : 1, 4, 2, 0, 3, 5, 6, 9, 7, 8(피벗 값인 5를 기준으로 좌측에 5보다 작은 그룹, 우측에 5보다 큰 그룹으로 나눠진다.) 분할이라고 한다.
		// step10 : 왼쪽 그룹에 대해, 오른쪽 그룹에 대해 퀵 정렬을 수행한다.(재귀적으로)
		// 평균적으로 : O(NlogN) 최악의경우 : O(N^2)
		// 대부분의 프로그래밍 언어에서 지원하는 표준 정렬 라이브리리리는 최악의 경우에도 O(NlogN)을 보장하도록 설계되어 있다.(파이썬의 경우 array.sort())
		
		quickSort(arr, 0, n-1);
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}