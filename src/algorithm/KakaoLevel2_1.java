package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KakaoLevel2_1 {
	
	// ���� ��� ���
	
	public static int calcMin(String time1, String time2) {
		String[] time1Arr = time1.split(":");
		String[] time2Arr = time2.split(":");
		
		int min = (Integer.parseInt(time2Arr[0]) * 60 + Integer.parseInt(time2Arr[1])) - (Integer.parseInt(time1Arr[0]) * 60 + Integer.parseInt(time1Arr[1]));
		
		return min;
	}
	
	public static int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		String[] tempArr = new String[3];
        
		// ���� ��ȣ�� ��� ���� �ʿ�
		// 0000 : 06:00 IN, 06:34 OUT, 18:59 IN, 23:59 OUT // 34 + 300
		// 0148 : 07:59 IN, 19:09 OUT // 670
		// 5961 : 05:34 IN, 07:59 OUT, 22:59 IN, 23:00 OUT // 145 + 1
		// IN�� OUT�� ���� �ʿ����. ����� ¦�� �� �����ϴ� ���� �߿��ϸ�, �� ���������� ������ IN, OUT, IN, OUT �����̴�.
        
		HashMap<String, ArrayList<String>> hmlist = new HashMap<>();
		ArrayList<String> numberList = new ArrayList<>();
        
		for (int i = 0; i < records.length; i++) {
			tempArr = records[i].split(" "); // "06:00", "0000", "IN"
        	
			if (!hmlist.containsKey(tempArr[1])) { // "0000"
				hmlist.put(tempArr[1], new ArrayList<String>()); // key ��� // "0000"
        		
				numberList.add(tempArr[1]); // key���� ��Ƶ� ����Ʈ // "0000"
			}
        	
			hmlist.get(tempArr[1]).add(tempArr[0]); // "06:00"
		}
        
        // numberList�� ���� �ѹ� ����Ʈ �������
        
        Collections.sort(numberList); // key�� ����Ʈ �������� ����
        
        for (String str : numberList) { // 0000, 0148, 5961
        	
        	System.out.println(str);
        	
        	if (hmlist.get(str).size() % 2 == 1) { // ¦�� �ȸ´´ٸ�, �� ������ ���� ����� ���ٸ�
        		hmlist.get(str).add("23:59"); // ������ ���� ����� 23:59��
        	}
        }
        
        int[] totalTimeArr = {}; // ���� ��ȣ�� �� �ð� ��� ���� �迭
        
        totalTimeArr = new int[numberList.size()]; // �ð� ���� �迭 ũ��� ���� ��ȣ ����ŭ
        answer = new int[numberList.size()]; // �ݾ� ���� �迭 ũ��� ���� ��ȣ ����ŭ
        
        String[] tempTimeArr = new String[2]; // �ð� �� ���� �߶� ������ �ٲٱ� ���� �ӽ� �迭
        
        int j = 0; // ���� ��ȣ ����ŭ ������ų ����
        
        for (String str : numberList) {
        	
        	int i = 0; // �ð� �� ���� ��� ���� �ε��� i
        	int timeSum = 0;
        	
        	for (String time : hmlist.get(str)) {
        		tempTimeArr[i] = time; // 0, 1
        		i++;
        		
        		if (i == 2) { // 0, 1�� �Ѿ��
        			timeSum += calcMin(tempTimeArr[0], tempTimeArr[1]); // �� ��� �Լ�
        			i = 0; // �ð� �� ���� ���� ���� 0���� �ʱ�ȭ
        		}
        	}
        	
        	totalTimeArr[j] = timeSum; // �ش� ���� ��ȣ�� �� �ð�
        	j++; // 0 ~ 2
        }
        
        double d = 0;
        
        for (int i = 0; i < totalTimeArr.length; i++) {
        	
        	if (totalTimeArr[i] <= fees[0]) { // 180���� ���� �ʾҴٸ�
        		answer[i] = fees[1]; // 5000��
        	} else { // 180���� �ʰ��ߴٸ�
        		d = (double)(totalTimeArr[i] - fees[0]) / fees[2]; // �Ҽ��� �ø��� ���� double������ �ޱ�
        		answer[i] = (int)Math.ceil(d) * fees[3] + fees[1]; // �ʰ��� �ݾ� + 5000��
        	}
        }
        
        for (int i = 0; i <answer.length; i++) {
        	System.out.println(answer[i]);
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fees = {180, 5000, 10, 600}; // �⺻�ð�(��), �⺻���(��), �����ð�(��), �������(��)
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}; // ��:�� �� ��ȣ IN/OUT // ������ ���� ��� ������ 23:59 ���� ������ ����
		
		System.out.println(solution(fees, records)); // 14600, 34400, 5000
	}

}
