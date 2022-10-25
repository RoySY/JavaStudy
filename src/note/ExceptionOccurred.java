package note;

public class ExceptionOccurred {
	
	// Checked Exception : RuntimeException을 상속받지 않은 클래스
	// Unchecked Exception : RuntimeException을 상속받은 클래스
	// throw : 강제로 예외를 발생시킬 수 있음 단, 발생시킨 예외를 catch문에서 잡을 수 있는 처리가 되어있지 않으면 오류 발생(catch문의 Exception은 모든 예외를 잡을 수 있음)
	// throws : 예외 발생 시 자신을 호출한 상위 메소드로 예외를 던짐(특정 상위 메소드에서 예외를 한 번에 처리하는 경우가 있을 수 있음, 계속 throws로 던질 경우 최종적으로 JVM이 처리를 하게 되지만, 권장하지 않음)
	// 중요 : RuntimeException을 상속받은 Unchecked Exception의 경우 throws는 아무 의미 없음, throws는 Checked Exception의 처리 방법 중 하나
	
	public void method1() throws Exception {
		// 이 메소드를 호출한 부분의 catch문에 Exception에 대한 에외 처리가 있어야 함
		throw new Exception("강제로 예외 발생"); // 모든 예외를 잡을 수 있는 Exception의 경우 throws Exception 필수
	}
	
	// RuntimeException을 상속받은 NullPointerException
	public void method2() {
		// 이 메소드를 호출한 부분의 catch문에 Exception 또는 NullPointerException에 대한 예외 처리가 있어야 함
		throw new NullPointerException("강제로 NullPointerException 발생"); // NullPointerException 발생
	}
	
	// RuntimeException을 상속받은 ArithmeticException
	public void method3() {
		// 이 메소드를 호출한 부분의 catch문에 Exception 또는 ArithmeticException에 대한 예외 처리가 있어야 함
		System.out.println(3 / 0); // ArithmeticException 발생
	}
	
	// RuntimeException을 상속받은 NullPointerException 발생이므로 throws는 아무 의미 없음
	public void method4() throws ArithmeticException {
		throw new NullPointerException("강제로 NullPointerException 발생"); // NullPointerException 발생
	}
	
	// RuntimeException을 상속받은 NullPointerException 발생이므로 throws는 아무 의미 없음
	public void method5() throws ArithmeticException {
		String name = null;
		System.out.println(name.length());
	}
	
	// ArithmeticException : 어떤 수를 0으로 나눌 때 발생(RuntimeException 상속)
	// NullPointerException : NULL 객체를 참조할 때 발생(RuntimeException 상속)
	// ClassCastException : 적절하지 못하게 클래스를 형 변환하는 경우 발생(RuntimeException 상속)
	// NegativeArraySizeException : 배열의 크기가 음수 값인 경우 발생(RuntimeException 상속)
	// IndexOutOfBoundsException : 리스트형 객체에서 선언되지 않은 요소를 가져오려고 할 때 발생(RuntimeException 상속)
}
