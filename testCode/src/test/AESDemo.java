package test;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * AES/ECB/PKCS5Padding
 *
 * @author Zdy
 */
public class AESDemo {

    private static final String AES_PASSWORD = "5e7b2ebda745cf2832f667f4";
    private static final String TMS_MD5Key = "a6259e5e0f98f9dd45342ffcb84981ba";

    private static final String VNPAY_AES_PASSWORD = "92fbe1c44830a10423ad7946";
    private static final String VNPAY_TMS_MD5Key = "49369e9a0a5d846a4fc7026ce33074a8";


    //mã hóa
    public static String aesEncrypt(String content, String password) {

        try {
            SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(byteContent);
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException |
                BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }


    //giải mã
    public static String aesDecrypt(String cipherText, String password) {
        byte[] cipherByte = Base64.getDecoder().decode(cipherText);
        try {
            SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(cipherByte);
            return new String(result);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                InvalidKeyException |
                BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;

    }


    public static void main(String[] args) {
//        ,"model_name":"P1_4G-EU","params_status":"success"
        String sign = aesEncrypt("{\"sn\":\"1234575890\",\"model_name\":\"P1_4G-EU\",\"params_status\":\"success\"", AES_PASSWORD);
        System.out.println("sign   " + sign);


        String data = aesDecrypt("8SzM8fG7EykgG9D9rsCJ34yYxzNR6+n/mQrxJDaezU34hWNE6KayliYfCOm9c4LE", AES_PASSWORD);
        System.out.println("data " + data);

        String test = "cx8H/Oi1HvT2rxkE/20OSA==";
        String e = "3541c51c8630f98f9a1518fc90087336";
        String b = "1569233503";
        System.out.println(aesDecrypt(test,AES_PASSWORD));

    }


}

