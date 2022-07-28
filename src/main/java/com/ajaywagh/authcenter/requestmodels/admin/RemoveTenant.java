package com.ajaywagh.authcenter.requestmodels.admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ajaywagh.authcenter.requestmodels.admin.AddTenant.MAX_TENANT_NAME_LENGTH;
import static com.ajaywagh.authcenter.requestmodels.admin.AddTenant.MIN_TENANT_NAME_LENGTH;

public class RemoveTenant {
    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "tenantName is required")
    @Size(min = MIN_TENANT_NAME_LENGTH,max = MAX_TENANT_NAME_LENGTH,message ="tenantName must have at least "+MIN_TENANT_NAME_LENGTH+" characters and max "+MAX_TENANT_NAME_LENGTH+" characters" )
    String tenantName;
}
