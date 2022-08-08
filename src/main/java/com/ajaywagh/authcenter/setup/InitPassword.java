package com.ajaywagh.authcenter.setup;


import com.ajaywagh.authcenter.datamodels.Admin;
import com.ajaywagh.authcenter.datarepositories.AdminRepository;
import com.ajaywagh.authcenter.securityservices.EncryptorService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class InitPassword {
    @Value("${default_admin_id}")
    String defaultAdminId;

    @Value("${default_admin_password}")
    String defaultAdminPassword;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    EncryptorService encryptorService;

    @EventListener(ApplicationReadyEvent.class)
    public void setInitialPassword() {
        byte[] salt=new byte[15];
        SecureRandom random=new SecureRandom();
        random.nextBytes(salt);
        Admin admin = new Admin(defaultAdminId, encryptorService.encrypt(defaultAdminPassword,salt), Base64.encodeBase64String(salt));
        adminRepository.saveAndFlush(admin);
    }
}
