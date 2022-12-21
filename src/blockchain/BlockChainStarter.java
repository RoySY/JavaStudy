package blockchain;

import java.util.ArrayList;

public class BlockChainStarter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Block block1 = new Block(1, null, 0, new ArrayList<Transaction>());
		block1.mine();
		block1.getInformation();
		
		Block block2 = new Block(2, block1.getBlockHash(), 0, new ArrayList<Transaction>());
		block2.addTransaction(new Transaction("�̽¿�", "ȫ�浿", 1.5));
		block2.addTransaction(new Transaction("�̱���", "ȫ�浿", 0.7));
		block2.mine();
		block2.getInformation();
		
		Block block3 = new Block(3, block2.getBlockHash(), 0, new ArrayList<Transaction>());
		block3.addTransaction(new Transaction("������", "�ٴϿ�", 8.2));
		block3.addTransaction(new Transaction("ȫ�浿", "�̽¿�", 9.9));
		block3.mine();
		block3.getInformation();
		
		Block block4 = new Block(4, block3.getBlockHash(), 0, new ArrayList<Transaction>());
		block4.addTransaction(new Transaction("�ٴϿ�", "������", 0.1));
		block4.mine();
		block4.getInformation();
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		// STEP 1. �ؽ� �˰����� �Է� ���� ���ݸ� �ٲ� ����� ������ �ٸ� ���� ���´�. ä���� ������ �̷��� ������ ȿ������ ����Ѵ�.
//		System.out.println(Util.getHash("�̽¿�")); // 0c2bc0396e93dcc356680303162ced49c0fe2fed31ed1da7753113e413a2c06a
//		System.out.println(Util.getHash("�̽¿�1")); // 55868675c69c4009a2dc5baa44b5326f93429b587b10828a622de61bca097bd7
//		
//		// STEP 2. �۾� ����(Proof of Work) : ��Ʈ���ο��� ���ǰ� �ִ� ä�� ���
//		int nonce = 0;
//		
//		while(true) { // ä��
//			
//			// 16���� 6�ڸ� => 16 x 16 x 16 x 16 x 16 x 16 => 2�� 24��(���̵�)
//			if(Util.getHash(nonce + "").substring(0, 6).equals("000000")) { // ��� ���� nonce�� ���ڿ� ���·� �ٲ� �� �̰��� �ؽ� ���� "000000"���� ������ �� ä���� ����
//				System.out.println("���� : " + nonce); // 665782
//				System.out.println("�ؽ� �� : " + Util.getHash(nonce + "")); // 0000000399c6aea5ad0c709a9bc331a3ed6494702bd1d129d8c817a0257a1462
//				break;
//			}
//			
//			nonce++; // nonce 1�� ����
//		}
//		// �۾� �����̶�� ���� �˰����� ����ϴ� ���ü�� �ý����� ��ó�� �������� �Է°��� �����Ͽ� ����(nonce)�� ���ϴ� ������� ä���� �����ϵ��� ���谡 �Ǿ��ִ�.
//	}
}