package passwordEncryption;

import java.util.Base64;

public class Password {

    public static String encrypt(char[] passwordCharacters) {
        String password = "";
        for (char c : passwordCharacters) {
            password += c;
        }
        byte[] passwordBytes = password.getBytes();
        byte[] bytesEncoded = Base64.getEncoder().encode(passwordBytes);
        return new String(bytesEncoded);
    }
}
