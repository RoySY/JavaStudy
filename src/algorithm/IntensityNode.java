package algorithm;

public class IntensityNode implements Comparable<IntensityNode> {
	
	private int index = 0; // ����ڽ� ��ȣ
	private int intensity = 0; // ����ڽ� �ð�
	
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
		return this.intensity - otherIntensityNode.intensity; // intensity ���� �������� ����
	}
}
