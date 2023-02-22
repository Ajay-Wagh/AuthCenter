package com.ajaywagh.authcenter.requestmodels.admin.tenant;

import com.ajaywagh.authcenter.requestmodels.admin.AdminRequest;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class AddTenantRequest extends AdminRequest {
    public static final int MIN_TENANT_NAME_LENGTH=5;
    public static final int MAX_TENANT_NAME_LENGTH=10;

    @NotNull(message = "tenantName is required")
    @Size(min = MIN_TENANT_NAME_LENGTH,max = MAX_TENANT_NAME_LENGTH,message ="tenantName must have at least "+MIN_TENANT_NAME_LENGTH+" characters and max "+MAX_TENANT_NAME_LENGTH+" characters" )
    String tenantName;
}
