package com.ajaywagh.authcenter.requestmodels.admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import static com.ajaywagh.authcenter.requestmodels.admin.Head.MAX_USERID_LENGTH;
import static com.ajaywagh.authcenter.requestmodels.admin.Head.MIN_USERID_LENGTH;

public class RemoveAdmin {
    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "userid to remove is required")
    @Size(min = MIN_USERID_LENGTH,max = MAX_USERID_LENGTH,message ="userid must have at least "+MIN_USERID_LENGTH+" characters and max "+MAX_USERID_LENGTH+" characters" )
    String userIdToRemove;
}
