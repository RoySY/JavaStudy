package blockchain;

import java.util.ArrayList;

public class BlockChainStarter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Block block1 = new Block(1, null, 0, new ArrayList<Transaction>());
		block1.mine();
		block1.getInformation();
		
		Block block2 = new Block(2, block1.getBlockHash(), 0, new ArrayList<Transaction>());
		block2.addTransaction(new Transaction("이승엽", "홍길동", 1.5));
		block2.addTransaction(new Transaction("이근혁", "홍길동", 0.7));
		block2.mine();
		block2.getInformation();
		
		Block block3 = new Block(3, block2.getBlockHash(), 0, new ArrayList<Transaction>());
		block3.addTransaction(new Transaction("리로이", "다니엘", 8.2));
		block3.addTransaction(new Transaction("홍길동", "이승엽", 9.9));
		block3.mine();
		block3.getInformation();
		
		Block block4 = new Block(4, block3.getBlockHash(), 0, new ArrayList<Transaction>());
		block4.addTransaction(new Transaction("다니엘", "리로이", 0.1));
		block4.mine();
		block4.getInformation();
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		// STEP 1. 해시 알고리즘은 입력 값이 조금만 바뀌어도 결과는 완전히 다른 값이 나온다. 채굴의 원리는 이러한 눈사태 효과에서 출발한다.
//		System.out.println(Util.getHash("이승엽")); // 0c2bc0396e93dcc356680303162ced49c0fe2fed31ed1da7753113e413a2c06a
//		System.out.println(Util.getHash("이승엽1")); // 55868675c69c4009a2dc5baa44b5326f93429b587b10828a622de61bca097bd7
//		
//		// STEP 2. 작업 증명(Proof of Work) : 비트코인에서 사용되고 있는 채굴 방식
//		int nonce = 0;
//		
//		while(true) { // 채굴
//			
//			// 16진수 6자리 => 16 x 16 x 16 x 16 x 16 x 16 => 2의 24승(난이도)
//			if(Util.getHash(nonce + "").substring(0, 6).equals("000000")) { // 어떠한 숫자 nonce를 문자열 형태로 바꾼 후 이것의 해시 값이 "000000"으로 시작할 때 채굴에 성공
//				System.out.println("정답 : " + nonce); // 665782
//				System.out.println("해시 값 : " + Util.getHash(nonce + "")); // 0000000399c6aea5ad0c709a9bc331a3ed6494702bd1d129d8c817a0257a1462
//				break;
//			}
//			
//			nonce++; // nonce 1씩 증가
//		}
//		// 작업 증명이라는 합의 알고리즘을 사용하는 블록체인 시스템은 이처럼 무작위의 입력값을 대입하여 정답(nonce)을 구하는 방식으로 채굴이 가능하도록 설계가 되어있다.
//	}
}