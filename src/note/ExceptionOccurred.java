package note;

public class ExceptionOccurred {
	
	// Checked Exception : RuntimeException�� ��ӹ��� ���� Ŭ����
	// Unchecked Exception : RuntimeException�� ��ӹ��� Ŭ����
	// throw : ������ ���ܸ� �߻���ų �� ���� ��, �߻���Ų ���ܸ� catch������ ���� �� �ִ� ó���� �Ǿ����� ������ ���� �߻�(catch���� Exception�� ��� ���ܸ� ���� �� ����)
	// throws : ���� �߻� �� �ڽ��� ȣ���� ���� �޼ҵ�� ���ܸ� ����(Ư�� ���� �޼ҵ忡�� ���ܸ� �� ���� ó���ϴ� ��찡 ���� �� ����, ��� throws�� ���� ��� ���������� JVM�� ó���� �ϰ� ������, �������� ����)
	// �߿� : RuntimeException�� ��ӹ��� Unchecked Exception�� ��� throws�� �ƹ� �ǹ� ����, throws�� Checked Exception�� ó�� ��� �� �ϳ�
	
	public void method1() throws Exception {
		// �� �޼ҵ带 ȣ���� �κ��� catch���� Exception�� ���� ���� ó���� �־�� ��
		throw new Exception("������ ���� �߻�"); // ��� ���ܸ� ���� �� �ִ� Exception�� ��� throws Exception �ʼ�
	}
	
	// RuntimeException�� ��ӹ��� NullPointerException
	public void method2() {
		// �� �޼ҵ带 ȣ���� �κ��� catch���� Exception �Ǵ� NullPointerException�� ���� ���� ó���� �־�� ��
		throw new NullPointerException("������ NullPointerException �߻�"); // NullPointerException �߻�
	}
	
	// RuntimeException�� ��ӹ��� ArithmeticException
	public void method3() {
		// �� �޼ҵ带 ȣ���� �κ��� catch���� Exception �Ǵ� ArithmeticException�� ���� ���� ó���� �־�� ��
		System.out.println(3 / 0); // ArithmeticException �߻�
	}
	
	// RuntimeException�� ��ӹ��� NullPointerException �߻��̹Ƿ� throws�� �ƹ� �ǹ� ����
	public void method4() throws ArithmeticException {
		throw new NullPointerException("������ NullPointerException �߻�"); // NullPointerException �߻�
	}
	
	// RuntimeException�� ��ӹ��� NullPointerException �߻��̹Ƿ� throws�� �ƹ� �ǹ� ����
	public void method5() throws ArithmeticException {
		String name = null;
		System.out.println(name.length());
	}
	
	// ArithmeticException : � ���� 0���� ���� �� �߻�(RuntimeException ���)
	// NullPointerException : NULL ��ü�� ������ �� �߻�(RuntimeException ���)
	// ClassCastException : �������� ���ϰ� Ŭ������ �� ��ȯ�ϴ� ��� �߻�(RuntimeException ���)
	// NegativeArraySizeException : �迭�� ũ�Ⱑ ���� ���� ��� �߻�(RuntimeException ���)
	// IndexOutOfBoundsException : ����Ʈ�� ��ü���� ������� ���� ��Ҹ� ���������� �� �� �߻�(RuntimeException ���)
}
