import AES_Encryption.AES_Encryption;

public class Main {
	public static void main(String[] args) {
		try {
			String key = "1234567890123456"; // 暗号化方式「AES」の場合、キーは16文字で
			String original = "This is a source of string!!"; // 元の文字列
			String algorithm = "AES"; // 暗号化方式「AES(Advanced Encryption Standard)」

			//平文のbyte列を生成			
			byte[] original_bytes = original.getBytes();
			//AESで暗号化したbyte列を生成
			byte[] encrypt_bytes = AES_Encryption.encrypt(original_bytes,key);

			//暗号化したbyte列から文字列を生成
			String encrypt = new String(encrypt_bytes,"UTF-8");
			System.out.println("[Main] encrypt data is \""+encrypt+"\".");

			//複合化
			byte[] decrypt_bytes = AES_Encryption.decrypt(encrypt_bytes,key);

			//複合化したbyte列から文字列を生成
			String decrypt = new String(decrypt_bytes,"UTF-8");
			System.out.println("[Main] decrypt data is \""+decrypt+"\".");


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

