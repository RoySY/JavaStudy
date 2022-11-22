package study;

public class Sample {
	String name;
	
	public Sample(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		Sample otherTest = (Sample) obj;
		return (this.name.equals(otherTest.name));
	}
	
	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = 31 * hashCode + ((name == null) ? 0 : name.hashCode());
		return hashCode;
	}
}