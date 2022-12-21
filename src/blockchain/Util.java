package blockchain;

import java.security.MessageDigest;

public class Util {
	
	public static String getHash(String input) { // 단순 문자열 input
		StringBuffer result = new StringBuffer();
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); // Secure Hash Algorithm // 256비트로 구성 // 64자리 문자열 반환
			md.update(input.getBytes());
			byte bytes[] = md.digest();
			
			for(int i = 0; i < bytes.length; i++) {
				result.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result.toString(); // SHA-256 해시를 적용한 결과 리턴
	}
}