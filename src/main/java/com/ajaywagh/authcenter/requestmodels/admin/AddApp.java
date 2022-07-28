package com.ajaywagh.authcenter.requestmodels.admin;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class AddApp {
    public static final int MIN_APP_ID_LENGTH=5;
    public static final int MAX_APP_ID_LENGTH=15;
    public static final int MIN_PERMISSIONS_COUNT=1;
    public static final int MAX_PERMISSIONS_COUNT=20;

    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "appId is required")
    @Size(min = MIN_APP_ID_LENGTH,max = MAX_APP_ID_LENGTH,message ="appId must have at least "+MIN_APP_ID_LENGTH+" characters and max "+MAX_APP_ID_LENGTH+" characters" )
    String appId;

    @NotNull(message = "at least one permission is required")
    @NotEmpty(message = "at least one permission is required")
    @Size(min=MIN_PERMISSIONS_COUNT,max = MAX_PERMISSIONS_COUNT,message = "minimum "+MIN_PERMISSIONS_COUNT+" permissions are required and maximum "+MAX_PERMISSIONS_COUNT+" permissions can be added")
    Set<String> permissions;
}
