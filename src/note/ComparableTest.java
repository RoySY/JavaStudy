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
		
		list.add(new Node(2, 2));
		list.add(new Node(1, 1));
		list.add(new Node(3, 3));
		
		for (Node node : list) {
			System.out.print(node.getDistance() + " "); // 2, 1, 3
		}
		
		System.out.println();
		// -----------------------------------Node Ŭ���� ����-----------------------------------
		Collections.sort(list);
		
		for (Node node : list) {
			System.out.print(node.getDistance() + " "); // 1, 2, 3
		}
	}

}
