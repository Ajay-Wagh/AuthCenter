package com.ajaywagh.authcenter.servicesimpl.admin;

import com.ajaywagh.authcenter.requestmodels.admin.apppermission.AddAppPermissionRequest;
import com.ajaywagh.authcenter.requestmodels.admin.apppermission.ListAppPermissionRequest;
import com.ajaywagh.authcenter.requestmodels.admin.apppermission.RemoveAppPermissionRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.services.admin.AppPermissionService;
import org.springframework.stereotype.Service;

@Service
public class AppPermissionServiceImpl implements AppPermissionService {
    @Override
    public AdminResponse add(AddAppPermissionRequest addAppPermissionRequest) {
        return null;
    }

    @Override
    public AdminResponse remove(RemoveAppPermissionRequest removeAppPermissionRequest) {
        return null;
    }

    @Override
    public AdminResponse list(ListAppPermissionRequest listAppPermissionRequest) {
        return null;
    }
}
