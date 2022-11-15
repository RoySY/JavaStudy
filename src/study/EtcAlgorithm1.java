package study;

import java.util.Arrays;

public class EtcAlgorithm1 {
	
	// �Ҽ�(Prime Number) : ����
	
	// x�� �Ҽ����� üũ
	public static boolean isPrimeNumber1(int x) { // �ð� ���⵵ O(N)
		
		for (int i = 2; i < x; i++) { // 2���� �ڱ� �ڽ� ���������� üũ
			
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// ����� ���� : ��� ����� ��� ����� �������� ���� ���꿡 ���� ��Ī�� �̷�ٴ� ���� �̿��ϸ� �ð� ���⵵�� ���� �� �ִ�.
	// �����ٱ����� Ȯ���ϸ� �ȴٴ� ���̴�.
	
	// x�� �Ҽ����� üũ(�� ȿ����)
	public static boolean isPrimeNumber2(int x) { // �ð� ���⵵ O(������N)
		
		for (int i = 2; i <= Math.sqrt(x); i++) { // 2���� ������ �� ���ϱ��� üũ
			
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// �ټ��� �Ҽ� �Ǻ�
	// �����佺�׳׽��� ü �˰��� ���
	// 2���� N������ ��� �ڿ������� ����
	// ���� �� �߿��� ���� ó������ ���� ���� ���� �� i�� ã�´�.
	// ���� �� �߿��� i�� ����� ��� �����Ѵ�. (i�� �������� ������.)
	// �� �̻� �ݺ��� �� ���� ������ 2���� 3���� ������ �ݺ��Ѵ�.
	
	// 26������ ���� �� �Ҽ��� ������?
	// 2�� ������ 2�� ����� ����
	// 3�� ������ 3�� ����� ����
	// 5�� ������ 5�� ����� ����
	// ������ 26�� 5�� 6 �����̹Ƿ� 5.xxxx (�� ���ϱ����� üũ�ϸ� �ȴ�.)
	// ���ܵ��� ���� ������ ��� �Ҽ�
	
	// x������ ���� ���� �� �Ҽ� �����ϱ�
	public static void primeNumbers(int x) { // 26
		boolean[] arr = new boolean[x + 1]; // 26���� üũ�ؾ� �ϹǷ� �迭�� ũ�� +1
		
		Arrays.fill(arr, true); // �ϴ� ��� ���� �Ҽ���� üũ
		
		arr[0] = false; // 0�� �Ҽ��� �ƴ�
		arr[1] = false; // 1�� �Ҽ��� �ƴ�
		
		for (int i = 2; i <= Math.sqrt(x); i++) {
			
			// x������ 2�� ������� ������
			if (arr[i] == true) {
				
				int j = 2;
				
				while (i * j <= x) {
					arr[i * j] = false;
					j++;
				}
			}
		}
		
		for (int i = 2; i <= x; i++) {
			
			if (arr[i] == true) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPrimeNumber1(6));
		System.out.println(isPrimeNumber2(7));
		primeNumbers(26);
	}

}
