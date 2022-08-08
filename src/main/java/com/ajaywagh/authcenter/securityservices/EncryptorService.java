package com.ajaywagh.authcenter.securityservices;

public interface EncryptorService {
    String encrypt(String password,byte[] salt);
}
