package com.ajaywagh.authcenter.services.admin;

import com.ajaywagh.authcenter.requestmodels.admin.*;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;

public interface AppService {

    AdminResponse add(AddAppRequest addAppRequest);
    AdminResponse remove(RemoveAppRequest removeAppRequest);
    AdminResponse list(ListAppRequest listAppRequest);
}
