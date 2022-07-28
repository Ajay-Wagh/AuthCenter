package com.ajaywagh.authcenter.requestmodels.admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ajaywagh.authcenter.requestmodels.admin.Head.*;

public class AddAdmin {
    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "userid is required")
    @Size(min = MIN_USERID_LENGTH,max = MAX_USERID_LENGTH,message ="userid must have at least "+MIN_USERID_LENGTH+" characters and max "+MAX_USERID_LENGTH+" characters" )
    String userId;

    @NotNull(message = "password is required")
    @Size(min = MIN_PASSWORD_LENGTH,max = MAX_PASSWORD_LENGTH,message ="password must have at least "+MIN_PASSWORD_LENGTH+" characters and max "+MAX_PASSWORD_LENGTH+" characters" )
    String password;
}
