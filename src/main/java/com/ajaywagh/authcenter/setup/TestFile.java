package com.ajaywagh.authcenter.setup;

import com.ajaywagh.authcenter.securityservices.EncryptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class TestFile {

        @Autowired
        EncryptorService encryptorService;

        private final SecureRandom random=new SecureRandom();

        @EventListener(ApplicationReadyEvent.class)
        public void run() {

//                System.out.println("Testing...");
//                String password="ajaywagh";
//                byte[] salt=new byte[15];
//                random.nextBytes(salt);
//                String saltString= Base64.encodeBase64String(salt);
//                System.out.println("Password is : "+password);
//                System.out.println("Salt is : "+saltString);
//                String hash= encryptorService.encrypt(password,salt);
//                System.out.println("Hash is : "+hash);
//                System.out.println("Encrypting again to check....");
//                String password2="ajaywagh";
//                byte[] salt2=Base64.decodeBase64(saltString);
//                String hash2= encryptorService.encrypt(password2,salt2);
//                System.out.println("Password is : "+password2);
//                System.out.println("Salt is : "+Base64.encodeBase64String(salt2));
//                System.out.println("Hash is : "+hash2);

        }
}
