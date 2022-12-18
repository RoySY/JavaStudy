package baekjoon;

public class B1541 {
	
	// �Ҿ���� ��ȣ - Greedy 1541��
	
	public static int solution(String str) {
		String[] strArr1 = str.split("-"); // "-" ���� �������� split
		int totalSum = 0;
		int tempSum = 0;
		
		// strArr1 = {"55", "50+40", "20", "30+40"}
		
		for (int i = 0; i < strArr1.length; i++) {
			
			tempSum = 0;
			
			String[] strArr2 = strArr1[i].split("\\+"); // "+" Ư������ �������� split (Ư�������� ��� \\Ư������ or [Ư������])
			
			for (int j = 0; j < strArr2.length; j++) {
				tempSum += Integer.parseInt(strArr2[j]);
			}
			
			if (i == 0) { // ó�� ������ +
				totalSum += tempSum; // +55
			} else { // ���� ������ -
				totalSum -= tempSum; // -90-20-70
			}
		}
		
		return totalSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "55-50+40-20-30+40"; // (55)-(50+40)-(20)-(30+40) �� ���� �ּҰ� �ȴ�.
		
		System.out.println(solution(str)); // -125
	}
}