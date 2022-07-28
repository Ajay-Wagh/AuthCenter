package com.ajaywagh.authcenter.requestmodels.admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.ajaywagh.authcenter.requestmodels.admin.AddUserChannel.MAX_USER_CHANNEL_LENGTH;
import static com.ajaywagh.authcenter.requestmodels.admin.AddUserChannel.MIN_USER_CHANNEL_LENGTH;

public class RemoveUserChannel {
    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "userChannel is mandatory")
    @Size(min = MIN_USER_CHANNEL_LENGTH,max = MAX_USER_CHANNEL_LENGTH,message ="userChannel must have at least "+ MIN_USER_CHANNEL_LENGTH +" characters and max "+ MAX_USER_CHANNEL_LENGTH +" characters" )
    String userChannel;
}
