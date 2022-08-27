package com.ajaywagh.authcenter.servicesimpl.admin;

import com.ajaywagh.authcenter.datamodels.Admin;
import com.ajaywagh.authcenter.datarepositories.AdminRepository;
import com.ajaywagh.authcenter.exceptions.InvalidCredentialsException;
import com.ajaywagh.authcenter.log.LoggedClass;
import com.ajaywagh.authcenter.requestmodels.admin.AddAdminRequest;
import com.ajaywagh.authcenter.requestmodels.admin.ListAdminRequest;
import com.ajaywagh.authcenter.requestmodels.admin.RemoveAdminRequest;
import com.ajaywagh.authcenter.responsemodels.Success;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.securityservices.EncryptorService;
import com.ajaywagh.authcenter.services.admin.AdminService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.security.SecureRandom;

@Service
@LoggedClass
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    EncryptorService encryptorService;


    private final SecureRandom random=new SecureRandom();

    @Override
    public AdminResponse add(AddAdminRequest addAdminRequest) {
        verifyAdmin(addAdminRequest);
        byte[] salt=new byte[15];
        random.nextBytes(salt);
        Admin admin=new Admin(addAdminRequest.getNewUserId(), encryptorService.encrypt(addAdminRequest.getNewUserPassword(),salt),Base64.encodeBase64String(salt));
        adminRepository.saveAndFlush(admin);
        AdminResponse adminResponse=new AdminResponse();
        adminResponse.setSuccess(Success.TRUE);
        return adminResponse;
    }

    @Override
    public AdminResponse remove(RemoveAdminRequest removeAdminRequest) {
        return null;
    }

    @Override
    public AdminResponse list(ListAdminRequest listAdminRequest) {
        return null;
    }


    private void verifyAdmin(@NotNull AddAdminRequest addAdminRequest)throws EntityNotFoundException{
        Admin existingAdmin;
        try {
            existingAdmin = adminRepository.getReferenceById(addAdminRequest.getUserId());
            if(!existingAdmin.getHash().equals(encryptorService.encrypt(addAdminRequest.getPassword(), Base64.decodeBase64(existingAdmin.getSalt())))){
                throw new InvalidCredentialsException();
            }
        }catch (EntityNotFoundException exception){
            throw new InvalidCredentialsException();
        }
    }
}
