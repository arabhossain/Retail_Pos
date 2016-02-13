/*
    Software Engineer
    ---------------------------------------
    Md. Arab Hossain
    Email: arabhossain317@diu.edu.bd
           green.arab1995@gmail.com
    Mobile: +8801827-464330
            +8801737-331037
    Daffodil International University(Student)
 */

package Util;

import java.io.UnsupportedEncodingException;
import java.security.*;
import javax.crypto.*;

/**
 *
 * @author Loser
 */
public class HASS {
    
    private Cipher cipherDecrypt;
    private Cipher cipherEncrypt;
    
    /**
     *
     * @param passPhrase
     */
    public HASS(String passPhrase) {
        
        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed(passPhrase.getBytes("UTF8"));
            KeyGenerator kGen = KeyGenerator.getInstance("DESEDE");
            kGen.init(168, sr);
            Key key = kGen.generateKey();

            cipherEncrypt = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
            cipherEncrypt.init(Cipher.ENCRYPT_MODE, key);
            
            cipherDecrypt = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
            cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
        } catch (UnsupportedEncodingException | NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException e) {
        }
    }
    
    /**
     *
     * @param str
     * @return
     */
    public String encrypt(String str) {
        try {
            return StringUtils.byte2hex(cipherEncrypt.doFinal(str.getBytes("UTF8")));
        } catch (UnsupportedEncodingException | BadPaddingException | IllegalBlockSizeException e) {
        }
        return null;
    }
    
    /**
     *
     * @param str
     * @return
     */
    public String decrypt(String str) {
        try {
            return new String(cipherDecrypt.doFinal(StringUtils.hex2byte(str)), "UTF8");
        } catch (UnsupportedEncodingException | BadPaddingException | IllegalBlockSizeException e) {         
        }
        return null;
    }    
}
