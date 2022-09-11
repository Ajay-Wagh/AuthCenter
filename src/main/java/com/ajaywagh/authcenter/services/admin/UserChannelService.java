package com.ajaywagh.authcenter.services.admin;

import com.ajaywagh.authcenter.requestmodels.admin.*;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;

public interface UserChannelService {
    AdminResponse add(AddUserChannelRequest addUserChannelRequest);
    AdminResponse remove(RemoveUserChannelRequest removeUserChannelRequest);
    AdminResponse list(ListUserChannelRequest listUserChannelRequest);
}
