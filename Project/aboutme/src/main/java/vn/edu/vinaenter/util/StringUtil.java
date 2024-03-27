package vn.edu.vinaenter.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class StringUtil {
	  public static String md5(String str) {
		  MessageDigest md;
		  String result = "";
		  try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			BigInteger bi = new BigInteger(1,md.digest());
			result = bi.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return result;
	  } 
		public static void main(String[] args) {
			String pass = md5("123456");
			System.out.println(pass);
			String pass1 = md5("123456");
			System.out.println(pass1);
			
		}
}

