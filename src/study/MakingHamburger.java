package study;

public class MakingHamburger {
	
	// ÇÜ¹ö°Å ¸¸µé±â
	// »§(1), ¾ßÃ¤(2), °í±â(3), »§(1)ÀÏ °æ¿ì ÇÜ¹ö°Å ¿Ï¼º
	
	public static int solution(int[] ingredient) {
		int answer = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < ingredient.length; i++) {
			sb.append(ingredient[i]);
			
			if (sb.length() > 3 && sb.subSequence(sb.length() - 4, sb.length()).equals("1231")) {
				sb.delete(sb.length() - 4, sb.length());
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		
		System.out.println(solution(ingredient));
	}
}