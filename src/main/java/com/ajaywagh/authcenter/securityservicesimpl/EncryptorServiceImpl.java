package com.ajaywagh.authcenter.securityservicesimpl;

import com.ajaywagh.authcenter.log.LoggedClass;
import com.ajaywagh.authcenter.securityservices.EncryptorService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@LoggedClass
public class EncryptorServiceImpl implements EncryptorService {
    @Value("${hashing_algorithm}")
    String HASHING_ALGO;

    @Override
    public String encrypt(String password,byte[] salt) {
        byte[] hashedPass;
        try {
            MessageDigest messageDigest=MessageDigest.getInstance(HASHING_ALGO);
            messageDigest.update(salt);
            hashedPass= messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return Base64.encodeBase64String(hashedPass);
    }
}
