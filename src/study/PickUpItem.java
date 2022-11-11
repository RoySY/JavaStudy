package study;

import java.util.LinkedList;
import java.util.Queue;

public class PickUpItem {
	
	// 아이템 줍기
	
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;
		int[][] board = new int[101][101]; // 전체 영역
		boolean[][] visited = new boolean[101][101]; // 방문한 좌표인지 확인을 위한 2차원 boolean 배열
		int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우 이동에서 x 좌표 증감 값
		int[] dy = {1, -1, 0, 0}; // 상, 하, 좌, 우 이동에서 y 좌표 증감 값
		
		// STEP 1. 모든 사각형의 모서리 영역과 내부 영역을 1로 채운다.
		for (int i = 0; i < rectangle.length; i++) {
			
			int[] eachRectangle = rectangle[i]; // 하나의 사각형 꼭지점 정보가 담긴 배열
			
			// 그림1의 문제를 해결하기 위해 모든 좌표 값의 크기를 2배로 해준다.
			for (int x = eachRectangle[0] * 2; x <= eachRectangle[2] * 2; x++) {
				
				for (int y = eachRectangle[1] * 2; y <= eachRectangle[3] * 2; y++) {
					board[x][y] = 1;
				}
			}
		}
		
		// STEP 2. 모서리 영역을 제외한 내부 영역을 0으로 채운다.
		for (int i = 0; i < rectangle.length; i++) {
			
			int[] eachRectangle = rectangle[i]; // 하나의 사각형 꼭지점 정보가 담긴 배열
			
			// 시작 꼭지점 좌표 + 1 ~ 마지막 꼭지점 좌표 - 1까지 0으로 채우면 사각형 내부 영역이 0으로 채워지게 된다.
			for (int x = eachRectangle[0] * 2 + 1; x <= eachRectangle[2] * 2 - 1; x++) {
				
				for (int y = eachRectangle[1] * 2 + 1; y <= eachRectangle[3] * 2 - 1; y++) {
					board[x][y] = 0;
				}
			}
		}
		
		// STEP 3. 캐릭터의 이동 정보를 담을 클래스 CharacterPosition에 캐릭터 초기값 세팅
		CharacterPosition characterPosition = new CharacterPosition(characterX * 2, characterY * 2, 0);
		
		// STEP 4. BFS 수행
		Queue<CharacterPosition> q = new LinkedList<>();
		
		q.add(characterPosition);
		
		visited[characterX * 2][characterY * 2] = true;
		
		while (!q.isEmpty()) {
			CharacterPosition tempCharacterPosition = q.poll();
			
			if (tempCharacterPosition.x == itemX * 2 && tempCharacterPosition.y == itemY * 2) { // 캐릭터가 아이템 위치에 도달했다면
				answer = tempCharacterPosition.moveCnt / 2;
				break;
			}
			
			for (int i = 0; i < 4; i++) { // 상, 하, 좌, 우 이동
				int nextX = dx[i] + tempCharacterPosition.x;
				int nextY = dy[i] + tempCharacterPosition.y;
				
				// 직사각형을 나타내는 모든 좌표값은 1 이상 50 이하인 자연수입니다. 이 조건에 의해 2배 값인 2부터 100까지가 캐릭터의 이동 가능 범위가 된다.
				if (nextX < 2 || nextX > 100 || nextY < 2 || nextY > 100) {
					continue;
				}
				
				if (!visited[nextX][nextY] && board[nextX][nextY] == 1) { // 방문하지 않은 모서리 영역이라면
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
		
		// 전체 영역을 만들고, 모든 사각형의 모서리 영역과 내부 영역을 1로 채운 후, 내부 영역만 다시 0으로 채워 모서리에 남은 값 1을 따라서 좌표 이동을 하도록 만들면 된다.
		// 아래 그림1을 보면 서로 떨어져 있는 사각형이지만 두 모서리의 간격이 1이기 때문에 1을 따라서 좌표 이동을 할 경우 두 사각형이 붙어있는 것으로 인식하는 문제가 발생한다.
		// 모든 사각형의 좌표, 캐릭터의 좌표, 아이템의 좌표를 x2 하여 문제를 해결할 수 있다.
		// 이후 총 이동 거리에서 나누기 2를 해주면 된다.
		// int[][] rectangle = {{2,2,14,8},{6,4,10,10},{8,6,12,18},{4,12,16,16}};
		// int characterX = 2;
		// int characterY = 6;
		// int itemX = 14;
		// int itemY = 16;
		// 조건을 위와 같이 바꾼 후 문제를 풀고, 결과 값의 1/2을 답으로 제출하면 된다.
		// 그림1 확인 : https://champcoder.tistory.com/128
		
		System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
	}
}