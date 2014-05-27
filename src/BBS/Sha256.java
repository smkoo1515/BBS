package BBS;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {
    public static String encipher(String data) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return byteToHex(md.digest());
    }
    private static String byteToHex(byte[] bytes){
        StringBuffer result = new StringBuffer();
        for (byte b : bytes){
            result.append(Integer.toString((b & 0xFF) + 0x100, 16).substring(1));
        }
        return result.toString();
    }
}
