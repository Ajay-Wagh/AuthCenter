package com.ajaywagh.authcenter.services.admin;

import com.ajaywagh.authcenter.requestmodels.admin.*;
import com.ajaywagh.authcenter.responsemodels.admin.AdminResponse;

public interface TenantService {
    AdminResponse add(AddTenantRequest addTenantRequest);
    AdminResponse remove(RemoveTenantRequest removeTenantRequest);
    AdminResponse list(ListTenantRequest listTenantRequest);
}
