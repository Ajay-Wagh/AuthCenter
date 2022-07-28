package com.ajaywagh.authcenter.requestmodels.admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddTenant {
    public static final int MIN_TENANT_NAME_LENGTH=5;
    public static final int MAX_TENANT_NAME_LENGTH=10;

    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "tenantName is required")
    @Size(min = MIN_TENANT_NAME_LENGTH,max = MAX_TENANT_NAME_LENGTH,message ="tenantName must have at least "+MIN_TENANT_NAME_LENGTH+" characters and max "+MAX_TENANT_NAME_LENGTH+" characters" )
    String tenantName;
}
