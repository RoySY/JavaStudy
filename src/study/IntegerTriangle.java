package study;

public class IntegerTriangle {
	
	// 정수 삼각형
	
	public static int solution(int[][] triangle) {
		int answer = 0;
		
		int[][] dpTriangle = new int[triangle.length][triangle.length];
		
		dpTriangle[0][0] = triangle[0][0];
		
		for (int i = 1; i < triangle.length; i++) {
			
			// 가장 왼쪽
			dpTriangle[i][0] = dpTriangle[i - 1][0] + triangle[i][0];
			
			// 나머지
			for (int j = 1; j < i; j++) {
				dpTriangle[i][j] = Math.max(dpTriangle[i - 1][j - 1], dpTriangle[i - 1][j]) + triangle[i][j];
			}
			
			// 가장 오른쪽
			dpTriangle[i][i] = dpTriangle[i - 1][i - 1] + triangle[i][i];
		}
		
		for (int i = 0; i < triangle.length; i++) {
			answer = Math.max(answer, dpTriangle[triangle.length - 1][i]);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		System.out.println(solution(triangle));
	}
}