package study;

public class WordConversion {
	
	// 단어 변환
	
	static boolean[] visited = {};
	static int gDepth = 0;
	
	public static boolean strCompare(String str1, String str2) { // str1과 str2의 길이가 같다는 조건 하에
		int strLength = str1.length();
		int cnt = 0;
		
		for(int i = 0; i < strLength; i++) {
			
			if(str1.charAt(i) != str2.charAt(i)) {
				cnt++;
			}
		}
		
		if(cnt == 1) { // 변형 조건에서 1글자만 바꿀 수 있는데 1글자만 다를 경우
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
			
			if(strCompare(begin, words[i])) { // 1글자만 다른 경우, 즉 변경 가능한 경우
				begin = words[i]; // 바꿀 단어를 비교 대상으로 변경
				mDepth++;
				visited[i] = true; // 사용한 단어 방문 처리
				
				dfs(begin, target, words, mDepth);
				
				if(begin.equals(target)) {
					System.out.println(mDepth + "번 변경으로 가능");
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