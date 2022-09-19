package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class KakaoLevel4_1 {
	
	// 행렬과 연산
	// Deque 자료구조에서
	// add(A) + peek(B) or remove(B)가 있을 때 // (A)와 (B)는 First 또는 Last
	// (A)와 (B)가 같다면 스택(Stack)처럼 동작
	// (A)와 (B)가 다르다면 큐(Queue)처럼 동작
	// addFirst로 쌓고 있는 구조에서 제일 앞에 원소를 추가하고 싶다면 addLast로 추가
	// addLast로 쌓고 있는 구조에서 제일 앞에 원소를 추가하고 싶다면 addFirst로 추가
	
	static int r = 0; // rc의 행 수
	static int c = 0; // rc의 열 수
	static Deque<Integer> firstCol; // rc의 1열
	static Deque<Integer> lastCol; // rc의 마지막열
	static Deque<Deque<Integer>> restRows; // rc의 1열, 마지막열을 제외한 나머지 행들
	
	// 2차원 배열을 2개의 열과 나머지 행 구조로 나누기
	public static void rcSetting(int[][] rc) {
		r = rc.length; // 행
		c = rc[0].length; // 열
		firstCol = new ArrayDeque<Integer>(); // 1열
		lastCol = new ArrayDeque<Integer>(); // 마지막열
		restRows = new ArrayDeque<Deque<Integer>>(); // 나머지 행
		
//		1 2 3
//		4 5 6
//		7 8 9
		
//		2차원 배열이 위와 같다면
//		r = 3, c = 3
//		firstCol = {1, 4, 7}
//		lastCol = {3, 6, 9}
//		restRows = {2, 5, 8}
		
		// 상단, 좌측부터 addFirst로 넣을 거야
		// 모두 addFirst로 넣는다는 것을 기억
		for (int i = 0; i < r; i++) {
			firstCol.addFirst(rc[i][0]); // 1열 담기
			lastCol.addFirst(rc[i][c - 1]); // 마지막열 담기
			
			 Deque<Integer> tempRow = new ArrayDeque<Integer>(); // restRows에 담을 tempRow 생성
			 
			 for (int j = 1; j < c - 1; j++) { // 1열과 마지막열을 제외한 모든 열의 원소 담기
				 tempRow.addFirst(rc[i][j]);
			 }
			 
			 restRows.addFirst(tempRow); // tempRow 담기
		}
	}
	
	// 테두리 한 칸씩 시계방향 회전
	public static void rotate() {
		
		if (c == 2) { // firstCol, lastCol만으로 이루어진 2차원 배열
			lastCol.addLast(firstCol.removeLast());
			// firstCol의 제일 처음에 들어왔던 원소가 빠져나가야 함 => addFirst에서 Queue 구조로 빠져나가려면 removeLast로 빼내야 한다.
			// 빼낸 값을 lastCol의 addFirst로 제일 처음 들어왔던 원소보다 앞에 넣어야 하므로 addLast로 넣어준다.
			
			firstCol.addFirst(lastCol.removeFirst());
			// lastCol의 제일 마지막에 들어왔던 원소가 빠져나가야 함 => addFirst에서 Stack 구조로 빠져나가려면 removeFirst로 빼내야 한다.
			// 빼낸 값을 firstCol의 addFirst로 가장 마지막에 들어왔던 원소의 뒤에 넣어야 하므로 똑같이 addFirst로 넣어준다.
			
			return;
		}
		
		// 테두리에 원소 추가할 순서는 상, 우, 하, 좌 순서로 하겠다.
		restRows.peekLast().addLast(firstCol.removeLast()); // 1열(firstCol)의 처음 들어온 원소를 빼냄(addFirst에서 Queue 구조로 쓰기 위해 removeLast) => restRows의 처음 들어온 행을 기준으로 잡아야 함(Queue 구조로 쓰기 위해 peekLast) => 행의 원소 중 처음에 들어왔던 원소보다 앞에 넣어줘야 하므로 addLast
		lastCol.addLast(restRows.peekLast().removeFirst()); // restRows의 처음 들어온 행 중 마지막 원소를 빼내어 마지막 열 제일 앞에 끼어들기해서 추가
		restRows.peekFirst().addFirst(lastCol.removeFirst()); // 마지막 열의 제일 마지막에 들어온 원소를 빼내어 restRows의 가장 마지막에 들어온 행 중 가장 마지막에 들어온 원소 뒤에 추가
		firstCol.addFirst(restRows.peekFirst().removeLast()); // restRows의 가장 마지막에 들어온 행 중 처음 들어온 원소를 빼내어 1열 제일 마지막에 들어온 원소 뒤에 추가
	}
	
	// 행 한 칸씩 아래로 이동
	public static void shiftRow() {
		// 가장 마지막에 들어온 행 또는 원소를 가장 처음 위치에 넣어줘야 한다. addFirst 추가 구조이므로 스택 구조로 빼내기 위해 removeFirst, 제일 앞에 추가해줘야 하므로 addLast를 써준다.
		restRows.addLast(restRows.removeFirst()); // 행
		firstCol.addLast(firstCol.removeFirst()); // 1열
		lastCol.addLast(lastCol.removeFirst()); // 마지막열
	}
	
	public static int[][] solution(int[][] rc, String[] operations) {
		int[][] answer = {};
        
		// STEP 1. 2차원 배열 rc => 2개의 열과 나머지 행 구조로 나누기
		rcSetting(rc);
        
		// STEP 2. 메인 작업
		for (String operation : operations) { // "Rotate", "ShiftRow"
        	
			switch (operation.charAt(0)) { // 'R', 'S'
				case 'R' : rotate(); break;
				case 'S' : shiftRow(); break;
			}
		}
        
		// STEP 3. 2차원 배열 answer에 값 담기
		answer = new int[r][c];
        
		for (int i = 0; i < r; i++) {
			// addFirst 추가 구조에서 큐 구조로 빼내기 위해 removeLast 사용
			answer[i][0] = firstCol.removeLast(); // 1열
			answer[i][c - 1] = lastCol.removeLast(); // 마지막열
        	
			Deque<Integer> tempRow = new ArrayDeque<Integer>(); // restRows의 각 행을 담기 위해 tempRow 생성
        	
			// addFirst 추가 구조에서 큐 구조로 빼내기 위해 removeLast 사용
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
		String[] operations = {"Rotate", "ShiftRow"}; // Rotate : 행렬 바깥쪽에 있는 원소를 시계 방향으로 회전, ShiftRow : 행을 한 칸씩 아래로 이동
		
//		    Rotate  ShiftRow
//		1 2 3    4 1 2    8 9 6
//		4 5 6    7 5 3    4 1 2
//		7 8 9    8 9 6    7 5 9
		
		System.out.println(solution(rc, operations)); // {{8, 9, 6}, {4, 1, 2}, {7, 5, 3}}
	}

}
