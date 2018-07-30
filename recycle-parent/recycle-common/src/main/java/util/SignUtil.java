package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUtil {

	private static String token = "recycle";
	/**
	 * ��֤ǩ��
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce){
		String[] arr = new String[]{token, timestamp, nonce};
		//1.������Ҫ���������������ֵ�����
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++){
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;
		//2.�����������ַ���ƴ�ӳ�һ���ַ�������sha1����
		try{
			md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		content = null;
		return tmpStr !=null?tmpStr.equals(signature.toUpperCase()):false;
	}
	
	/**
	 * ���ֽ�����װ��Ϊʮ�������ַ���
	 * 
	 * @param byteArray
	 * @return
	 */
	public static String byteToStr(byte[] byteArray) {
		String strDigest ="";
		for(int i = 0; i < byteArray.length; i++){
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}
	
	public static String byteToHexStr(byte mByte) {
		char[] Digit = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D', 'E', 'F'};
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];
		
		String s = new String (tempArr);
		return s;
	}
}
