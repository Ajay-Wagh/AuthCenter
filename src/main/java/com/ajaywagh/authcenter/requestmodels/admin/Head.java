package com.ajaywagh.authcenter.requestmodels.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Head {
    public static final int MIN_USERID_LENGTH=3;
    public static final int MAX_USERID_LENGTH=10;
    public static final int MIN_PASSWORD_LENGTH=6;
    public static final int MAX_PASSWORD_LENGTH=10;


    @NotNull(message = "userid is required")
    @Size(min = MIN_USERID_LENGTH,max = MAX_USERID_LENGTH,message ="userid must have at least "+MIN_USERID_LENGTH+" characters and max "+MAX_USERID_LENGTH+" characters" )
    String userId;

    @NotNull(message = "password is required")
    @Size(min = MIN_PASSWORD_LENGTH,max = MAX_PASSWORD_LENGTH,message ="password must have at least "+MIN_PASSWORD_LENGTH+" characters and max "+MAX_PASSWORD_LENGTH+" characters" )
    String password;
}
