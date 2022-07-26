package com.ajaywagh.authcenter.securityservicesimpl;

import com.ajaywagh.authcenter.securityservices.Encryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component("encryptor")
public class EncryptorImpl implements Encryptor {
    @Value("${hashing_algorithm}")
    String HASHING_ALGO;

    @Override
    public String encrypt(String password) {
        SecureRandom random=new SecureRandom();
        byte[] salt=new byte[16];
        random.nextBytes(salt);
        byte[] hashedPass;
        try {
            MessageDigest messageDigest=MessageDigest.getInstance(HASHING_ALGO);
            messageDigest.update(salt);
            hashedPass= messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return new String(hashedPass,StandardCharsets.UTF_8);
    }
}
