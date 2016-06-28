package com.weichat.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * 类名：EncryptUtils
 * 功能：文本加密和解密的工具类
 * 详细：MD5签名算法、AES签名
 * 版本：1.0
 * 日期：2014-08-18
 * 说明：
 * 以下代码只是为了方便测试而提供的样例代码，企业可以根据自己系统的需要，按照技术文档编写,并非一定要使用该代码。
 * 该代码仅供学习和研究微洽接口使用，只是提供一个参考。
 *
 */
public class EncryptUtils {

	/**
	 * MD5算法加密字符串
	 * 
	 * @param originalString
	 *            需要加密的字符串
	 * @return 加密之后的字符串(16进制格式)
	 **/
	public static String md5Encrypt(String originalString) {
		if (StringUtils.isEmpty(originalString))
			throw new IllegalArgumentException("this originalString must not be empty");

		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(originalString.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		final byte[] encrypted = messageDigest.digest();
		return toHexString(encrypted);
	}

	public static String md5Encrypt(String secretKey, String originalString) {
		return md5Encrypt(originalString + secretKey);
	}

	/**
	 * AES算法加密文本
	 * 
	 * @param secretKey 		密钥
	 * @param originalString 	需要加密的文本
	 * @return 				加密的文本(Base64格式)
	 * 
	 **/
	public static String aesEncrypt(String secretKey, String originalString) {
		if (StringUtils.isEmpty(secretKey))
			throw new IllegalArgumentException("this secretKey must not be empty");
		
		if (StringUtils.isEmpty(originalString))
			throw new IllegalArgumentException("this originalString must not be empty");

		final byte[] byteKey = toByteArray(secretKey);
		SecretKeySpec skeySpec = new SecretKeySpec(byteKey, "AES");
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] originalBytes = originalString.trim().getBytes("UTF-8");
			if (originalBytes.length % 16 != 0) {
				byte[] newOriginalBytes = new byte[(originalBytes.length / 16 + 1) * 16];
				System.arraycopy(originalBytes, 0, newOriginalBytes, 0, originalBytes.length);
				originalBytes = newOriginalBytes;
			}

			final byte[] encryptedBytes = cipher.doFinal(originalBytes);
			return new String(Base64.encodeBase64(encryptedBytes));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			throw new IllegalArgumentException(secretKey + " is illegal," + e.getMessage());
		} catch (IllegalBlockSizeException e) {
			throw new IllegalArgumentException("unable to encrypt '" + originalString + "'," + e.getMessage());
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * AES算法解密文本
	 * 
	 * @param secretKey
	 *            密钥
	 * @param encryptedString
	 *            被加密的文本(Base64格式)
	 * 
	 * @return 还原回原先的文本
	 **/
	public static String aesDecrypt(String secretKey, String encryptedString) {
		if (StringUtils.isEmpty(secretKey))
			throw new IllegalArgumentException("this secretKey must not be empty");
		if (StringUtils.isEmpty(encryptedString))
			throw new IllegalArgumentException("this encryptedString must not be empty");

		encryptedString = encryptedString.trim();
		final byte[] byteKey = toByteArray(secretKey);
		SecretKeySpec skeySpec = new SecretKeySpec(byteKey, "AES");
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			final byte[] encryptBytes = Base64.decodeBase64(encryptedString.getBytes("UTF-8"));
			final byte[] originalBytes = cipher.doFinal(encryptBytes);
			return new String(originalBytes, "UTF-8").trim();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			throw new IllegalArgumentException(secretKey + " is illegal," + e.getMessage());
		} catch (IllegalBlockSizeException e) {
			throw new IllegalArgumentException("unable to process decrypt '" + encryptedString + "'," + e.getMessage());
		} catch (BadPaddingException e) {
			throw new IllegalArgumentException(encryptedString + " is invalid decrypted data," + e.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 16进制的字符串表示转成字节数组
	 * 
	 * @param hexString
	 *            16进制格式的字符串
	 * @return 转换后的字节数组
	 **/
	public static byte[] toByteArray(String hexString) {
		if (StringUtils.isEmpty(hexString))
			throw new IllegalArgumentException("this hexString must not be empty");

		hexString = hexString.toLowerCase();
		final byte[] byteArray = new byte[hexString.length() / 2];
		int k = 0;
		for (int i = 0; i < byteArray.length; i++) {
			byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
			byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
			byteArray[i] = (byte) (high << 4 | low);
			k += 2;
		}
		return byteArray;
	}

	/**
	 * 字节数组转成16进制表示格式的字符串
	 * 
	 * @param byteArray
	 *            需要转换的字节数组
	 * @return 16进制表示格式的字符串
	 **/
	public static String toHexString(byte[] byteArray) {
		if (byteArray == null || byteArray.length < 1)
			throw new IllegalArgumentException("this byteArray must not be null or empty");

		final StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < byteArray.length; i++) {
			if ((byteArray[i] & 0xff) < 0x10)
				hexString.append("0");
			hexString.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return hexString.toString().toLowerCase();
	}

	/**
	 * 随机生成指定长度的密钥
	 * 
	 * @param keySize
	 *            密钥长度，位数， 128, 192 or 256三个里选一个
	 * @return 生成的密钥
	 **/
	public static String generateSecretKey(int keySize) {
		if (keySize <= 0)
			throw new IllegalArgumentException("this keySize > 0");

		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(keySize);
			return toHexString(keyGenerator.generateKey().getEncoded());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 随机生成一个位数是128的密钥
	 * 
	 * @return 生成的密钥
	 **/
	public static String generateSecretKey() {
		return generateSecretKey(128);
	}

	public static void main(String[] args) {
		String encryptText = aesEncrypt("653fb16cce53f1b2bef0450a34e42f49", "{\"cono\":4,\"employees\":[{\"name\":\"wangping\",\"accountType\":1,\"account\":\"13688022801\",\"mobile\":\"\",\"email\":\"wp@weqia.com\",\"sex\":1,\"department\":\"\",\"position\":\"kaifa\",\"status\":1},{\"name\":\"zhangsan\",\"accountType\":1,\"account\":\"13688022802\",\"mobile\":\"\",\"email\":\"zs@weqia.com\",\"sex\":1,\"department\":\"\",\"position\":\"ceshi\",\"status\":1}]}");
		System.out.println(encryptText);
		System.out.println(aesDecrypt("653fb16cce53f1b2bef0450a34e42f49", encryptText));

	}
}
