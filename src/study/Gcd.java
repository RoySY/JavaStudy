package study;

public class Gcd {
	
	// 유클리드 호제법을 이용한 최대공약수 구하기
	// 두 자연수 A, B에 대하여(A > B) A를 B로 나눈 나머지를 R이라고 할 때
	// A와 B의 최대공약수는 B와 R의 최대공약수와 같다.
	// 이것은 재귀함수로 작성 가능하다.
	
	public static void gcd(int a, int b) {
		int x = 0;
		int y = 0;
		int z = 0;
		
		if(a >= b) {
			x = a;
			y = b;
		} else {
			x = b;
			y = a;
		}
		
		if(y == 0) {
			System.out.println(x);
			return;
		}
		
		z = x % y; // 30
		
		gcd(y, z);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 192	162
		// 162	30 (192를 162로 나눈 나머지)
		// 30	12 (162를 30으로 나눈 나머지)
		// 12	6 (30을 12로 나눈 나머지)
		// 6	0 (12를 6으로 나눈 나머지)
		// 최대공약수는 6
		gcd(192, 162);
	}
}