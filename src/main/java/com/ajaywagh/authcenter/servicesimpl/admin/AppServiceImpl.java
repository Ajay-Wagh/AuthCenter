package com.ajaywagh.authcenter.servicesimpl.admin;

import com.ajaywagh.authcenter.requestmodels.admin.app.AddAppRequest;
import com.ajaywagh.authcenter.requestmodels.admin.app.ListAppRequest;
import com.ajaywagh.authcenter.requestmodels.admin.app.RemoveAppRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;
import com.ajaywagh.authcenter.services.admin.AppService;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {
    @Override
    public AdminResponse add(AddAppRequest addAppRequest) {
        return null;
    }

    @Override
    public AdminResponse remove(RemoveAppRequest removeAppRequest) {
        return null;
    }

    @Override
    public AdminResponse list(ListAppRequest listAppRequest) {
        return null;
    }
}
