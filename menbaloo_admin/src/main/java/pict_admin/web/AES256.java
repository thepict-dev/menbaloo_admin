package pict_admin.web;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import pict_admin.web.AES256;

public class AES256 {
  public static String alg = "AES/CBC/PKCS5Padding";
  
  private final String key = "Vlrxmroqkf1004!Vlrxmroqkf1004!@@";
  
  private final String iv = "pictpictpictpict";
  
  public String decrypt(String cipherText) throws Exception {
    Cipher cipher = Cipher.getInstance(alg);
    SecretKeySpec keySpec = new SecretKeySpec("Vlrxmroqkf1004!Vlrxmroqkf1004!@@".getBytes(), "AES");
    IvParameterSpec ivParamSpec = new IvParameterSpec("pictpictpictpict".getBytes());
    cipher.init(2, keySpec, ivParamSpec);
    byte[] decodedBytes = hexStringToByteArray(cipherText);
    byte[] decrypted = cipher.doFinal(decodedBytes);
    return new String(decrypted, "UTF-8");
  }
  
  public static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2)
      data[i / 2] = 
        (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16)); 
    return data;
  }
}
