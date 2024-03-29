package com.ajaywagh.authcenter.requestmodels.admin;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ajaywagh.authcenter.requestmodels.admin.AddAppRequest.MAX_APP_ID_LENGTH;
import static com.ajaywagh.authcenter.requestmodels.admin.AddAppRequest.MIN_APP_ID_LENGTH;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RemoveAppRequest extends AdminRequest{

    @NotNull(message = "appId is required")
    @Size(min = MIN_APP_ID_LENGTH,max = MAX_APP_ID_LENGTH,message ="appId must have at least "+MIN_APP_ID_LENGTH+" characters and max "+MAX_APP_ID_LENGTH+" characters" )
    String appId;
}
