package algorithm;

public class KakaoLevel3_3 {
	
	// �ڹ���� ����
	// key, lock 3�̻� 20���� ũ���� 2���� �迭
	// key�� ȸ���� �̵��� ����
	
	public static int[][] rotate(int[][] arr, int degree) { // 2���� �迭 �ð� �������� ȸ��
		int n = arr.length;
		int m = arr[0].length;
		int[][] rotatedArr = {};
		
		// 90�� ȸ��
		if (degree == 90) {
			
			rotatedArr = new int[m][n];
			
			for (int i = 0; i < rotatedArr.length; i++) {
				
				for (int j = 0; j < rotatedArr[i].length; j++) {
					rotatedArr[i][j] = arr[n - 1 - j][i];
				}
			}
		}
		
		// 180�� ȸ��
		if (degree == 180) {
			
			rotatedArr = new int[n][m];
			
			for (int i = 0; i < rotatedArr.length; i++) {
				
				for (int j = 0; j < rotatedArr[i].length; j++) {
					rotatedArr[i][j] = arr[n - 1 - i][m - 1 - j];
				}
			}
		}
		
		// 270�� ȸ��
		if (degree == 270) {
			
			rotatedArr = new int[m][n];
			
			for (int i = 0; i < rotatedArr.length; i++) {
				
				for (int j = 0; j < rotatedArr[i].length; j++) {
					rotatedArr[i][j] = arr[j][m - 1 - i];
				}
			}
		}
		
		// 360�� ȸ��
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
		
		// point : üũ�� �迭 checkArr���� ���� lock�� ���� ��ġ
		// lockLength : lock�� ����
		
		for (int i = 0; i < lockLength; i++) {
			
			for (int j = 0; j < lockLength; j++) {
				
				if (checkArr[point + i][point + j] != 1) return false; // 0 : ä������ ���� ����, 2 : Ƣ��� �κг��� ���� ���� // lock ���� �Ұ�
			}
		}
		
		return true;
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
		int point = key.length - 1; // 2
		int checkArrSize = key.length * 2 + lock.length - 2; // 7
		
		// STEP 1. key ȸ��
		for (int rot = 0; rot < 4; rot++) { // 0��, 90��, 180��, 270��
			
			// STEP 2. key �̵�
			for (int i = 0; i < point + lock.length; i++) { // key�� �� �̵� ���
				
				for (int j = 0; j < point + lock.length; j++) { // key�� �� �̵� ���
					
					// STEP 3. üũ�� �迭 ���� & �ڹ����� �� ����
					int[][] checkArr = new int[checkArrSize][checkArrSize]; // key�� lock�� ������ üũ�� �迭 ����
					
					for (int r = 0; r < lock.length; r++) {
						
						for (int c = 0; c < lock.length; c++) {
							
							checkArr[point + r][point + c] = lock[r][c]; // üũ�� �迭�� lock�� �� �ֱ�
						}
					}
					
					// STEP 4. üũ�� �迭�� key�� �� �߰�
					for (int r = 0; r < key.length; r++) {
						
						for (int c = 0; c < key.length; c++) {
							
							if (rot == 0) { // ����
								checkArr[i + r][j + c] += key[r][c];
							} else if (rot == 1) { // 90�� ȸ������ ��
								checkArr[i + r][j + c] += key[c][key.length - 1 - r];
							} else if (rot == 2) { // 180�� ȸ������ ��
								checkArr[i + r][j + c] += key[key.length - 1 - r][key.length - 1 - c];
							} else { // 270�� ȸ������ ��
								checkArr[i + r][j + c] += key[key.length - 1 - c][r];
							}
						}
					}
					
					// STEP 5. checkArr�� ���� Ȯ���� ���� key�� ��ġ���� lock�� �� �� �ִ��� üũ
					if (openLock(checkArr, point, lock.length)) return true; // lock ���� �����ϸ� true ����
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		// key : 90�� ȸ�� -> ������ �� ĭ -> �Ʒ��� �� ĭ
		
		System.out.println(solution(key, lock)); // true
	}
}