package com.yk.common;

/**
 * YBoard 암호화 유틸 
 * @author ykkim
 *
 */
public class YKStringUtil {
	
	private YKStringUtil() { }

	private static final String AES_KEY = "123456790ykb1234";
	
	/**
	 * AES로 암호화 (키값은 정해짐) : 복호화 가능 STRING
	 * 
	 * @param value
	 * @return
	 */
	public static String getTmsEncryptoAesForString(String str) {
		String result = "";
		try {
			if (str != null && !str.equals("")) {
				result = YKEncryptionUtil.encrypto(str, AES_KEY);
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	/**
	 * AES로 복호화 (키값은 정해짐) - STRING
	 * 
	 * @param value
	 * @return
	 */
	public static String getTmsDecryptoAesForString(String str) {
		String result = "";
		try {
			if (str != null && !str.equals("")) {
				result = YKEncryptionUtil.decrypto(str, AES_KEY);
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	/**
	 * AES로 암호화 (키값은 정해짐) : 복호화 가능 INT
	 * 
	 * @param value
	 * @return
	 */
	public static String getStringTmsEncryptoAesForInt(int itr) {
		String result = "";
		try {
			String str = Integer.toString(itr);
			if (str != null && !str.equals("")) {
				result = YKEncryptionUtil.encrypto(str, AES_KEY);
			}
		} catch (Exception e) {
			result = "-1";
		}
		return result;
	}

	/**
	 * AES로 복호화 (키값은 정해짐) - INT
	 * 
	 * @param value
	 * @return
	 */
	public static int getTmsDecryptoAesForInt(String str) {
		String result = "";
		try {
			if (str != null && !str.equals("")) {
				result = YKEncryptionUtil.decrypto(str, AES_KEY);
			}
		} catch (Exception e) {
			result = "-1";
		}
		return Integer.parseInt(result);
	}

	/**
	 * SHA256 형식으로 단방향 암호화 (복호화 불가)
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String getEncrypto(String str) {
		String result = "";
		try {
			if (str != null && !str.equals("")) {
				result = YKEncryptionUtil.encryptSHA256(str);
			}
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	/**
	 * <p>
	 * 문자열 교체
	 * 
	 * @param sourceStr
	 * @param findStr
	 * @param replaceStr
	 * @return
	 */
	public static String replace(String sourceStr, String findStr, String replaceStr) {
		if (sourceStr == null) {
			return "";
		}
		int i = 0;
		StringBuffer stringbuffer = new StringBuffer();
		for (int j = sourceStr.indexOf(findStr, i); j >= 0; j = sourceStr.indexOf(findStr, i)) {
			stringbuffer.append(sourceStr.substring(i, j));
			stringbuffer.append(replaceStr);
			i = j + findStr.length();
		}

		if (i <= sourceStr.length()) {
			stringbuffer.append(sourceStr.substring(i, sourceStr.length()));
		}
		return stringbuffer.toString();
	}

	/**
	 * 로그인 체크
	 * 
	 * @param sessionValue
	 * @return
	 */
	public static boolean checkLogin(String sessionValue) {
		boolean resultVal = true;
		if (sessionValue == null || sessionValue.equals("")) {
			resultVal = false;
		}
		return resultVal;
	}
}
