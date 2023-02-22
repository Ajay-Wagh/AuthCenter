package com.ajaywagh.authcenter.servicesimpl.securityservicesimpl;


import com.ajaywagh.authcenter.datamodels.Admin;
import com.ajaywagh.authcenter.datarepositories.AdminRepository;
import com.ajaywagh.authcenter.exceptions.InvalidCredentialsException;
import com.ajaywagh.authcenter.log.LoggedClass;
import com.ajaywagh.authcenter.requestmodels.admin.AdminRequest;
import com.ajaywagh.authcenter.services.securityservices.EncryptorService;
import com.ajaywagh.authcenter.services.securityservices.VerifyAdminService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
@LoggedClass
public class VerifyAdminServiceImpl implements VerifyAdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    EncryptorService encryptorService;



    public void verifyAdmin(@NotNull AdminRequest adminRequest){
        Admin existingAdmin;
        try {
            existingAdmin = adminRepository.getReferenceById(adminRequest.getUserId());
            if(!existingAdmin.getHash().equals(encryptorService.encrypt(adminRequest.getPassword(), Base64.decodeBase64(existingAdmin.getSalt())))){
                throw new InvalidCredentialsException();
            }
        }catch (EntityNotFoundException exception){
            throw new InvalidCredentialsException();
        }
    }
}
