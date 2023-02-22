package com.ajaywagh.authcenter.endpoints.admin;

import com.ajaywagh.authcenter.requestmodels.admin.app.AddAppRequest;
import com.ajaywagh.authcenter.requestmodels.admin.app.ListAppRequest;
import com.ajaywagh.authcenter.requestmodels.admin.app.RemoveAppRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.services.admin.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/app",method = RequestMethod.POST)
public class AppEndpoints {

    @Autowired
    AppService appService;

    @RequestMapping("/add")
    public AdminResponse addApp(@Valid @RequestBody AddAppRequest addAppRequest){
        return appService.add(addAppRequest);
    }

    @RequestMapping("/remove")
    public AdminResponse removeApp(@Valid @RequestBody RemoveAppRequest removeAppRequest){
        return appService.remove(removeAppRequest);
    }

    @RequestMapping("/list")
    public AdminResponse listApp(@Valid @RequestBody ListAppRequest listAppRequest){
        return appService.list(listAppRequest);
    }

}
