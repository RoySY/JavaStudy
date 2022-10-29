package algorithm;

public class KakaoLevel3_3 {
	
	// 자물쇠와 열쇠
	// key, lock 3이상 20이하 크기의 2차원 배열
	// key는 회전과 이동이 가능
	
	public static int[][] rotate(int[][] arr, int degree) { // 2차원 배열 시계 방향으로 회전
		int n = arr.length;
		int m = arr[0].length;
		int[][] rotatedArr = {};
		
		// 90도 회전
		if (degree == 90) {
			
			rotatedArr = new int[m][n];
			
			for (int i = 0; i < rotatedArr.length; i++) {
				
				for (int j = 0; j < rotatedArr[i].length; j++) {
					rotatedArr[i][j] = arr[n - 1 - j][i];
				}
			}
		}
		
		// 180도 회전
		if (degree == 180) {
			
			rotatedArr = new int[n][m];
			
			for (int i = 0; i < rotatedArr.length; i++) {
				
				for (int j = 0; j < rotatedArr[i].length; j++) {
					rotatedArr[i][j] = arr[n - 1 - i][m - 1 - j];
				}
			}
		}
		
		// 270도 회전
		if (degree == 270) {
			
			rotatedArr = new int[m][n];
			
			for (int i = 0; i < rotatedArr.length; i++) {
				
				for (int j = 0; j < rotatedArr[i].length; j++) {
					rotatedArr[i][j] = arr[j][m - 1 - i];
				}
			}
		}
		
		// 360도 회전
		if (degree == 360) {
			
			rotatedArr = new int[n][m];
			
			for (int i = 0; i < rotatedArr.length; i++) {
				
				for (int j = 0; j < rotatedArr[i].length; j++) {
					rotatedArr[i][j] = arr[i][j];
				}
			}
		}
		
		return rotatedArr;
	}
	
	public static boolean openLock(int[][] checkArr, int point, int lockLength) {
		
		// point : 체크용 배열 checkArr에서 실제 lock의 시작 위치
		// lockLength : lock의 길이
		
		for (int i = 0; i < lockLength; i++) {
			
			for (int j = 0; j < lockLength; j++) {
				
				if (checkArr[point + i][point + j] != 1) return false; // 0 : 채워지지 않은 공간, 2 : 튀어나온 부분끼리 만난 공간 // lock 해제 불가
			}
		}
		
		return true;
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
		int point = key.length - 1; // 2
		int checkArrSize = key.length * 2 + lock.length - 2; // 7
		
		// STEP 1. key 회전
		for (int rot = 0; rot < 4; rot++) { // 0도, 90도, 180도, 270도
			
			// STEP 2. key 이동
			for (int i = 0; i < point + lock.length; i++) { // key의 행 이동 경로
				
				for (int j = 0; j < point + lock.length; j++) { // key의 열 이동 경로
					
					// STEP 3. 체크용 배열 생성 & 자물쇠의 값 세팅
					int[][] checkArr = new int[checkArrSize][checkArrSize]; // key와 lock을 포함할 체크용 배열 생성
					
					for (int r = 0; r < lock.length; r++) {
						
						for (int c = 0; c < lock.length; c++) {
							
							checkArr[point + r][point + c] = lock[r][c]; // 체크용 배열에 lock의 값 넣기
						}
					}
					
					// STEP 4. 체크용 배열에 key의 값 추가
					for (int r = 0; r < key.length; r++) {
						
						for (int c = 0; c < key.length; c++) {
							
							if (rot == 0) { // 원본
								checkArr[i + r][j + c] += key[r][c];
							} else if (rot == 1) { // 90도 회전했을 때
								checkArr[i + r][j + c] += key[c][key.length - 1 - r];
							} else if (rot == 2) { // 180도 회전했을 때
								checkArr[i + r][j + c] += key[key.length - 1 - r][key.length - 1 - c];
							} else { // 270도 회전했을 때
								checkArr[i + r][j + c] += key[key.length - 1 - c][r];
							}
						}
					}
					
					// STEP 5. checkArr의 값을 확인해 현재 key의 위치에서 lock을 열 수 있는지 체크
					if (openLock(checkArr, point, lock.length)) return true; // lock 해제 가능하면 true 리턴
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		// key : 90도 회전 -> 오른쪽 한 칸 -> 아래쪽 한 칸
		
		System.out.println(solution(key, lock)); // true
	}
}