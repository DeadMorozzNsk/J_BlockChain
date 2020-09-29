package MyBlockChain.Encryption;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {
    private final String key;
    private static final int[] pin = {3, 6, 1, 2};//значения от 0 до 31. Чем меньше элементов, тем больше вероятность коллизии в шифре

    public Encryption(String key) {
        this.key = key;
    }

    public String encode(String src) {
        String toEncode = getB64String(src);
        StringBuilder encoded = new StringBuilder();
        char[] charArr = toEncode.toCharArray();
        for (char ch : charArr) {
            String preEncode = getMD5String(getMD5String(key + ch) + key);
            for (int aPin : pin) {
                encoded.append(preEncode.charAt(aPin));
            }
        }
        return encoded.toString();
    }

    public String decode(String encoded) {
        String symbols = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM=+/";
        String decoded = encoded;
        char[] charArr = symbols.toCharArray();
        for (char aCharArr : charArr) {
            String tempHash = getMD5String(getMD5String(key + aCharArr) + key);
            StringBuilder slice = new StringBuilder();
            for (int aPin : pin) {
                slice.append(tempHash.charAt(aPin));
            }
            decoded = decoded.replace(slice.toString(), "" + aCharArr);
        }
        decoded = decodeB64String(decoded);
        return decoded;
    }

    private static String getB64String(String src) {
        Base64.Encoder enc = Base64.getEncoder();
        return enc.encodeToString(src.getBytes(StandardCharsets.UTF_8));
    }

    private String decodeB64String(String src) {
        Base64.Decoder dec = Base64.getDecoder();
        return new String(dec.decode(src.getBytes(StandardCharsets.UTF_8)));
    }

    private static String getMD5String(String src) {
        String result = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(src.getBytes(StandardCharsets.UTF_8));
            result = new BigInteger(1, md5.digest()).toString(16);
            StringBuilder sBuilder = new StringBuilder(32);
            for (int i = 0, count = 32 - result.length(); i < count; i++) {
                sBuilder.append("0");
            }
            result = sBuilder.append(result).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }


}
