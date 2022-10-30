package study;

import java.util.Scanner;

public class DfsIceCream {
	
	// 결과적으로 이 코드는 아이스크림 재료를 부을 수 있는 칸 0이 나오면 카운트를 증가하고,
	// 그곳의 상하좌우, 그 상하좌우의 또 상하좌우들을 전부 1로 만들어줘서 0으로부터 아이스크림이 생성될 수 있는 모든 곳을 1로 바꿔주는 코드이다.
	// 즉 0이 있다면 1로 만들고 카운트 증가 & 거기서부터 아이스크림이 만들어질 수 있는 모든 공간 1로 변경
	// 더이상 1로 바꿀 것이 없다면 다음 칸에서 다시 0인지 체크
	
	static int n = 0;
	static int m = 0;
	static int[][] arr = new int[1000][1000];
	static String str = "";
	
	public static boolean dfs(int a, int b) {
		
		if (a < 0 || a > n - 1 || b < 0 || b > m - 1) { // 범위 벗어나는지 확인
			return false;
		}
		
		if (arr[a][b] == 0) { // 아이스크림을 만들 수 있는 공간이라면
			arr[a][b] = 1; // 아이스크림을 붓기
			dfs(a, b + 1); // 상 칸도 만들 수 있는 공간이라면 아이스크림 붓기위해 dfs함수 실행 // 여기서 또 0이 나오면 아이스크림 붓고 상,하,좌,우 체크하여 dfs함수 실행 반복 또 반복
			dfs(a, b - 1); // 하 칸도 만들 수 있는 공간이라면 아이스크림 붓기위해 dfs함수 실행
			dfs(a - 1, b); // 좌 칸도 만들 수 있는 공간이라면 아이스크림 붓기위해 dfs함수 실행
			dfs(a + 1, b); // 우 칸도 만들 수 있는 공간이라면 아이스크림 붓기위해 dfs함수 실행
			return true; // 아이스크림을 만들었다면 카운트 증가를 위해 true 반환
		}
		
		return false;
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
				if (dfs(k, z)) {
					result += 1; // 결과적으로 이 result 카운트는 총 n x m 횟수 중 true일 경우에만 증가한다.
				}
			}
		}
		
		System.out.print("아이스크림 갯수 : " + result);
	}

}
