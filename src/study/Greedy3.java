package study;
import java.util.Scanner;

public class Greedy3 {
	
	// [그리디 알고리즘]
	// 문제1. 상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
	// 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
	// 상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만,
	// 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
	// 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cnt = 0; // 설탕 kg
		int result = 0; // 포대 수
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("설탕 kg수를 입력하세요 : "); // 5kg과 3kg의 포대가 있으며 포대 수를 최소화하려고 한다.
		cnt = scan.nextInt();
		
		int a = (cnt / 5); // 최초 입력한 설탕을 5로 나눈 몫 // 여기서 a를 1씩 줄여나갈 거야
		int b = (cnt % 5); // 최초 입력한 설탕을 5로 나눈 나머지 // 여기서 b를 5씩 늘려나갈 거야
		
		int tempNum = 0;
		
		for (int i = a; i >= 0; i--) { // a를 최대치에서부터 1씩 줄여나감
			tempNum = b + (5 * (a - i)); // a가 1씩 줄어들 때마다 나머지는 5씩 더해짐
			
			if ((tempNum % 3) == 0) { // 더해진 나머지를 3으로 나눈 나머지가 0이라면(나누어 떨어진다면)
				result = i + (tempNum / 3); // 5로 나눈 몫 i + 3으로 나눈 몫 (tempNum / 3)
			}
			
			if (result != 0) { // result 값이 변했다면
				break;
			}
		}
		
		if (result == 0) { // result 값이 변하지 않았다면(나누어 떨어지지 않았다면)
			result = -1;
		}
		
		System.out.print("최소 설탕 포대 수는 : " + result);
	}
}
