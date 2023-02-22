package com.ajaywagh.authcenter.servicesimpl.admin;

import com.ajaywagh.authcenter.datamodels.Admin;
import com.ajaywagh.authcenter.datarepositories.AdminRepository;
import com.ajaywagh.authcenter.log.LoggedClass;
import com.ajaywagh.authcenter.requestmodels.admin.admin.AddAdminRequest;
import com.ajaywagh.authcenter.requestmodels.admin.admin.ListAdminRequest;
import com.ajaywagh.authcenter.requestmodels.admin.admin.RemoveAdminRequest;
import com.ajaywagh.authcenter.responsemodels.Error;
import com.ajaywagh.authcenter.responsemodels.ErrorCode;
import com.ajaywagh.authcenter.responsemodels.Success;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.services.admin.AdminService;
import com.ajaywagh.authcenter.services.securityservices.EncryptorService;
import com.ajaywagh.authcenter.services.securityservices.VerifyAdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
@LoggedClass
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    EncryptorService encryptorService;

    @Autowired
    VerifyAdminService verifyAdminService;


    private final SecureRandom random=new SecureRandom();

    @Override
    public AdminResponse add(AddAdminRequest addAdminRequest) {
        verifyAdminService.verifyAdmin(addAdminRequest);
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
        verifyAdminService.verifyAdmin(removeAdminRequest);
        Admin admin=new Admin();
        admin.setUserId(removeAdminRequest.getUserIdToRemove());
        AdminResponse adminResponse=new AdminResponse();
        if(adminRepository.existsById(admin.getUserId())) {
            adminRepository.delete(admin);
            adminRepository.flush();
            adminResponse.setSuccess(Success.TRUE);
        }else {
            adminResponse.setSuccess(Success.FALSE);
            adminResponse.setError(new Error(ErrorCode.OBJECT_NOT_FOUND,"Admin to be deleted is not present"));
        }
        return adminResponse;
    }

    @Override
    public AdminResponse list(ListAdminRequest listAdminRequest) {
        verifyAdminService.verifyAdmin(listAdminRequest);
        List<String> adminList=new ArrayList<>();
        adminRepository.findAll().forEach(admin -> {
            adminList.add(admin.getUserId());
        });
        AdminResponse adminResponse=new AdminResponse();
        adminResponse.setSuccess(Success.TRUE);
        adminResponse.setList(adminList);
        return adminResponse;
    }

}
