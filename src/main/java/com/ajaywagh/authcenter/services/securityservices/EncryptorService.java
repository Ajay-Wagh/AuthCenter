package com.ajaywagh.authcenter.services.securityservices;

public interface EncryptorService {
    String encrypt(String password,byte[] salt);
}
