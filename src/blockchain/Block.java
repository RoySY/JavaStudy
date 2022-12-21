package blockchain;

import java.util.ArrayList;

public class Block {

	private int blockID; // 블록 아이디
	private String previousBlockHash; // 이전 블록의 해시 값
	private int nonce; // 채굴을 위한 정답
	private ArrayList<Transaction> transactionList; // 블록에 들어가는 데이터(해당 블록이 생성되기 전까지 발생한 신규 트랜잭션들의 정보)
	
	public Block(int blockID, String previousBlockHash, int nonce, ArrayList<Transaction> transactionList) {
		this.blockID = blockID;
		this.previousBlockHash = previousBlockHash;
		this.nonce = nonce;
		this.transactionList = transactionList;
	}
	
	public int getBlockID() {
		return blockID;
	}
	
	public void setBlockID(int blockID) {
		this.blockID = blockID;
	}
	
	public String getPreviousBlockHash() {
		return previousBlockHash;
	}

	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	
	public int getNonce() {
		return nonce;
	}
	
	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	
	public void addTransaction(Transaction transaction) {
		transactionList.add(transaction);
	}
	
	public String getBlockHash() { // 해당 블록의 해시 값
		String transactionInformations = "";
		
		for(int i = 0; i < transactionList.size(); i++) {
			transactionInformations += transactionList.get(i).getInformation();
		}
		
		return Util.getHash(nonce + transactionInformations + previousBlockHash);
	}
	
	public void getInformation() { // 특정한 한 개의 블록이 있을 때 이 블록에 대한 정보를 출력
		System.out.println("----------------------------------");
		System.out.println("블록 아이디 : " + getBlockID());
		System.out.println("이전 블록의 해시 값: " + getPreviousBlockHash());
		System.out.println("채굴 정답 : " + getNonce());
		System.out.println("트랜잭션 개수 : " + transactionList.size() + "개");
		
		for(int i = 0; i < transactionList.size(); i++) {
			System.out.println(transactionList.get(i).getInformation());
		}
		
		System.out.println("블록의 해시 값 : " + getBlockHash());
		System.out.println("----------------------------------");
	}
	
	public void mine() {
		while(true) {
			if(getBlockHash().substring(0, 4).equals("0000")) { // nonce + transactionInformations + previousBlockHash의 해시 값이 "0000"으로 시작할 때 채굴에 성공 // 채굴 난이도 고정
				System.out.println(blockID + "번째 블록의 채굴에 성공했습니다.");
				break;
			}
			nonce++;
		}
	}
}