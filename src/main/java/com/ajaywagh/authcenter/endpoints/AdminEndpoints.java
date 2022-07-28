package com.ajaywagh.authcenter.endpoints;

import com.ajaywagh.authcenter.requestmodels.admin.AddAdminRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.responsemodels.admin.Success;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/admin",method = RequestMethod.POST)
public class AdminEndpoints {

    @RequestMapping("/admin/add")
    public AdminResponse addAdmin(@Valid  @RequestBody AddAdminRequest addAdminRequest){
        AdminResponse adminResponse=new AdminResponse();
        adminResponse.setSuccess(Success.TRUE);
        return adminResponse;
    }

}
