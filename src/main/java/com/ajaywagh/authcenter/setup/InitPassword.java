package com.ajaywagh.authcenter.setup;


import com.ajaywagh.authcenter.datamodels.Admin;
import com.ajaywagh.authcenter.datarepositories.AdminRepository;
import com.ajaywagh.authcenter.securityservices.Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitPassword {
    @Value("${default_admin_id}")
    String defaultAdminId;

    @Value("${default_admin_password}")
    String defaultAdminPassword;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    Encryptor encryptor;

    @EventListener(ApplicationReadyEvent.class)
    public void setInitialPassword() {
        Admin admin = new Admin(defaultAdminId, encryptor.encrypt(defaultAdminPassword));
        adminRepository.saveAndFlush(admin);
    }
}
