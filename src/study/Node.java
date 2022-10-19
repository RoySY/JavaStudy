package study;

public class Node implements Comparable<Node> {
	
	private int index = 0; // ����� ��ȣ
	private int distance = 0; // ����� �Ÿ�
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}

	@Override
	public int compareTo(Node otherNode) {
		// TODO Auto-generated method stub
		return this.distance - otherNode.distance; // distance ���� �������� ���� // 1, 2, 3, ...
//		return otherNode.distance - this.distance; // distance ���� �������� ���� // ..., 3, 2, 1
	}

}
