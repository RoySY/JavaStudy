package study;

public class Stealing {
	
	// 도둑질
	
	public static int solution(int[] money) {
		int answer = 0;
		int[] dpExceptLast = new int[money.length - 1]; // 1, 2, 3, 1, 4, 2 담자
		int[] dpExceptFirst = new int[money.length - 1]; // 2, 3, 1, 4, 2, 5 담자
        
		dpExceptLast[0] = money[0]; // 1
		dpExceptLast[1] = Math.max(money[0], money[1]); // 2
		
		dpExceptFirst[0] = money[1]; // 2
		dpExceptFirst[1] = Math.max(money[1], money[2]); // 3
        
		for (int i = 2; i < money.length; i++) {
			if (i < money.length - 1) {
				dpExceptLast[i] = Math.max(dpExceptLast[i - 2] + money[i], dpExceptLast[i - 1]);
			}
        	
			if (i > 2) {
				dpExceptFirst[i - 1] = Math.max(dpExceptFirst[i - 3] + money[i], dpExceptFirst[i - 2]);
			}
		}
        
		answer = Math.max(dpExceptLast[money.length - 2], dpExceptFirst[money.length - 2]);
        
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] money = {1, 2, 3, 1, 4, 2, 5};
		
		System.out.println(solution(money));
	}
}