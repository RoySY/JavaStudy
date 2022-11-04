package study;
import java.util.Scanner;

public class Greedy4 {
	
	// [�׸��� �˰���]
	// ����2. �������࿡�� ATM�� 1��ۿ� ����. ���� �� ATM�տ� N���� ������� ���� ���ִ�.
	// ����� 1������ N������ ��ȣ�� �Ű��� ������, i�� ����� ���� �����ϴµ� �ɸ��� �ð��� Pi���̴�.
	// ������� ���� ���� ������ ����, ���� �����ϴµ� �ʿ��� �ð��� ���� �޶����� �ȴ�.
	// ���� ���, �� 5���� �ְ�, P1 = 3, P2 = 1, P3 = 4, P4 = 3, P5 = 2 �� ��츦 �����غ���.
	// [1, 2, 3, 4, 5] ������ ���� ���ٸ�, 1�� ����� 3�и��� ���� ���� �� �ִ�.
	// 2�� ����� 1�� ����� ���� ���� �� ���� ��ٷ��� �ϱ� ������, 3+1 = 4���� �ɸ��� �ȴ�.
	// 3�� ����� 1��, 2�� ����� ���� ���� ������ ��ٷ��� �ϱ� ������, �� 3+1+4 = 8���� �ʿ��ϰ� �ȴ�.
	// 4�� ����� 3+1+4+3 = 11��, 5�� ����� 3+1+4+3+2 = 13���� �ɸ��� �ȴ�.
	// �� ��쿡 �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� 3+4+8+11+13 = 39���� �ȴ�.
	// ���� [2, 5, 1, 4, 3] ������ ���� ����, 2�� ����� 1�и���, 5�� ����� 1+2 = 3��, 1�� ����� 1+2+3 = 6��,
	// 4�� ����� 1+2+3+3 = 9��, 3�� ����� 1+2+3+3+4 = 13���� �ɸ��� �ȴ�. �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� 1+3+6+9+13 = 32���̴�.
	// �� ������� �� �ʿ��� �ð��� ���� �ּҷ� ���� ���� ����.
	// ���� �� �ִ� ����� �� N�� �� ����� ���� �����ϴµ� �ɸ��� �ð� Pi�� �־����� ��,
	// �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cnt = 0;
		String totalMinutes = "";
		
		Scanner scan = new Scanner(System.in);
		Scanner minScan = new Scanner(System.in);
		
		System.out.print("���� �����ϱ� ���� ��ٸ��� ��� �� : ");
		
		cnt = scan.nextInt();
		
		System.out.print("�� ����� ���� �����ϴµ� �ɸ��� �ð� (����� �� ���� ex)2 6 9 : ");
		
		totalMinutes = minScan.nextLine(); // �� ���ڿ� ���� ���� ������ �Է¹޴´�.
//		totalMinutes = scan.next(); // next�� �� ���ڿ� �������� �Է¹޴´�.
//		totalMinutes = "power over whelming"; // totalMinutes.split("\\s+"); // ���� split ����
		
		String[] array = totalMinutes.split(" "); // ����
		int[] tempArray = new int[cnt];
		int[] resultArray = new int[cnt];
		int tempNum = 0;
		int minIdx = 0;
		int totalSum = 0;
		
		for (int i = 0; i < cnt; i++) { // �ð��� ��� ������ �� �Է��߾ ��� ����ŭ�� üũ
			tempArray[i] = Integer.parseInt((array[i])); // tempArray�� ���� �ð� �������
		}
		
		for (int k = 0; k < tempArray.length; k++) { // �迭�� ��� �� �� ���� ���� �ž�
			tempNum = tempArray[k];
			minIdx = k;
			
			for (int j = k; j < tempArray.length; j++) {
				
				if (tempNum > tempArray[j]) {
					minIdx = j;
					tempNum = tempArray[minIdx];
				}
			}
			
			tempArray[minIdx] = tempArray[k];
			tempArray[k] = tempNum;
		}
		
//		for (int i = 0; i < tempArray.length; i++) { // ���� �ùٸ��� �Ǿ����� Ȯ��
//			System.out.println(tempArray[i]);
//		}
		
		for (int z = 0; z < tempArray.length; z++) {
			
			resultArray[z] = tempArray[z];
					
			for (int k = 0; k < z; k++) {
				resultArray[z] += tempArray[k];
			}
		}
		
		for (int x = 0; x < resultArray.length; x++) {
			totalSum += resultArray[x];
		}
		
		System.out.println("�� �հ� �ð� : " + totalSum);
	}
}
