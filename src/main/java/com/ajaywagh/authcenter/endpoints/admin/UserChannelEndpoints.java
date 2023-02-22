package com.ajaywagh.authcenter.endpoints.admin;

import com.ajaywagh.authcenter.requestmodels.admin.userchannel.AddUserChannelRequest;
import com.ajaywagh.authcenter.requestmodels.admin.userchannel.ListUserChannelRequest;
import com.ajaywagh.authcenter.requestmodels.admin.userchannel.RemoveUserChannelRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.services.admin.UserChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/userchannel",method = RequestMethod.POST)
public class UserChannelEndpoints {
    @Autowired
    UserChannelService userChannelService;

    @RequestMapping("/add")
    public AdminResponse addUserChannel(@Valid @RequestBody AddUserChannelRequest addUserChannelRequest){
        return userChannelService.add(addUserChannelRequest);
    }

    @RequestMapping("/remove")
    public AdminResponse removeUserChannel(@Valid @RequestBody RemoveUserChannelRequest removeUserChannelRequest){
        return userChannelService.remove(removeUserChannelRequest);
    }

    @RequestMapping("/list")
    public AdminResponse listUserChannel(@Valid @RequestBody ListUserChannelRequest listUserChannelRequest){
        return userChannelService.list(listUserChannelRequest);
    }

}
