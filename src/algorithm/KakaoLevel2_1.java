package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KakaoLevel2_1 {
	
	// 주차 요금 계산
	
	public static int calcMin(String time1, String time2) {
		String[] time1Arr = time1.split(":");
		String[] time2Arr = time2.split(":");
		
		int min = (Integer.parseInt(time2Arr[0]) * 60 + Integer.parseInt(time2Arr[1])) - (Integer.parseInt(time1Arr[0]) * 60 + Integer.parseInt(time1Arr[1]));
		
		return min;
	}
	
	public static int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		String[] tempArr = new String[3];
        
		// 차량 번호로 기록 구분 필요
		// 0000 : 06:00 IN, 06:34 OUT, 18:59 IN, 23:59 OUT // 34 + 300
		// 0148 : 07:59 IN, 19:09 OUT // 670
		// 5961 : 05:34 IN, 07:59 OUT, 22:59 IN, 23:00 OUT // 145 + 1
		// IN과 OUT은 담을 필요없다. 기록이 짝수 개 존재하는 것이 중요하며, 이 문제에서는 무조건 IN, OUT, IN, OUT 순서이다.
        
		HashMap<String, ArrayList<String>> hmlist = new HashMap<>();
		ArrayList<String> numberList = new ArrayList<>();
        
		for (int i = 0; i < records.length; i++) {
			tempArr = records[i].split(" "); // "06:00", "0000", "IN"
        	
			if (!hmlist.containsKey(tempArr[1])) { // "0000"
				hmlist.put(tempArr[1], new ArrayList<String>()); // key 등록 // "0000"
        		
				numberList.add(tempArr[1]); // key값만 담아둘 리스트 // "0000"
			}
        	
			hmlist.get(tempArr[1]).add(tempArr[0]); // "06:00"
		}
        
        // numberList에 현재 넘버 리스트 담겨있음
        
        Collections.sort(numberList); // key값 리스트 오름차순 정렬
        
        for (String str : numberList) { // 0000, 0148, 5961
        	
        	System.out.println(str);
        	
        	if (hmlist.get(str).size() % 2 == 1) { // 짝이 안맞는다면, 즉 마지막 출차 기록이 없다면
        		hmlist.get(str).add("23:59"); // 마지막 출차 기록은 23:59로
        	}
        }
        
        int[] totalTimeArr = {}; // 차량 번호별 총 시간 담기 위한 배열
        
        totalTimeArr = new int[numberList.size()]; // 시간 담을 배열 크기는 차량 번호 수만큼
        answer = new int[numberList.size()]; // 금액 담을 배열 크기는 차량 번호 수만큼
        
        String[] tempTimeArr = new String[2]; // 시간 두 개씩 잘라서 분으로 바꾸기 위한 임시 배열
        
        int j = 0; // 차량 번호 수만큼 증가시킬 변수
        
        for (String str : numberList) {
        	
        	int i = 0; // 시간 두 개를 담기 위한 인덱스 i
        	int timeSum = 0;
        	
        	for (String time : hmlist.get(str)) {
        		tempTimeArr[i] = time; // 0, 1
        		i++;
        		
        		if (i == 2) { // 0, 1을 넘어가면
        			timeSum += calcMin(tempTimeArr[0], tempTimeArr[1]); // 분 계산 함수
        			i = 0; // 시간 두 개씩 끊기 위해 0으로 초기화
        		}
        	}
        	
        	totalTimeArr[j] = timeSum; // 해당 차량 번호의 총 시간
        	j++; // 0 ~ 2
        }
        
        double d = 0;
        
        for (int i = 0; i < totalTimeArr.length; i++) {
        	
        	if (totalTimeArr[i] <= fees[0]) { // 180분을 넘지 않았다면
        		answer[i] = fees[1]; // 5000원
        	} else { // 180분을 초과했다면
        		d = (double)(totalTimeArr[i] - fees[0]) / fees[2]; // 소수점 올림을 위해 double형으로 받기
        		answer[i] = (int)Math.ceil(d) * fees[3] + fees[1]; // 초과한 금액 + 5000원
        	}
        }
        
        for (int i = 0; i <answer.length; i++) {
        	System.out.println(answer[i]);
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fees = {180, 5000, 10, 600}; // 기본시간(분), 기본요금(원), 단위시간(분), 단위요금(원)
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}; // 시:분 차 번호 IN/OUT // 마지막 나간 기록 없으면 23:59 나간 것으로 간주
		
		System.out.println(solution(fees, records)); // 14600, 34400, 5000
	}

}
