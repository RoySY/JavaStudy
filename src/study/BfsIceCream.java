package study;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsIceCream {
	
	// 결과적으로 이 코드는 아이스크림 재료를 부을 수 있는 칸 0이 나오면 카운트를 증가하고,
	// 그곳의 상하좌우, 그 상하좌우의 또 상하좌우들을 전부 1로 만들어줘서 0으로부터 아이스크림이 생성될 수 있는 모든 곳을 1로 바꿔주는 코드이다.
	// 즉 0이 있다면 1로 만들고 카운트 증가 & 거기서부터 아이스크림이 만들어질 수 있는 모든 공간 1로 변경
	// 더이상 1로 바꿀 것이 없다면 다음 칸에서 다시 0인지 체크
	
	static int n = 0;
	static int m = 0;
	static String str = "";
	static int[][] arr = new int[1000][1000];
	public static int[] moveRow = {-1, 1, 0, 0};
	public static int[] moveCol = {0, 0, -1, 1};
	
	public static boolean bfs(int a, int b) {
		
		Queue<Point> q = new LinkedList<>();
		
		if (arr[a][b] == 0) { // 아이스크림 재료를 부을 수 있는 칸이라면
			
			q.offer(new Point(a,b));
			
			arr[a][b] = 1; // 아이스크림 재료 붓기
			
			while (!q.isEmpty()) {
				
				Point p = q.poll();
				
				int row = p.x;
				int col = p.y;
				
				for (int z = 0; z < 4; z++) { // 아이스크림 재료를 부은 칸의 상, 하, 좌, 우 확인하며 재료를 부을 수 있다면 같이 얼려서 아이스크림 덩어리 키우기
					int nextRow = row + moveRow[z];
					int nextCol = col + moveCol[z];
					
					// 4회 반복으로 인해 nextRow, nextCol은 아이스크림 재료를 부은 칸의 상, 하, 좌, 우 좌표가 될 것
					
					if (nextRow < 0 || nextRow > n - 1 || nextCol < 0 || nextCol > m - 1) { // 범위를 벗어난다면 continue
						continue;
					}
					
					if (arr[nextRow][nextCol] == 0) { // nextRow, nextCol이 재료를 부을 수 있는 칸이라면
						q.offer(new Point(nextRow,nextCol)); // nextRow, nextCol 기준 상, 하, 좌, 우 좌표 또한 같이 얼릴 수 있는 칸인지 확인을 위해 큐에 담기
						
						arr[nextRow][nextCol] = 1; // 재료 붓기
					}
				}
			}
			
			return true; // 아이스크림 재료를 부을 수 있는 칸이었으므로 true 리턴하여 result 값 1 증가되도록 하기
		}
		
		return false; // 아이스크림 재료를 부을 수 없는 칸이므로 false 리턴
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("행을 입력하세요 : ");
		
		n = scan.nextInt(); // 정수 입력 후 엔터를 치면 // 여기에 정수
		
//		scan.nextLine(); // 버퍼 비워주기 // 여기에 위에서 입력한 엔터
		
		System.out.print("열을 입력하세요 : ");
		
		m = scan.nextInt(); // 여기에 정수
		
		scan.nextLine(); // 버퍼 비워주기 // 위에서 입력받은 엔터들 이쪽으로
		
		System.out.println(n + "행 " + m + "열의 아이스크림 틀에서 아이스크림을 만듭니다. 빈 공간은 0 막힌 공간은 1로 입력해주세요 : ");
		
		for (int i = 0; i < n; i++) {
			System.out.print((i+1) + "번째 줄 입력 : ");
			str = scan.nextLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		scan.close(); // 입력 그만 받도록
		
		int result = 0;
		
		for (int k = 0; k < n; k++) {
			for (int z = 0; z < m; z++) {
				if (bfs(k, z)) {
					result += 1; // 결과적으로 이 result 카운트는 총 n x m 횟수 중 true일 경우에만 증가한다.
				}
			}
		}
		
		System.out.print("아이스크림 갯수 : " + result);
	}
}