package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class KakaoLevel4_1 {
	
	// ��İ� ����
	// Deque �ڷᱸ������
	// add(A) + peek(B) or remove(B)�� ���� �� // (A)�� (B)�� First �Ǵ� Last
	// (A)�� (B)�� ���ٸ� ����(Stack)ó�� ����
	// (A)�� (B)�� �ٸ��ٸ� ť(Queue)ó�� ����
	// addFirst�� �װ� �ִ� �������� ���� �տ� ���Ҹ� �߰��ϰ� �ʹٸ� addLast�� �߰�
	// addLast�� �װ� �ִ� �������� ���� �տ� ���Ҹ� �߰��ϰ� �ʹٸ� addFirst�� �߰�
	
	static int r = 0; // rc�� �� ��
	static int c = 0; // rc�� �� ��
	static Deque<Integer> firstCol; // rc�� 1��
	static Deque<Integer> lastCol; // rc�� ��������
	static Deque<Deque<Integer>> restRows; // rc�� 1��, ���������� ������ ������ ���
	
	// 2���� �迭�� 2���� ���� ������ �� ������ ������
	public static void rcSetting(int[][] rc) {
		r = rc.length; // ��
		c = rc[0].length; // ��
		firstCol = new ArrayDeque<Integer>(); // 1��
		lastCol = new ArrayDeque<Integer>(); // ��������
		restRows = new ArrayDeque<Deque<Integer>>(); // ������ ��
		
//		1 2 3
//		4 5 6
//		7 8 9
		
//		2���� �迭�� ���� ���ٸ�
//		r = 3, c = 3
//		firstCol = {1, 4, 7}
//		lastCol = {3, 6, 9}
//		restRows = {2, 5, 8}
		
		// ���, �������� addFirst�� ���� �ž�
		// ��� addFirst�� �ִ´ٴ� ���� ���
		for (int i = 0; i < r; i++) {
			firstCol.addFirst(rc[i][0]); // 1�� ���
			lastCol.addFirst(rc[i][c - 1]); // �������� ���
			
			 Deque<Integer> tempRow = new ArrayDeque<Integer>(); // restRows�� ���� tempRow ����
			 
			 for (int j = 1; j < c - 1; j++) { // 1���� ���������� ������ ��� ���� ���� ���
				 tempRow.addFirst(rc[i][j]);
			 }
			 
			 restRows.addFirst(tempRow); // tempRow ���
		}
	}
	
	// �׵θ� �� ĭ�� �ð���� ȸ��
	public static void rotate() {
		
		if (c == 2) { // firstCol, lastCol������ �̷���� 2���� �迭
			lastCol.addLast(firstCol.removeLast());
			// firstCol�� ���� ó���� ���Դ� ���Ұ� ���������� �� => addFirst���� Queue ������ ������������ removeLast�� ������ �Ѵ�.
			// ���� ���� lastCol�� addFirst�� ���� ó�� ���Դ� ���Һ��� �տ� �־�� �ϹǷ� addLast�� �־��ش�.
			
			firstCol.addFirst(lastCol.removeFirst());
			// lastCol�� ���� �������� ���Դ� ���Ұ� ���������� �� => addFirst���� Stack ������ ������������ removeFirst�� ������ �Ѵ�.
			// ���� ���� firstCol�� addFirst�� ���� �������� ���Դ� ������ �ڿ� �־�� �ϹǷ� �Ȱ��� addFirst�� �־��ش�.
			
			return;
		}
		
		// �׵θ��� ���� �߰��� ������ ��, ��, ��, �� ������ �ϰڴ�.
		restRows.peekLast().addLast(firstCol.removeLast()); // 1��(firstCol)�� ó�� ���� ���Ҹ� ����(addFirst���� Queue ������ ���� ���� removeLast) => restRows�� ó�� ���� ���� �������� ��ƾ� ��(Queue ������ ���� ���� peekLast) => ���� ���� �� ó���� ���Դ� ���Һ��� �տ� �־���� �ϹǷ� addLast
		lastCol.addLast(restRows.peekLast().removeFirst()); // restRows�� ó�� ���� �� �� ������ ���Ҹ� ������ ������ �� ���� �տ� �������ؼ� �߰�
		restRows.peekFirst().addFirst(lastCol.removeFirst()); // ������ ���� ���� �������� ���� ���Ҹ� ������ restRows�� ���� �������� ���� �� �� ���� �������� ���� ���� �ڿ� �߰�
		firstCol.addFirst(restRows.peekFirst().removeLast()); // restRows�� ���� �������� ���� �� �� ó�� ���� ���Ҹ� ������ 1�� ���� �������� ���� ���� �ڿ� �߰�
	}
	
	// �� �� ĭ�� �Ʒ��� �̵�
	public static void shiftRow() {
		// ���� �������� ���� �� �Ǵ� ���Ҹ� ���� ó�� ��ġ�� �־���� �Ѵ�. addFirst �߰� �����̹Ƿ� ���� ������ ������ ���� removeFirst, ���� �տ� �߰������ �ϹǷ� addLast�� ���ش�.
		restRows.addLast(restRows.removeFirst()); // ��
		firstCol.addLast(firstCol.removeFirst()); // 1��
		lastCol.addLast(lastCol.removeFirst()); // ��������
	}
	
	public static int[][] solution(int[][] rc, String[] operations) {
		int[][] answer = {};
        
		// STEP 1. 2���� �迭 rc => 2���� ���� ������ �� ������ ������
		rcSetting(rc);
        
		// STEP 2. ���� �۾�
		for (String operation : operations) { // "Rotate", "ShiftRow"
        	
			switch (operation.charAt(0)) { // 'R', 'S'
				case 'R' : rotate(); break;
				case 'S' : shiftRow(); break;
			}
		}
        
		// STEP 3. 2���� �迭 answer�� �� ���
		answer = new int[r][c];
        
		for (int i = 0; i < r; i++) {
			// addFirst �߰� �������� ť ������ ������ ���� removeLast ���
			answer[i][0] = firstCol.removeLast(); // 1��
			answer[i][c - 1] = lastCol.removeLast(); // ��������
        	
			Deque<Integer> tempRow = new ArrayDeque<Integer>(); // restRows�� �� ���� ��� ���� tempRow ����
        	
			// addFirst �߰� �������� ť ������ ������ ���� removeLast ���
			tempRow = restRows.removeLast();
        	
			for (int j = 1; j < c - 1; j++) {
				answer[i][j] = tempRow.removeLast();
			}
		}
        
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rc = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		String[] operations = {"Rotate", "ShiftRow"}; // Rotate : ��� �ٱ��ʿ� �ִ� ���Ҹ� �ð� �������� ȸ��, ShiftRow : ���� �� ĭ�� �Ʒ��� �̵�
		
//		    Rotate  ShiftRow
//		1 2 3    4 1 2    8 9 6
//		4 5 6    7 5 3    4 1 2
//		7 8 9    8 9 6    7 5 9
		
		System.out.println(solution(rc, operations)); // {{8, 9, 6}, {4, 1, 2}, {7, 5, 3}}
	}

}
