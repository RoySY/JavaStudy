package study;

import java.util.Stack;

public class StockPrice {
	
	// �ֽİ���
	
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer[]> stack = new Stack<>();
		
		for (int i = 0; i < prices.length; i++) {
			answer[i] = prices.length - 1 - i; // �ִ� �ð����� ���� // 4, 3, 2, 1, 0
			Integer[] tempArr = {i, prices[i]}; // 0, 1 // 1, 2 // 2, 3 // 3, 2 // 4, 3
			
			while (!stack.isEmpty() && stack.peek()[1] > prices[i]) { // ������ �������ٸ�
				Integer[] price = stack.pop();
				answer[price[0]] = i - price[0];
			}
			
			stack.push(tempArr);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 2, 3, 2, 3}; // 4, 3, 1, 1, 0
//		int[] prices = {3, 5, 5, 4, 1}; // 4, 2, 1, 1, 0
		
		System.out.println(solution(prices));
	}
}