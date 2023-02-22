package com.ajaywagh.authcenter.servicesimpl.admin;

import com.ajaywagh.authcenter.requestmodels.admin.userchannel.AddUserChannelRequest;
import com.ajaywagh.authcenter.requestmodels.admin.userchannel.ListUserChannelRequest;
import com.ajaywagh.authcenter.requestmodels.admin.userchannel.RemoveUserChannelRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.services.admin.UserChannelService;
import org.springframework.stereotype.Service;

@Service
public class UserChannelServiceImpl implements UserChannelService {
    @Override
    public AdminResponse add(AddUserChannelRequest addUserChannelRequest) {
        return null;
    }

    @Override
    public AdminResponse remove(RemoveUserChannelRequest removeUserChannelRequest) {
        return null;
    }

    @Override
    public AdminResponse list(ListUserChannelRequest listUserChannelRequest) {
        return null;
    }
}
