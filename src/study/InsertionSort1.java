package study;

public class InsertionSort1 {
	
	// 삽입 정렬
	// 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입
	// 선택 정렬에 비해 구현 난이도가 높은 편이지만, 일반적으로 더 효율적으로 동작

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		int temp = 0;
		
		// step1 : 첫 번재 데이터인 7은 그 자체로 정렬 되어있다고 판단하고, 두 번째 데이터인 5부터 기준으로 잡는다.
		// step2 : 좌측 데이터인 7보다 작으므로 5와 7의 위치를 변경해준다.
		// step3 : 세 번째 데이터인 9를 기준으로 잡고 좌측 7, 5와 비교를 할 것이다.
		// step4 : 7보다 크므로 break
		// step5 : 네 번째 데이터인 0을 기준으로 잡고 좌측 9, 7, 5와 비교를 할 것이다.
		// step6 : 9와 위치 변경, 7과 위치 변경, 5와 위치 변경하여 0, 5, 7, 9가 된다.
		
		for(int i = 1; i < n; i++) {
			
			for(int j = i; j > 0; j--) {
				
				if(arr[j] < arr[j-1]) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				} else {
					break;
				}
			}
		}
		
		for(int k = 0; k < n; k++) {
			System.out.print(arr[k] + " ");
		}
	}
}