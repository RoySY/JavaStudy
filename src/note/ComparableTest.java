package note;

import java.util.*;

public class ComparableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// --------------------------------------일반 배열--------------------------------------
		int[] arr1 = {2, 1, 6, 3, 7, 4, 5};
		
		for (int num : arr1) {
			System.out.print(num + " "); // 2 1 6 3 7 4 5 
		}
		
		System.out.println();
		// --------------------------------------배열 정렬--------------------------------------
		Arrays.sort(arr1); // 기본 오름차순 정렬
		
		for (int num : arr1) {
			System.out.print(num + " "); // 1 2 3 4 5 6 7 
		}
		
		System.out.println();
		// ------------------------Comparable 인터페이스를 구현한 Node 클래스------------------------
		ArrayList<Node> list = new ArrayList<>();
		
		// index, distance, name
		list.add(new Node(1, 2, "B"));
		list.add(new Node(2, 1, "A"));
		list.add(new Node(2, 2, "C"));
		list.add(new Node(1, 3, "F"));
		list.add(new Node(1, 3, "E"));
		list.add(new Node(1, 3, "D"));
		
		for (Node node : list) {
			System.out.print(node.getName() + " "); // "B", "A", "C", "F", "E", "D"
		}
		
		System.out.println();
		// -----------------------------------Node 클래스 정렬-----------------------------------
		Collections.sort(list); // Node 클래스의 정렬 기준 : ORDER BY distance, index, name
		
		for (Node node : list) {
			System.out.print(node.getName() + " "); // "A", "B", "C", "D", "E", "F"
		}
	}
}