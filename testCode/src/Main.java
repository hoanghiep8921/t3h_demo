import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) {

        String unix = "1562730455";
        String md5Key = "907fb0e0a1833d5c6f1ab3e1c8478e94";
        //bỏ cái content vừa mã hóa vào đây
        String content = "l27uWgFAhxciEUEz6bkncuerh/oVH2TQfdJINT8NPoNQnbsk3xUvNpPyJnlRVXE78ZSpaW2SG5fBLqTq3FTBfQVtyPzwJk7LzooqFcE29rc=";
        System.out.println(getMd5(content+unix+md5Key));
    }

    public static String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
