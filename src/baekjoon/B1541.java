package baekjoon;

public class B1541 {
	
	// 잃어버린 괄호 - Greedy 1541번
	
	public static int solution(String str) {
		String[] strArr1 = str.split("-"); // "-" 문자 기준으로 split
		int totalSum = 0;
		int tempSum = 0;
		
		// strArr1 = {"55", "50+40", "20", "30+40"}
		
		for (int i = 0; i < strArr1.length; i++) {
			
			tempSum = 0;
			
			String[] strArr2 = strArr1[i].split("\\+"); // "+" 특수문자 기준으로 split (특수문자의 경우 \\특수문자 or [특수문자])
			
			for (int j = 0; j < strArr2.length; j++) {
				tempSum += Integer.parseInt(strArr2[j]);
			}
			
			if (i == 0) { // 처음 구간은 +
				totalSum += tempSum; // +55
			} else { // 이후 구간은 -
				totalSum -= tempSum; // -90-20-70
			}
		}
		
		return totalSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "55-50+40-20-30+40"; // (55)-(50+40)-(20)-(30+40) 이 값이 최소가 된다.
		
		System.out.println(solution(str)); // -125
	}
}