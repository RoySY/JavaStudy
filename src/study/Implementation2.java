package study;

public class Implementation2 {
	
	// 구현 : 왕실의 나이트
	// 행복 왕국의 왕실 정원은 체스판과 같은 8 x 8 좌표 평면 L자로만 이동 가능
	// 나이트의 좌표가 주어질 때 나이트가 이동할 수 있는 경우의 수 출력
	
	static int[] mRow = {2, 2, -2, -2, 1, 1, -1, -1};
	static int[] mCol = {-1, 1, -1, 1, 2, -2, 2, -2};
	
	public static void solution(String s) {
		
		int cnt = 0;
		
		int row = (int) s.charAt(1) - '0';
		int col = (int) s.charAt(0) - 'a' + 1; // 대문자일 경우 'A'로만 바꾸고 동일
		
		System.out.println(row + "," + col);
		
		for (int i = 0; i < 8; i++) {
			
			if (row + mRow[i] < 1 || row + mRow[i] > 8 || col + mCol[i] < 1 || col + mCol[i] > 8) {
				continue;
			} else {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	public static void main(String[] args) { // 여기선 아래로 향하는 게 숫자 증가야
		// TODO Auto-generated method stub
		String s = "a1";
		
		// 가로 	a b c d e f g h
		// 세로	1 2 3 4 5 6 7 8
		
		solution(s);
	}
}