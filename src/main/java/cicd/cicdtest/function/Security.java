package cicd.cicdtest.function;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Security {
    public String loginHashing(String before){
        String sha256 = "";
        try{
            MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
            mdSHA256.update(before.getBytes("UTF-8"));
            byte[] sha256Hash = mdSHA256.digest();

            StringBuffer hexSHA256hash = new StringBuffer();
            for(byte b : sha256Hash){
                String hexString = String.format("%02x",b);
                hexSHA256hash.append(hexString);
            }
            sha256 = hexSHA256hash.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return sha256;
    }
}
