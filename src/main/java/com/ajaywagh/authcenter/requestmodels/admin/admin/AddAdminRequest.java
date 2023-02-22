package com.ajaywagh.authcenter.requestmodels.admin.admin;

import com.ajaywagh.authcenter.requestmodels.admin.AdminRequest;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class AddAdminRequest extends AdminRequest {

    @Pattern(regexp = "^[a-z0-9]+$")
    @NotNull(message = "newUserId is required")
    @Size(min = MIN_USERID_LENGTH,max = MAX_USERID_LENGTH,message ="newUserId must have at least "+MIN_USERID_LENGTH+" characters and max "+MAX_USERID_LENGTH+" characters" )
    String newUserId;

    @NotNull(message = "newUserPassword is required")
    @Size(min = MIN_PASSWORD_LENGTH,max = MAX_PASSWORD_LENGTH,message ="newUserPassword must have at least "+MIN_PASSWORD_LENGTH+" characters and max "+MAX_PASSWORD_LENGTH+" characters" )
    String newUserPassword;
}
