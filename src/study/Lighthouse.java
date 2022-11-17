package study;

import java.util.HashSet;

public class Lighthouse {
	
	// 등대
	
	public static int solution(int n, int[][] lighthouse) {
		int answer = 0;
		int[] linkedCntArr; // 각 등대에 연결된 등대의 수를 입력받기 위한 배열
		
		HashSet<Integer> edgeHs = new HashSet<>(); // 가장자리(둘레나 끝에 해당되는 부분)에 위치한 등대의 번호를 담을 HashSet
		HashSet<Integer> turnOnHs = new HashSet<>(); // 가장자리(둘레나 끝에 해당되는 부분)에 위치한 등대와 연결된, 반드시 켜야 하는 등대의 번호를 담을 HashSet
		int[][] remainingLightHouse; // 반드시 켜야 하는 등대를 킨 후 남은 등대 쌍을 담을 2차원 배열
		int remainingCnt; // remainingLightHouse에 담긴 등대 쌍의 수
		
		// CASE 1을 기준으로 설명
		
		for (int a = 0; a < n; a++) { // 과정 반복
			
			// 현재 turnOnHs가 비어있지 않은 상황이라면, turnOnHs에 담긴 번호의 등대를 킨 상황으로, 켜진 등대의 영향을 받는 등대는 고려해야 할 대상에서 제외한다.(lighthouse의 길이가 줄었을 것)
			
			linkedCntArr = new int[n + 1]; // linkedCntArr 초기화 // 0 ~ n
			remainingLightHouse = new int[lighthouse.length][2]; // remainingLightHouse 초기화
			remainingCnt = 0; // remainingCnt 초기화
			
			for (int i = 0; i < lighthouse.length; i++) {
				linkedCntArr[lighthouse[i][0]]++;
				linkedCntArr[lighthouse[i][1]]++;
			}
			
			// linkedCntArr : {0, 4, 2, 1, 1, 3, 3, 1, 1, 2, 2, 1, 3, 1, 1}
			
			for (int i = 0; i < linkedCntArr.length; i++) {
				
				if (linkedCntArr[i] == 1) { // 연결된 등대가 하나뿐이라면 가장자리(둘레나 끝에 해당되는 부분)에 위치한 등대
					edgeHs.add(i); // edgeHs에 등대 번호 담기
				}
			}
			
			// edgeHs : [3, 4, 7, 8, 11, 13, 14]
			
			for (int i = 0; i < lighthouse.length; i++) {
				
				// 가장자리(둘레나 끝에 해당되는 부분)에 위치한 등대와 연결된 등대 번호를 turnOnHs에 담기 // 반드시 켜야 하는 등대 번호
				
				if (edgeHs.contains(lighthouse[i][0]) || edgeHs.contains(lighthouse[i][1])) {
					
					if (edgeHs.contains(lighthouse[i][0])) {
						turnOnHs.add(lighthouse[i][1]);
					} else {
						turnOnHs.add(lighthouse[i][0]);
					}
				}
			}
			
			// turnOnHs : [1, 6, 10, 12]
			
			for (int i = 0; i < lighthouse.length; i++) {
				
				// turnOnHs에 담긴 켜진 등대의 영향으로 밝힐 수 없는 등대 쌍이 있는지 확인
				
				if (!turnOnHs.contains(lighthouse[i][0]) && !turnOnHs.contains(lighthouse[i][1])) {
					remainingLightHouse[remainingCnt] = lighthouse[i];
					remainingCnt++;
				}
			}
			
			// remainingLightHouse : {{2, 9}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}
			// remainingCnt == 1
			
			if (remainingCnt == 0) { // 현재 켜진 등대로 모든 등대를 밝힐 수 있다면
				break;
			}
			
			if (remainingCnt == 1) { // 현재 켜진 등대의 영향으로 밝힐 수 없는 등대 쌍이 1쌍 존재한다면
				answer += 1; // 남은 1쌍의 등대 중 어떤 등대를 켜도 되기 때문에 1만 증가
				break;
			}
			
			if (remainingCnt < lighthouse.length) { // 현재 켜진 등대의 영향으로 밝힐 수 없는 등대 쌍의 수가 2 이상 lighthouse.length 미만이라면
				lighthouse = new int[remainingCnt][2]; // lighthouse의 길이 줄이기
				
				for (int i = 0; i < remainingCnt; i++) { // 현재 켜진 등대의 영향으로 밝힐 수 없는 등대 쌍만 고려하면 된다.
					lighthouse[i] = remainingLightHouse[i];
				}
			}
			
			// 다시 for문으로 가 과정 반복
		}
		
		answer += turnOnHs.size(); // 켜진 등대의 수를 더해준다.
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// CASE 1
		int n = 14;
		int[][] lighthouse = {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}, {10, 11}, {5, 12}, {12, 13}, {12, 14}};
		// CASE 2
//		int n = 10;
//		int[][] lighthouse = {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}};
		// CASE 3
//		int n = 8;
//		int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
		
		System.out.println(solution(n, lighthouse));
	}
}