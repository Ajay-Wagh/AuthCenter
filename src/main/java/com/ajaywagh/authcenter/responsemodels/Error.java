package com.ajaywagh.authcenter.responsemodels;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Error {
    @NotNull
    ErrorCode errorCode;

    String message;
}
