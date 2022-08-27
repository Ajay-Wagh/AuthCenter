package com.ajaywagh.authcenter.requestmodels.admin;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ajaywagh.authcenter.requestmodels.admin.AddTenantRequest.MAX_TENANT_NAME_LENGTH;
import static com.ajaywagh.authcenter.requestmodels.admin.AddTenantRequest.MIN_TENANT_NAME_LENGTH;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class RemoveTenantRequest extends AdminRequest{

    @NotNull(message = "tenantName is required")
    @Size(min = MIN_TENANT_NAME_LENGTH,max = MAX_TENANT_NAME_LENGTH,message ="tenantName must have at least "+MIN_TENANT_NAME_LENGTH+" characters and max "+MAX_TENANT_NAME_LENGTH+" characters" )
    String tenantName;
}
