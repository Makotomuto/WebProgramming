package servlet;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class Converter {
	public static String password(String password) {
		try {
			//ハッシュを生成したい元の文字列
			String source = password;
			//ハッシュ生成前にバイト配列に置き換える際のCharset
			Charset charset = StandardCharsets.UTF_8;
			//ハッシュアルゴリズム
			String algorithm = "MD5";

			//ハッシュ生成処理
			byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			String result = DatatypeConverter.printHexBinary(bytes);
			//標準出力
			System.out.println(result);
			return result;
		}catch (Exception e) {
			return null;
		}

	}

}
