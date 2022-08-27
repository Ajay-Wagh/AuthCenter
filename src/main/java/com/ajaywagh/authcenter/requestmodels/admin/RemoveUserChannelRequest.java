package com.ajaywagh.authcenter.requestmodels.admin;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ajaywagh.authcenter.requestmodels.admin.AddUserChannelRequest.MAX_USER_CHANNEL_LENGTH;
import static com.ajaywagh.authcenter.requestmodels.admin.AddUserChannelRequest.MIN_USER_CHANNEL_LENGTH;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RemoveUserChannelRequest extends AdminRequest{

    @NotNull(message = "userChannel is mandatory")
    @Size(min = MIN_USER_CHANNEL_LENGTH,max = MAX_USER_CHANNEL_LENGTH,message ="userChannel must have at least "+ MIN_USER_CHANNEL_LENGTH +" characters and max "+ MAX_USER_CHANNEL_LENGTH +" characters" )
    String userChannel;
}
