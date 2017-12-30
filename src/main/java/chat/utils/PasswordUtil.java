package chat.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private static final Logger log = LoggerFactory.getLogger(PasswordUtil.class);

    private PasswordUtil(){
        throw new IllegalStateException("Utility classes should not be instantiated");
    }

    /**
     * Generate a hash from a raw password
     * @param password the raw password or null if no password is provided
     * @return the generated hash
     */
    public static String generateBCrypt(String password){
        if(password == null){
            return password;
        }

        log.info("Generating has with BCrypt.");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

}
