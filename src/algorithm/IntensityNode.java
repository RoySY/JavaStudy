package algorithm;

public class IntensityNode implements Comparable<IntensityNode> {
	
	private int index = 0; // 등산코스 번호
	private int intensity = 0; // 등산코스 시간
	
	public IntensityNode(int index, int intensity) {
		this.index = index;
		this.intensity = intensity;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getIntensity() {
		return this.intensity;
	}

	@Override
	public int compareTo(IntensityNode otherIntensityNode) {
		// TODO Auto-generated method stub
		return this.intensity - otherIntensityNode.intensity; // intensity 기준 오름차순 정렬
	}
}
