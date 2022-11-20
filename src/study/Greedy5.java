package study;

public class Greedy5 {
	
	// �׸��� : ���ϱ� Ȥ�� ���ϱ�
	// �� �ڸ��� 0 ~ 9�θ� �̷���� ���ڿ� s�� �־��� �� ���ʺ��� ���������� ���ڸ� Ȯ���ϸ�
	// ���� ���̿� + Ȥ�� x �����ڸ� �־� ���� ū ���� ����� ���α׷��̴�.
	// ��� ������ �Ϲ����� ��İ� �޸� ������ ���ʺ��� ������� �̷�����ٰ� �� �� �ִ��� ���� ���϶�
	
	public static void solution(String s) {
		
		int val = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			int num = s.charAt(i) - '0';
			
			if (num <= 1 || val <= 1) {
				val += num;
			} else {
				val *= num;
			}
		}
		
		System.out.println(val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "02984";
		
		solution(s);
	}

}
