package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Converter {
	public static String password(String password) {

		Charset charset = StandardCharsets.UTF_8;
		String algorithm = "MD5";

		try {
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
			String pass = DatatypeConverter.printHexBinary(bytes);
			return pass;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}
