package AES_Encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AES_Encryption{
	/*
	 * byte列を16文字の秘密鍵でAES暗号化して返す
	 */
	public static byte[] encrypt(byte[] originalBytes, String secretKey) 
		throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		//鍵のbyte列の生成
		byte[] secretKeyBytes = secretKey.getBytes();

		String algorithm = "AES";
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, algorithm);
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] encryptBytes = cipher.doFinal(originalBytes);

		return encryptBytes;
	}

	public static byte[] decrypt(byte[] encryptBytes, String secretKey)
		throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		//鍵のbyte列の生成
		byte[] secretKeyBytes = secretKey.getBytes();

		String algorithm = "AES";
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, algorithm);
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		byte[] decryptBytes = cipher.doFinal(encryptBytes);

		return decryptBytes;
	}

}
