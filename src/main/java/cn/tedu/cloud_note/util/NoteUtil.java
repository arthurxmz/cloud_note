package cn.tedu.cloud_note.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.MessageDigest;
import java.util.UUID;

public class NoteUtil {
	
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	/**
	 * 将传入的src加密处理
	 * @param str 明文字符串
	 * @return 加密后的字符串结果
	 * @throws Exception 
	 */
	public static String md5(String str)  {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] input = str.getBytes();
			byte[] output = md.digest(input);

			// ����base64�㷨���ֽ�����ת��Ϊ�ַ���
			String ret = Base64.encode(output);
			return ret;
		} catch (Exception e) {
			throw new NoteException("代码异常", e);
		}
	}

	public static void main(String[] args) throws Exception{
//		System.out.println(md5("123456"));
//		System.out.println(md5("12354654676dfdfdfdf"));
		System.out.println(createId());
		System.out.println(md5(createId()));
	}
	
}
