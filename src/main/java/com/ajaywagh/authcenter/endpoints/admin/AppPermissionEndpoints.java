package com.ajaywagh.authcenter.endpoints.admin;


import com.ajaywagh.authcenter.requestmodels.admin.apppermission.AddAppPermissionRequest;
import com.ajaywagh.authcenter.requestmodels.admin.apppermission.ListAppPermissionRequest;
import com.ajaywagh.authcenter.requestmodels.admin.apppermission.RemoveAppPermissionRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.services.admin.AppPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/apppermission",method = RequestMethod.POST)
public class AppPermissionEndpoints {

    @Autowired
    AppPermissionService appPermissionService;


    @RequestMapping("/add")
    public AdminResponse addAppPermission(@Valid @RequestBody AddAppPermissionRequest addAppPermissionRequest){
        return appPermissionService.add(addAppPermissionRequest);
    }

    @RequestMapping("/remove")
    public AdminResponse removeAppPermission(@Valid @RequestBody RemoveAppPermissionRequest removeAppPermissionRequest){
        return appPermissionService.remove(removeAppPermissionRequest);
    }

    @RequestMapping("/list")
    public AdminResponse listAppPermission(@Valid @RequestBody ListAppPermissionRequest listAppPermissionRequest){
        return appPermissionService.list(listAppPermissionRequest);
    }

}
