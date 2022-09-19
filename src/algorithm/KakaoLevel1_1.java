package algorithm;

import java.util.*;

public class KakaoLevel1_1 {
	
	//	���� ���� �˻��ϱ�
	//	1�� ��ǥ ���̾���(R), Ʃ����(T)
	//	2�� ��ǥ ����(C), ���ε���(F)
	//	3�� ��ǥ ��������(J), ������(M)
	//	4�� ��ǥ ����ġ��(A), �׿���(N)
		
	//	1 �ſ� ���� (3)
	//	2 ���� (2)
	//	3 �ణ ���� (1)
	//	4 �𸣰���
	//	5 �ణ ���� (1)
	//	6 ���� (2)
	//	7 �ſ� ���� (3)
	
	static String[] typeArr = {"RT", "CF", "JM", "AN"};
	
	public static String typeCheck(HashMap<Character, Integer> hm) {
		
		StringBuilder sb = new StringBuilder();
		
		char firstChar;
		char secondChar;
		char typeChar;
		
		for (String s : typeArr) { // "RT", "CF", "JM", "AN"
			
			firstChar = s.charAt(0); // 'R', 'C', 'J', 'A'
			secondChar = s.charAt(1);// 'T', 'F', 'M', 'N'
			
			typeChar = hm.get(firstChar) >= hm.get(secondChar) ? firstChar : secondChar;
			
			sb.append(typeChar); // 'T' + 'C' + 'M' + 'A'
		}
		
		return sb.toString(); // "TCMA"
	}
	
	public static String solution(String[] survey, int[] choices) {
		String answer = "";
		int[] score = {0, 3, 2, 1, 0, -1, -2, -3}; // choices ���� ���� ���� �ο�
		
		HashMap<Character, Integer> hm = new HashMap<>(); // Ÿ��, ���� ���� HashMap
		
		int scoreSum = 0; // Ÿ�Ժ� ������ ���� ����
		
		for (String s : typeArr) { // "RT", "CF", "JM", "AN"
			hm.put(s.charAt(0), 0); // 'R' : 0, 'C' : 0, 'J' : 0 ,'A' : 0
			hm.put(s.charAt(1), 0); // 'T' : 0, 'F' : 0, 'M' : 0 ,'N' : 0
		}
		
		for (int i = 0; i < survey.length; i++) { // "AN", "CF", "MJ", "RT", "NA"
			// 'A' ���ھ� // 'C' ���ھ� // 'M' ���ھ� // 'R' ���ھ� // 'N' ���ھ� ������Ʈ
			scoreSum = hm.get(survey[i].charAt(0)) + score[choices[i]];
			hm.put(survey[i].charAt(0), scoreSum);
		}
		
		// 'R' : -3, 'C' : 1, 'J' : 0 ,'A' : -1
		// 'T' :  0, 'F' : 0, 'M' : 2 ,'N' : -1
		answer = typeCheck(hm);
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"}; // survey ������ ù ���ڸ� �������� ������ �ο��� ���̹Ƿ� score = {0, 3, 2, 1, 0, -1, -2, -3}���� ����
		int[] choices = {5, 3, 2, 7, 5}; // A : += score[5] // C : += score[3] // M : += score[2] // R : += score[7] // N : += score[5]
		
		System.out.println(solution(survey, choices));
	}

}
