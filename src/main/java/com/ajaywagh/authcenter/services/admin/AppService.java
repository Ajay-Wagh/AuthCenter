package com.ajaywagh.authcenter.services.admin;

import com.ajaywagh.authcenter.requestmodels.admin.app.AddAppRequest;
import com.ajaywagh.authcenter.requestmodels.admin.app.ListAppRequest;
import com.ajaywagh.authcenter.requestmodels.admin.app.RemoveAppRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;

public interface AppService {

    AdminResponse add(AddAppRequest addAppRequest);
    AdminResponse remove(RemoveAppRequest removeAppRequest);
    AdminResponse list(ListAppRequest listAppRequest);
}
