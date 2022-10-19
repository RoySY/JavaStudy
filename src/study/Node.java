package study;

public class Node implements Comparable<Node> {
	
	private int index = 0; // 노드의 번호
	private int distance = 0; // 노드의 거리
	
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
		return this.distance - otherNode.distance; // distance 기준 오름차순 정렬 // 1, 2, 3, ...
//		return otherNode.distance - this.distance; // distance 기준 내림차순 정렬 // ..., 3, 2, 1
	}

}
