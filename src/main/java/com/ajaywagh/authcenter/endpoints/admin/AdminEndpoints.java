package com.ajaywagh.authcenter.endpoints.admin;

import com.ajaywagh.authcenter.requestmodels.admin.admin.AddAdminRequest;
import com.ajaywagh.authcenter.requestmodels.admin.admin.ListAdminRequest;
import com.ajaywagh.authcenter.requestmodels.admin.admin.RemoveAdminRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.services.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/admin",method = RequestMethod.POST)
public class AdminEndpoints {
    @Autowired
    AdminService adminService;


    @RequestMapping("/add")
    public AdminResponse addAdmin(@Valid  @RequestBody AddAdminRequest addAdminRequest){
        return adminService.add(addAdminRequest);
    }

    @RequestMapping("/remove")
    public AdminResponse removeAdmin(@Valid @RequestBody RemoveAdminRequest removeAdminRequest){
        return adminService.remove(removeAdminRequest);
    }

    @RequestMapping("/list")
    public AdminResponse listAdmin(@Valid @RequestBody ListAdminRequest listAdminRequest){
        return adminService.list(listAdminRequest);
    }


}
