package note;

public class Node implements Comparable<Node> {
	
	private int index = 0; // ����� ��ȣ
	private int distance = 0; // ����� �Ÿ�
	private String name = ""; // ����� �̸�
	
	public Node(int index, int distance, String name) {
		this.index = index;
		this.distance = distance;
		this.name = name;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Node otherNode) {
		// TODO Auto-generated method stub
		// private ���������� Ŭ���� ���ο��� getDistance()�� ������ �ʿ� ���� ���� �����͵� ��
//		return this.distance - otherNode.distance; // distance ���� �������� ���� // 1, 2, 3, ...
//		return this.getDistance() - otherNode.getDistance(); // distance ���� �������� ���� // 1, 2, 3, ...
//		return otherNode.distance - this.distance; // distance ���� �������� ���� // ..., 3, 2, 1
//		return otherNode.getDistance() - this.getDistance(); // distance ���� �������� ���� // ..., 3, 2, 1
		
		// distance, index, name ���� �������� ����(ORDER BY distance, index, name)
		if (this.distance == otherNode.distance) { // distance�� ���� ���
			
			if (this.index == otherNode.index) { // index�� ���� ���
				return this.name.compareTo(otherNode.name); // name ���� �������� ����
//				return otherNode.name.compareTo(this.name); // name ���� �������� ����
			} else { // index�� ���� ���� ���
				return this.index - otherNode.index; // index ���� �������� ����
//				return otherNode.index - this.index; // index ���� �������� ����
			}
		} else { // distance�� ���� ���� ���
			return this.distance - otherNode.distance; // distance ���� �������� ����
//			return otherNode.distance - this.distance; // distance ���� �������� ����
		}
//		------------------------------------------------------------------------------------------------------
//		// distance ���� �������� �������� ������ ��Ű�� �ٸ� ��� 1, 2, 3, ...
//		if (this.distance < otherNode.distance) {
//			return -1; // �ش� ����� �Ÿ��� �񱳴�� ����� �Ÿ����� �۴ٸ� => �ش� ��尡 �� �۴� ����
//		}
//		
//		return 1; // �ش� ����� �Ÿ��� �񱳴�� ����� �Ÿ����� ũ�ų� ���ٸ� => �ش� ��尡 �� ũ�� ����
//		
//		// distance ���� �������� �������� ������ ��Ű�� �ٸ� ��� ..., 3, 2, 1
//		if (this.distance < otherNode.distance) {
//			return 1; // �ش� ����� �Ÿ��� �񱳴�� ����� �Ÿ����� �۴ٸ� => �ش� ��尡 �� ũ�� ����
//		}
//		
//		return -1; // �ش� ����� �Ÿ��� �񱳴�� ����� �Ÿ����� ũ�ų� ���ٸ� => �ش� ��尡 �� �۴� ����
//		
//		// ������ �� : 1(ũ��), 0(����), -1(�۴�)
//		// ���ڿ� �� : 0(����), �پ��� ���/���� �� : ��� ���ڿ��� ���� �� �κк��� ���Ͽ� �񱳴�� ���ڿ��� �����Ѵٸ� ���ڿ� ���� ����ŭ ����, ������ �ƿ� �������� �ʰų�, �߰��� �����Ѵٸ� �� ���ڿ��� ���� �� �ƽ�Ű �ڵ尪�� ���� ����(��� ���ڿ� ù ���� �ƽ�Ű�ڵ� �� - �񱳴�� ���ڿ� ù ���� �ƽ�Ű�ڵ� ��)
//		------------------------------------------------------------------------------------------------------
	}
}