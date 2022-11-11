package study;

import java.util.LinkedList;
import java.util.Queue;

public class PickUpItem {
	
	// ������ �ݱ�
	
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;
		int[][] board = new int[101][101]; // ��ü ����
		boolean[][] visited = new boolean[101][101]; // �湮�� ��ǥ���� Ȯ���� ���� 2���� boolean �迭
		int[] dx = {0, 0, -1, 1}; // ��, ��, ��, �� �̵����� x ��ǥ ���� ��
		int[] dy = {1, -1, 0, 0}; // ��, ��, ��, �� �̵����� y ��ǥ ���� ��
		
		// STEP 1. ��� �簢���� �𼭸� ������ ���� ������ 1�� ä���.
		for (int i = 0; i < rectangle.length; i++) {
			
			int[] eachRectangle = rectangle[i]; // �ϳ��� �簢�� ������ ������ ��� �迭
			
			// �׸�1�� ������ �ذ��ϱ� ���� ��� ��ǥ ���� ũ�⸦ 2��� ���ش�.
			for (int x = eachRectangle[0] * 2; x <= eachRectangle[2] * 2; x++) {
				
				for (int y = eachRectangle[1] * 2; y <= eachRectangle[3] * 2; y++) {
					board[x][y] = 1;
				}
			}
		}
		
		// STEP 2. �𼭸� ������ ������ ���� ������ 0���� ä���.
		for (int i = 0; i < rectangle.length; i++) {
			
			int[] eachRectangle = rectangle[i]; // �ϳ��� �簢�� ������ ������ ��� �迭
			
			// ���� ������ ��ǥ + 1 ~ ������ ������ ��ǥ - 1���� 0���� ä��� �簢�� ���� ������ 0���� ä������ �ȴ�.
			for (int x = eachRectangle[0] * 2 + 1; x <= eachRectangle[2] * 2 - 1; x++) {
				
				for (int y = eachRectangle[1] * 2 + 1; y <= eachRectangle[3] * 2 - 1; y++) {
					board[x][y] = 0;
				}
			}
		}
		
		// STEP 3. ĳ������ �̵� ������ ���� Ŭ���� CharacterPosition�� ĳ���� �ʱⰪ ����
		CharacterPosition characterPosition = new CharacterPosition(characterX * 2, characterY * 2, 0);
		
		// STEP 4. BFS ����
		Queue<CharacterPosition> q = new LinkedList<>();
		
		q.add(characterPosition);
		
		visited[characterX * 2][characterY * 2] = true;
		
		while (!q.isEmpty()) {
			CharacterPosition tempCharacterPosition = q.poll();
			
			if (tempCharacterPosition.x == itemX * 2 && tempCharacterPosition.y == itemY * 2) { // ĳ���Ͱ� ������ ��ġ�� �����ߴٸ�
				answer = tempCharacterPosition.moveCnt / 2;
				break;
			}
			
			for (int i = 0; i < 4; i++) { // ��, ��, ��, �� �̵�
				int nextX = dx[i] + tempCharacterPosition.x;
				int nextY = dy[i] + tempCharacterPosition.y;
				
				// ���簢���� ��Ÿ���� ��� ��ǥ���� 1 �̻� 50 ������ �ڿ����Դϴ�. �� ���ǿ� ���� 2�� ���� 2���� 100������ ĳ������ �̵� ���� ������ �ȴ�.
				if (nextX < 2 || nextX > 100 || nextY < 2 || nextY > 100) {
					continue;
				}
				
				if (!visited[nextX][nextY] && board[nextX][nextY] == 1) { // �湮���� ���� �𼭸� �����̶��
					q.offer(new CharacterPosition(nextX, nextY, tempCharacterPosition.moveCnt + 1));
					visited[nextX][nextY] = true;
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
		int characterX = 1;
		int characterY = 3;
		int itemX = 7;
		int itemY = 8;
		
		// ��ü ������ �����, ��� �簢���� �𼭸� ������ ���� ������ 1�� ä�� ��, ���� ������ �ٽ� 0���� ä�� �𼭸��� ���� �� 1�� ���� ��ǥ �̵��� �ϵ��� ����� �ȴ�.
		// �Ʒ� �׸�1�� ���� ���� ������ �ִ� �簢�������� �� �𼭸��� ������ 1�̱� ������ 1�� ���� ��ǥ �̵��� �� ��� �� �簢���� �پ��ִ� ������ �ν��ϴ� ������ �߻��Ѵ�.
		// ��� �簢���� ��ǥ, ĳ������ ��ǥ, �������� ��ǥ�� x2 �Ͽ� ������ �ذ��� �� �ִ�.
		// ���� �� �̵� �Ÿ����� ������ 2�� ���ָ� �ȴ�.
		// int[][] rectangle = {{2,2,14,8},{6,4,10,10},{8,6,12,18},{4,12,16,16}};
		// int characterX = 2;
		// int characterY = 6;
		// int itemX = 14;
		// int itemY = 16;
		// ������ ���� ���� �ٲ� �� ������ Ǯ��, ��� ���� 1/2�� ������ �����ϸ� �ȴ�.
		// �׸�1 Ȯ�� : https://champcoder.tistory.com/128
		
		System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
	}
}