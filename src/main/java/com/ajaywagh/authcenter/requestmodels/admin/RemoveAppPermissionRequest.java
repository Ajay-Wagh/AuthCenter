package com.ajaywagh.authcenter.requestmodels.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ajaywagh.authcenter.requestmodels.admin.AddAppPermissionRequest.MAX_APP_PERMISSION_LENGTH;
import static com.ajaywagh.authcenter.requestmodels.admin.AddAppPermissionRequest.MIN_APP_PERMISSION_LENGTH;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RemoveAppPermissionRequest {
    @Valid
    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "permission is mandatory")
    @Size(min = MIN_APP_PERMISSION_LENGTH,max = MAX_APP_PERMISSION_LENGTH,message ="permission must have at least "+MIN_APP_PERMISSION_LENGTH+" characters and max "+MAX_APP_PERMISSION_LENGTH+" characters" )
    String permission;
}
