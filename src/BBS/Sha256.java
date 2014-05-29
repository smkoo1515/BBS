//　暗号化処理のためのSHA-256エンコーダー

package BBS;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//　Staticクラスでオブジェクトを生成せずに使用
public class Sha256 {
    //　文字列をSHA-256アルゴリズムで暗号化する
    public static String encipher(String data) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return byteToHex(md.digest());
    }
    //　データを表現できるようするため文字列で変換
    private static String byteToHex(byte[] bytes){
        StringBuffer result = new StringBuffer();
        for (byte b : bytes){
            result.append(Integer.toString((b & 0xFF) + 0x100, 16).substring(1));
        }
        return result.toString();
    }
}
