package com.ajaywagh.authcenter.servicesimpl.admin;

import com.ajaywagh.authcenter.datamodels.Tenant;
import com.ajaywagh.authcenter.datarepositories.TenantRepository;
import com.ajaywagh.authcenter.log.LoggedClass;
import com.ajaywagh.authcenter.requestmodels.admin.tenant.AddTenantRequest;
import com.ajaywagh.authcenter.requestmodels.admin.tenant.ListTenantRequest;
import com.ajaywagh.authcenter.requestmodels.admin.tenant.RemoveTenantRequest;
import com.ajaywagh.authcenter.responsemodels.Success;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.services.admin.TenantService;
import com.ajaywagh.authcenter.services.securityservices.VerifyAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@LoggedClass
public class TenantServiceImpl implements TenantService {

    @Autowired
    TenantRepository tenantRepository;
    @Autowired
    VerifyAdminService verifyAdminService;


    @Override
    public AdminResponse add(AddTenantRequest addTenantRequest) {
        verifyAdminService.verifyAdmin(addTenantRequest);
        Tenant tenant=new Tenant();
        tenant.setName(addTenantRequest.getTenantName());
        tenantRepository.saveAndFlush(tenant);
        AdminResponse adminResponse=new AdminResponse();
        adminResponse.setSuccess(Success.TRUE);
        return adminResponse;
    }

    @Override
    public AdminResponse remove(RemoveTenantRequest removeTenantRequest) {
        verifyAdminService.verifyAdmin(removeTenantRequest);
        Tenant tenant=new Tenant();
        tenant.setName(removeTenantRequest.getTenantName());
        tenantRepository.delete(tenant);
        tenantRepository.flush();

        return null;
    }

    @Override
    public AdminResponse list(ListTenantRequest listTenantRequest) {
        verifyAdminService.verifyAdmin(listTenantRequest);
        AdminResponse adminResponse=new AdminResponse();
        adminResponse.setSuccess(Success.TRUE);
        List<String> list=new ArrayList<>();
        tenantRepository.findAll().forEach(tenant -> {
            list.add(tenant.getName());
        });
        adminResponse.setList(list);
        return adminResponse;
    }
}
