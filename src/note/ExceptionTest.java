package note;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = null;
		
		ExceptionOccurred exceptionOccurred = new ExceptionOccurred();
		
		try {
			int nameLength = name.length(); // 1. NullPointerException�� �ɸ��� finally ����
			int num = 3 / 0; // 2. �ڵ� 1�� ���ٸ� ArithmeticException�� �ɸ��� finally ����
			exceptionOccurred.method2(); // 3. �ڵ� 1, 2�� ���ٸ� NullPointerException�� �ɸ��� finally ����
			exceptionOccurred.method3(); // 4. �ڵ� 1, 2, 3�� ���ٸ� ArithmeticException�� �ɸ��� finally ����
		} catch (NullPointerException e) {
			System.out.println("NullPointerException : " + e.getMessage());
		} catch (ArithmeticException e1) {
			System.out.println("ArithmeticException : " + e1.getMessage());
		} catch (Exception e) { // try�� ���࿡�� �߻��ϴ� ���� �� NullPointerException, ArithmeticException ���� ���ܴ� �̰��� �ɸ�
			System.out.println("Exception : ��� ���ܸ� ���� �� ����");
		} finally { // ������ �����ų �ڵ带 ���� �κ�
			System.out.println("������ ����Ǵ� �κ�");
		}
		
		try {	
			int nameLength = name.length(); // 1. Exception�� �ɸ��� finally ����
			int num = 3 / 0; // 2. �ڵ� 1�� ���ٸ� Exception�� �ɸ��� finally ����
			exceptionOccurred.method1(); // 3. �ڵ� 1, 2�� ���ٸ� Exception�� �ɸ��� finally ����
			throw new Exception("���� ���� �߻�"); // 4. �ڵ� 1, 2, 3�� ���ٸ� Exception�� �ɸ��� finally ����
//			exceptionOccurred.method2(); // 5. �ڵ� 1, 2, 3, 4�� ���ٸ� Exception�� �ɸ��� finally ����
//			exceptionOccurred.method3(); // 6. �ڵ� 1, 2, 3, 4, 5�� ���ٸ� Exception�� �ɸ��� finally ����
		} catch (Exception e) { // try�� ���࿡�� �߻��ϴ� ��� ���ܸ� ���� �� ������, � ������ �߻��ϴ� �������� Ȯ���� �Ұ��ϴٴ� ������ �ִ�.
			System.out.println("Exception : ��� ���ܸ� ���� �� ����");
		} finally { // ������ �����ų �ڵ带 ���� �κ�
			System.out.println("������ ����Ǵ� �κ�");
		}
	}
}