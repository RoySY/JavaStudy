package note;

import java.util.*;

public class ComparableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// --------------------------------------�Ϲ� �迭--------------------------------------
		int[] arr1 = {2, 1, 6, 3, 7, 4, 5};
		
		for (int num : arr1) {
			System.out.print(num + " "); // 2 1 6 3 7 4 5 
		}
		
		System.out.println();
		// --------------------------------------�迭 ����--------------------------------------
		Arrays.sort(arr1); // �⺻ �������� ����
		
		for (int num : arr1) {
			System.out.print(num + " "); // 1 2 3 4 5 6 7 
		}
		
		System.out.println();
		// ------------------------Comparable �������̽��� ������ Node Ŭ����------------------------
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
		// -----------------------------------Node Ŭ���� ����-----------------------------------
		Collections.sort(list); // Node Ŭ������ ���� ���� : ORDER BY distance, index, name
		
		for (Node node : list) {
			System.out.print(node.getName() + " "); // "A", "B", "C", "D", "E", "F"
		}
	}
}