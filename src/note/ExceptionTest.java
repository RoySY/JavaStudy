package note;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = null;
		
		ExceptionOccurred exceptionOccurred = new ExceptionOccurred();
		
		try {
			int nameLength = name.length(); // 1. NullPointerException에 걸리고 finally 실행
			int num = 3 / 0; // 2. 코드 1이 없다면 ArithmeticException에 걸리고 finally 실행
			exceptionOccurred.method2(); // 3. 코드 1, 2가 없다면 NullPointerException에 걸리고 finally 실행
			exceptionOccurred.method3(); // 4. 코드 1, 2, 3이 없다면 ArithmeticException에 걸리고 finally 실행
		} catch (NullPointerException e) {
			System.out.println("NullPointerException : " + e.getMessage());
		} catch (ArithmeticException e1) {
			System.out.println("ArithmeticException : " + e1.getMessage());
		} catch (Exception e) { // try문 실행에서 발생하는 예외 중 NullPointerException, ArithmeticException 외의 예외는 이곳에 걸림
			System.out.println("Exception : 모든 예외를 잡을 수 있음");
		} finally { // 무조건 실행시킬 코드를 적는 부분
			System.out.println("무조건 실행되는 부분");
		}
		
		try {	
			int nameLength = name.length(); // 1. Exception에 걸리고 finally 실행
			int num = 3 / 0; // 2. 코드 1이 없다면 Exception에 걸리고 finally 실행
			exceptionOccurred.method1(); // 3. 코드 1, 2가 없다면 Exception에 걸리고 finally 실행
			throw new Exception("강제 예외 발생"); // 4. 코드 1, 2, 3이 없다면 Exception에 걸리고 finally 실행
//			exceptionOccurred.method2(); // 5. 코드 1, 2, 3, 4가 없다면 Exception에 걸리고 finally 실행
//			exceptionOccurred.method3(); // 6. 코드 1, 2, 3, 4, 5가 없다면 Exception에 걸리고 finally 실행
		} catch (Exception e) { // try문 실행에서 발생하는 모든 예외를 잡을 수 있지만, 어떤 문제로 발생하는 예외인지 확인이 불가하다는 단점이 있다.
			System.out.println("Exception : 모든 예외를 잡을 수 있음");
		} finally { // 무조건 실행시킬 코드를 적는 부분
			System.out.println("무조건 실행되는 부분");
		}
	}
}