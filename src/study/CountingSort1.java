package study;

public class CountingSort1 {
	
	// 계수 정렬
	// 공간 복잡도가 높지만 조건만 만족하면(데이터의 크기가 한정되어 있는 경우) 빠르다. 시간 복잡도와 공간 복잡도 모두 O(N+K)
	// 계수 정렬은 동일한 값을 가지는 데이터가 여러 개 등장할 때 효과적으로 사용할 수 있다.
	// 성적의 경우 100점을 맞은 학생이 여러 명일 수 있기 때문에 계수 정렬이 효과적
	
	static final int MAX_VALUE = 9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 15;
		
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2}; // 0 ~ 9까지의 숫자만 존재 => 0 ~ 9 인덱스 배열 생성 => 각 숫자 체크하여 해당 인덱스 값 1씩 증가
		
		int[] cnt = new int[MAX_VALUE + 1]; // int형이므로 0으로 초기화
		
		for(int i = 0; i < n; i++) {
			cnt[arr[i]] += 1;
		}
		
		for(int i = 0; i <= MAX_VALUE; i++) {
			for(int j = 0; j < cnt[i]; j++) {
				System.out.print(i + " "); // 0 0 1 1 2 2 3 4 5 5 6 7 8 9 9 
			}
		}
	}
}