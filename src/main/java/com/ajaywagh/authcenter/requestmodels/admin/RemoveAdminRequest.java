package com.ajaywagh.authcenter.requestmodels.admin;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RemoveAdminRequest extends AdminRequest {

    @NotNull(message = "userIdToRemove is required")
    @Size(min = MIN_USERID_LENGTH,max = MAX_USERID_LENGTH,message ="userIdToRemove must have at least "+MIN_USERID_LENGTH+" characters and max "+MAX_USERID_LENGTH+" characters" )
    String userIdToRemove;
}
