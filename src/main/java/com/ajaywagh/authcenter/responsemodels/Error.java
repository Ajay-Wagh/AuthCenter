package com.ajaywagh.authcenter.responsemodels;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Error {
    @NotNull
    ErrorCode errorCode;

    String message;
}
