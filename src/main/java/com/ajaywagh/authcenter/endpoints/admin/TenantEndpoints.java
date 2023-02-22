package com.ajaywagh.authcenter.endpoints.admin;

import com.ajaywagh.authcenter.requestmodels.admin.tenant.AddTenantRequest;
import com.ajaywagh.authcenter.requestmodels.admin.tenant.ListTenantRequest;
import com.ajaywagh.authcenter.requestmodels.admin.tenant.RemoveTenantRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.services.admin.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/tenant",method = RequestMethod.POST)
public class TenantEndpoints {

    @Autowired
    TenantService tenantService;

    @RequestMapping("/add")
    public AdminResponse addTenant(@Valid @RequestBody AddTenantRequest addTenantRequest){
        return tenantService.add(addTenantRequest);
    }

    @RequestMapping("/remove")
    public AdminResponse removeApp(@Valid @RequestBody RemoveTenantRequest removeTenantRequest){
        return tenantService.remove(removeTenantRequest);
    }

    @RequestMapping("/list")
    public AdminResponse listApp(@Valid @RequestBody ListTenantRequest listTenantRequest){
        return tenantService.list(listTenantRequest);
    }

}
