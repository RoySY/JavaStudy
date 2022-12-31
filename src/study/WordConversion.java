package study;

public class WordConversion {
	
	// �ܾ� ��ȯ
	
	static boolean[] visited = {};
	static int gDepth = 0;
	
	public static boolean strCompare(String str1, String str2) { // str1�� str2�� ���̰� ���ٴ� ���� �Ͽ�
		int strLength = str1.length();
		int cnt = 0;
		
		for(int i = 0; i < strLength; i++) {
			
			if(str1.charAt(i) != str2.charAt(i)) {
				cnt++;
			}
		}
		
		if(cnt == 1) { // ���� ���ǿ��� 1���ڸ� �ٲ� �� �ִµ� 1���ڸ� �ٸ� ���
			return true;
		} else {
			return false;
		}
	}
	
	public static int dfs(String begin, String target, String[] words, int depth) { // hit // cog // {"hot", "dot", "dog", "lot", "log", "cog"}
		
		int mDepth = 0;
		
		for(int i = 0; i < words.length; i++) {
			
			mDepth = depth;
			
			if(visited[i]) {
				continue;
			}
			
			if(strCompare(begin, words[i])) { // 1���ڸ� �ٸ� ���, �� ���� ������ ���
				begin = words[i]; // �ٲ� �ܾ �� ������� ����
				mDepth++;
				visited[i] = true; // ����� �ܾ� �湮 ó��
				
				dfs(begin, target, words, mDepth);
				
				if(begin.equals(target)) {
					System.out.println(mDepth + "�� �������� ����");
					gDepth = mDepth;
					break;
				}
			} else {
				continue;
			}
		}
		return gDepth;
	}
	
	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		
		visited = new boolean[words.length];
		
		answer = dfs(begin, target, words, 0);
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"}; // hot -> dot -> dog -> cog
		
		System.out.println(solution(begin, target, words)); // 4
	}
}