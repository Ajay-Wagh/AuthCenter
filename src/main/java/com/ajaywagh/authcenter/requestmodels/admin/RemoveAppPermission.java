package com.ajaywagh.authcenter.requestmodels.admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ajaywagh.authcenter.requestmodels.admin.AddAppPermission.MAX_APP_PERMISSION_LENGTH;
import static com.ajaywagh.authcenter.requestmodels.admin.AddAppPermission.MIN_APP_PERMISSION_LENGTH;

public class RemoveAppPermission {
    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "permission is mandatory")
    @Size(min = MIN_APP_PERMISSION_LENGTH,max = MAX_APP_PERMISSION_LENGTH,message ="permission must have at least "+MIN_APP_PERMISSION_LENGTH+" characters and max "+MAX_APP_PERMISSION_LENGTH+" characters" )
    String permission;
}
