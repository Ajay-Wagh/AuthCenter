package com.ajaywagh.authcenter.requestmodels.admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ajaywagh.authcenter.requestmodels.admin.AddApp.MAX_APP_ID_LENGTH;
import static com.ajaywagh.authcenter.requestmodels.admin.AddApp.MIN_APP_ID_LENGTH;

public class RemoveApp {
    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "appId is required")
    @Size(min = MIN_APP_ID_LENGTH,max = MAX_APP_ID_LENGTH,message ="appId must have at least "+MIN_APP_ID_LENGTH+" characters and max "+MAX_APP_ID_LENGTH+" characters" )
    String appId;
}
