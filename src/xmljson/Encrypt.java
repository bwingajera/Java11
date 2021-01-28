package xmljson;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
	
	public static void main(String args[]) {
//		if(args[0].equalsIgnoreCase("1")) {
			System.out.println(encryptParam("60605692"));			
	//	}
	}

	public static String encryptParam(String value) {

		//Base64 bcodec = new Base64();

		try {

			Key key = new SecretKeySpec("Soft9056T1EW9YQ1".getBytes(), "AES");

			Cipher cipher = Cipher.getInstance("AES");

			cipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));

			String encryptedValue64 = Base64.getEncoder().encodeToString(encryptedByteValue);

			return encryptedValue64;

		} catch (Exception ex) {

			ex.printStackTrace();

			return null;

		}

	}

}
