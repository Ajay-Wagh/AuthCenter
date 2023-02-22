package com.ajaywagh.authcenter.servicesimpl.securityservicesimpl;

import com.ajaywagh.authcenter.log.LoggedClass;
import com.ajaywagh.authcenter.services.securityservices.EncryptorService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
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
