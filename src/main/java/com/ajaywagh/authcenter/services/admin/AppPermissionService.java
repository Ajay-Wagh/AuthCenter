package com.ajaywagh.authcenter.services.admin;

import com.ajaywagh.authcenter.requestmodels.admin.apppermission.AddAppPermissionRequest;
import com.ajaywagh.authcenter.requestmodels.admin.apppermission.ListAppPermissionRequest;
import com.ajaywagh.authcenter.requestmodels.admin.apppermission.RemoveAppPermissionRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;

public interface AppPermissionService {

    AdminResponse add(AddAppPermissionRequest addAppPermissionRequest);
    AdminResponse remove(RemoveAppPermissionRequest removeAppPermissionRequest);
    AdminResponse list(ListAppPermissionRequest listAppPermissionRequest);
}
