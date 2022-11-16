package study;

public class DynamicProgramming1 {
	
	// DP
	// �޸𸮸� ������ ����Ͽ� ���� �ð� ȿ������ ��������� ����Ű�� ���
	// �̹� ���� ���(���� ����)�� ������ �޸� ������ �����Ͽ� �ٽ� ������ �ʵ��� �Ѵ�.
	// �Ϲ������� ž�ٿ�� ���Ҿ����� �����ȴ�. 1. ���� �κ� ����(���� ������ ��Ƽ� ū ���� �ذ� ����), 2. �ߺ��Ǵ� �κ� ����(������ ���� ������ �ݺ������� �ذ��ؾ� �� ��)
	// ���� 1, 2 ���� ��� �����ϸ� DP�� Ǯ �� �ִ�.
	// ž�ٿ�(��� �Լ�), ���Ҿ�(�ݺ���)
	// �Ǻ���ġ ������ ���� �� �� �ִ�.
	// ��ȭ���� ���� �� �ִ��� Ȯ�� �ʿ�
	// �Ǻ���ġ ������ ��ȭ�� : an = an-1 + an-2, a1 = 1, a2 = 1
	// optimal solution : ������ ��
	
	public static int[] dpArr1 = new int[100];
	public static int[] dpArr2 = new int[100];
	
	public static int fiboRecursiveFun(int n) { // 1, 1, 2, 3, 5, 8, 13, 21..
		
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return fiboRecursiveFun(n-1) + fiboRecursiveFun(n-2);
				   // fiboRecursiveFun(4) 													+ fiboRecursiveFun(3)
				   // fiboRecursiveFun(3) 							+ fiboRecursiveFun(2) 	+ fiboRecursiveFun(3)
				   // fiboRecursiveFun(2) + fiboRecursiveFun(1) 	+ fiboRecursiveFun(2) 	+ fiboRecursiveFun(3)
				   //        1            +         1               +          1            + fiboRecursiveFun(3)
			 	   //        1            +         1               +          1            + fiboRecursiveFun(2) + fiboRecursiveFun(1)
				   //	     1            +         1               +          1            +          1          +           1
				   // �ܼ� ����Լ��� �̿��� Ǯ�� �Ǹ� ����� ���� �� ����ϱ� ������ ���� �ð� ���⵵�� ������ �ȴ�.
				   // fiboRecursiveFun(5)�� ���ϱ� ���� fiboRecursiveFun(2)�� 3�� ȣ��ȴ�. ���ڰ� Ŀ���� �� ���� ȣ��� ���̴�.
				   // �̹� ���� ���� �޸𸮿� �����س��� ������ ���⸸ �ϸ� �� ȿ�����̴�.
		}
	}
	
	// ž�ٿ� ���(�����)���� ���Ǵ� �޸������̼�(DP�� �����ϴ� ��� �� �ϳ�) ����Լ��� �̿��� �ž�
	// fiboRecursiveFun���� ���� ���� �����س��� ���
	public static int fiboTopDown(int n) {
		
		if (n == 1 || n == 2) {
			return 1;
		}
		
		if (dpArr1[n] != 0) {
			return dpArr1[n];
		}
		
		dpArr1[n] = fiboTopDown(n - 1) + fiboTopDown(n - 2); // dpArr1[1], dpArr1[2]���� 1�� �� ��
		
		return dpArr1[n];
	}
	
	// ���Ҿ� ���(�����)�� �Ʒ��ʿ������� ���� ������ �ϳ��� �ذ��� �����鼭 ���� �������� �ذ��� ������ ������� �ݺ����� �̿��Ѵ�.(�������� ����)
	// ��� ����� ����Ʈ�� DP���̺��̶�� �Ѵ�.
	public static int bottomUp(int n) {
		
		dpArr2[1] = 1;
		dpArr2[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			dpArr2[i] = dpArr2[i - 1] + dpArr2[i - 2];
		}
		
		return dpArr2[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fiboRecursiveFun(5)); // ����Լ��� �̿��� �Ǻ���ġ // 5
		System.out.println(fiboTopDown(5)); // ����Լ��� �̿��� ž�ٿ� DP // 5
		System.out.println(bottomUp(5)); // �ݺ����� �̿��� ���Ҿ� DP // 5
		
		// ���� ���������� ������ �κ� ������ �ݺ������� ������ �ʴ´�.(�� ������ ��ǥ��)
		// �ٸ� �˰������� Ǯ�� ����� �������� ������ ���̳��� ���α׷����� ����غ���
		// �ϴ� ��� �Լ��� ��ȿ������ ���� Ž�� ���α׷��� �ۼ��� �ڿ� (ž�ٿ�) ���� �������� ���� ���� ū �������� �״�� ���� �� ������, �޸������̼��� Ȱ���� �ڵ带 �����ϵ��� ����
		// �Ϲ����� �ڵ� �׽�Ʈ ���ؿ����� �⺻ ������ ���̳��� ���α׷��� ������ �����Ǵ� ��찡 ����.
	}

}
