package com.ajaywagh.authcenter.requestmodels.admin;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class AddUserChannelRequest extends AdminRequest{
    public static final int MIN_USER_CHANNEL_LENGTH =2;
    public static final int MAX_USER_CHANNEL_LENGTH =10;

    @NotNull(message = "userChannel is required")
    @Size(min = MIN_USER_CHANNEL_LENGTH,max = MAX_USER_CHANNEL_LENGTH,message ="userChannel must have at least "+ MIN_USER_CHANNEL_LENGTH +" characters and max "+ MAX_USER_CHANNEL_LENGTH +" characters" )
    String userChannel;
}
