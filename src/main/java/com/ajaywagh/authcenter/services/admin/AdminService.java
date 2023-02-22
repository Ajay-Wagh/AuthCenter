package com.ajaywagh.authcenter.services.admin;

import com.ajaywagh.authcenter.requestmodels.admin.admin.AddAdminRequest;
import com.ajaywagh.authcenter.requestmodels.admin.admin.ListAdminRequest;
import com.ajaywagh.authcenter.requestmodels.admin.admin.RemoveAdminRequest;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;

public interface AdminService {

    AdminResponse add(AddAdminRequest addAdminRequest);
    AdminResponse remove(RemoveAdminRequest removeAdminRequest);
    AdminResponse list(ListAdminRequest listAdminRequest);

}
