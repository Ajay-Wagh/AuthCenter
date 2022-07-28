package com.ajaywagh.authcenter.requestmodels.admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddAppPermission {
    public static final int MIN_APP_PERMISSION_LENGTH=4;
    public static final int MAX_APP_PERMISSION_LENGTH=20;

    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "permission is mandatory")
    @Size(min = MIN_APP_PERMISSION_LENGTH,max = MAX_APP_PERMISSION_LENGTH,message ="permission must have at least "+MIN_APP_PERMISSION_LENGTH+" characters and max "+MAX_APP_PERMISSION_LENGTH+" characters" )
    String permission;
}
