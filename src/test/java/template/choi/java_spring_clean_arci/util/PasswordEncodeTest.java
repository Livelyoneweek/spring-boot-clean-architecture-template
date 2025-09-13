package template.choi.java_spring_clean_arci.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
public class PasswordEncodeTest {

    @Test
    void encodePassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "123456";
        String encoded = passwordEncoder.encode(rawPassword);
        log.info("Encoded password: " + encoded);
    }
}
