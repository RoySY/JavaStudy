package study;

public class Implementation2 {
	
	// ���� : �ս��� ����Ʈ
	// �ູ �ձ��� �ս� ������ ü���ǰ� ���� 8 x 8 ��ǥ ��� L�ڷθ� �̵� ����
	// ����Ʈ�� ��ǥ�� �־��� �� ����Ʈ�� �̵��� �� �ִ� ����� �� ���
	
	static int[] mRow = {2, 2, -2, -2, 1, 1, -1, -1};
	static int[] mCol = {-1, 1, -1, 1, 2, -2, 2, -2};
	
	public static void solution(String s) {
		
		int cnt = 0;
		
		int row = (int) s.charAt(1) - '0';
		int col = (int) s.charAt(0) - 'a' + 1; // �빮���� ��� 'A'�θ� �ٲٰ� ����
		
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

	public static void main(String[] args) { // ���⼱ �Ʒ��� ���ϴ� �� ���� ������
		// TODO Auto-generated method stub
		String s = "a1";
		
		// ���� 	a b c d e f g h
		// ����	1 2 3 4 5 6 7 8
		
		solution(s);
	}
}