package com.yk.common;

import static org.junit.Assert.*;

import org.junit.Test;

public class YKStringUtilTest {

	
	private  final String AES_KEY = "123456790ykb1234";
	
	/**
	 * AES로 암호화 (키값은 정해짐) : 복호화 가능 INT
	 * 
	 * @param value
	 * @return
	 */
	public  String getStringTmsEncryptoAesForInt(int itr) {
		String result = "";
		try {
			String str = Integer.toString(itr);
			if (str != null && !str.equals("")) {
				System.out.println("AES_KEY=="+AES_KEY);
				result = YKEncryptionUtil.encrypto(str, AES_KEY);
			}
		} catch (Exception e) {
			result = "-1";
		}
		return result;
	}
	
	/**
	 * AES로 암호화 (키값은 정해짐) : 복호화 가능 INT
	 * 
	 * @param value
	 * @return
	 */
	@Test
	public void test_getStringTmsEncryptoAesForInt() {
		System.out.println(getStringTmsEncryptoAesForInt(10));
	}

}
