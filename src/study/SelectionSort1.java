package study;

public class SelectionSort1 {
	
	// 선택 정렬
	// 처리되지 않은 데이터 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸는 것을 반복

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		int minIdx = 0;
		int temp = 0;
		
		// step1 : 7 기준 잡고 5 ~ 8 중 가장 작은 데이터 0 고름
		// step2 : 7과 0의 위치 변경
		// step3 : (변경된 0은 놔두고) 5 기준 잡고 9 ~ 8 중 가장 작은 데이터 1 고름
		// step4 : 5와 1의 위치 변경
		
		for(int i = 0; i < n; i++) {
			minIdx = i; // 0
			
			for(int j = i + 1; j < n; j++) { // 1 ~ 9까지 검사
				
				if(arr[minIdx] > arr[j]) { // 이렇게 하면 1 ~ 9 중 가장 작은 값의 인덱스가 minIdx에 담기게 됨
					minIdx = j;
				}
			}
			
			// i번째와 minIdx번째의 값 바꾸기
			temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
		
		for(int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
	}
}