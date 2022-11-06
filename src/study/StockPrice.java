package study;

import java.util.Stack;

public class StockPrice {
	
	// 주식가격
	
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		Stack<Integer[]> stack = new Stack<>();
		
		for (int i = 0; i < prices.length; i++) {
			answer[i] = prices.length - 1 - i; // 최대 시간으로 세팅 // 4, 3, 2, 1, 0
			Integer[] tempArr = {i, prices[i]}; // 0, 1 // 1, 2 // 2, 3 // 3, 2 // 4, 3
			
			while (!stack.isEmpty() && stack.peek()[1] > prices[i]) { // 가격이 떨어졌다면
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