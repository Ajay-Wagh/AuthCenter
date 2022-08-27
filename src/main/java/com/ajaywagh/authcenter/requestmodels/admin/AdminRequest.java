package com.ajaywagh.authcenter.requestmodels.admin;

import com.ajaywagh.authcenter.requestmodels.Request;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class AdminRequest extends Request {
    public static final int MIN_USERID_LENGTH=3;
    public static final int MAX_USERID_LENGTH=10;
    public static final int MIN_PASSWORD_LENGTH=6;
    public static final int MAX_PASSWORD_LENGTH=10;

    @Pattern(regexp = "^[a-z0-9]+$")
    @NotNull(message = "userId is required")
    @Size(min = MIN_USERID_LENGTH,max = MAX_USERID_LENGTH,message ="userId must have at least "+MIN_USERID_LENGTH+" characters and max "+MAX_USERID_LENGTH+" characters" )
    String userId;

    @NotNull(message = "password is required")
    @Size(min = MIN_PASSWORD_LENGTH,max = MAX_PASSWORD_LENGTH,message ="password must have at least "+MIN_PASSWORD_LENGTH+" characters and max "+MAX_PASSWORD_LENGTH+" characters" )
    String password;
}
