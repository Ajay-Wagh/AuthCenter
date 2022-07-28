package com.ajaywagh.authcenter.requestmodels.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddUserChannelRequest {
    public static final int MIN_USER_CHANNEL_LENGTH =2;
    public static final int MAX_USER_CHANNEL_LENGTH =10;

    @Valid
    @NotNull(message = "Header is mandatory")
    Head head;

    @NotNull(message = "userChannel is required")
    @Size(min = MIN_USER_CHANNEL_LENGTH,max = MAX_USER_CHANNEL_LENGTH,message ="userChannel must have at least "+ MIN_USER_CHANNEL_LENGTH +" characters and max "+ MAX_USER_CHANNEL_LENGTH +" characters" )
    String userChannel;
}
