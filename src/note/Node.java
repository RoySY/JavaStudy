package note;

public class Node implements Comparable<Node> {
	
	private int index = 0; // 노드의 번호
	private int distance = 0; // 노드의 거리
	private String name = ""; // 노드의 이름
	
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
		// private 변수이지만 클래스 내부에선 getDistance()로 가져올 필요 없이 직접 가져와도 됨
//		return this.distance - otherNode.distance; // distance 기준 오름차순 정렬 // 1, 2, 3, ...
//		return this.getDistance() - otherNode.getDistance(); // distance 기준 오름차순 정렬 // 1, 2, 3, ...
//		return otherNode.distance - this.distance; // distance 기준 내림차순 정렬 // ..., 3, 2, 1
//		return otherNode.getDistance() - this.getDistance(); // distance 기준 내림차순 정렬 // ..., 3, 2, 1
		
		// distance, index, name 기준 오름차순 정렬(ORDER BY distance, index, name)
		if (this.distance == otherNode.distance) { // distance가 같을 경우
			
			if (this.index == otherNode.index) { // index가 같을 경우
				return this.name.compareTo(otherNode.name); // name 기준 오름차순 정렬
//				return otherNode.name.compareTo(this.name); // name 기준 내림차순 정렬
			} else { // index가 같지 않을 경우
				return this.index - otherNode.index; // index 기준 오름차순 정렬
//				return otherNode.index - this.index; // index 기준 내림차순 정렬
			}
		} else { // distance가 같지 않을 경우
			return this.distance - otherNode.distance; // distance 기준 오름차순 정렬
//			return otherNode.distance - this.distance; // distance 기준 내림차순 정렬
		}
//		------------------------------------------------------------------------------------------------------
//		// distance 값을 기준으로 오름차순 정렬을 시키는 다른 방법 1, 2, 3, ...
//		if (this.distance < otherNode.distance) {
//			return -1; // 해당 노드의 거리가 비교대상 노드의 거리보다 작다면 => 해당 노드가 더 작다 리턴
//		}
//		
//		return 1; // 해당 노드의 거리가 비교대상 노드의 거리보다 크거나 같다면 => 해당 노드가 더 크다 리턴
//		
//		// distance 값을 기준으로 내림차순 정렬을 시키는 다른 방법 ..., 3, 2, 1
//		if (this.distance < otherNode.distance) {
//			return 1; // 해당 노드의 거리가 비교대상 노드의 거리보다 작다면 => 해당 노드가 더 크다 리턴
//		}
//		
//		return -1; // 해당 노드의 거리가 비교대상 노드의 거리보다 크거나 같다면 => 해당 노드가 더 작다 리턴
//		
//		// 숫자의 비교 : 1(크다), 0(같다), -1(작다)
//		// 문자열 비교 : 0(같다), 다양한 양수/음수 값 : 대상 문자열의 제일 앞 부분부터 비교하여 비교대상 문자열을 포함한다면 문자열 길이 차만큼 리턴, 하지만 아예 포함하지 않거나, 중간에 포함한다면 각 문자열의 제일 앞 아스키 코드값의 차를 리턴(대상 문자열 첫 문자 아스키코드 값 - 비교대상 문자열 첫 문자 아스키코드 값)
//		------------------------------------------------------------------------------------------------------
	}
}