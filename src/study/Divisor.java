package study;

public class Divisor {
	
	// ��� ���ϱ�
	
	public static void divFun(int n) {
		int cnt = 0;
		
		for(int i = 1; i <= n; i++) {
			
			if(n % i == 0) {
				cnt++;
				
				System.out.print(i + " ");
			}
		}
		
		System.out.println("�� " + cnt + "��");
	}
	
	public static void divCntFast(int n) {
		double d = Math.sqrt(n);
		int z = (int) Math.sqrt(n);
		int cnt = 0;
		
//		System.out.println(d);
//		System.out.println(z);
		
//		if(d == z) {
//			System.out.println("����"); // 16, 25�� ��� ���ƿ� �ɸ�
//		} else {
//			System.out.println("�ٸ���");
//		}
		
		for(int i = 1; i < z; i++) {
			
			if(n % i == 0) {
				cnt++;
			}
		}
		
		cnt *= 2;
		
		if(d == z) {
			cnt += 1;
		}
		
		System.out.println(n + "�� ����� ���� �� "+ cnt + "��");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 16;
		
//		divFun(n);
		
		divCntFast(n);
	}
}