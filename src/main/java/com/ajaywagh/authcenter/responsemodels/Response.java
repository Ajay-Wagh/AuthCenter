package com.ajaywagh.authcenter.responsemodels;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Response {

    @NotNull
    Success success;

    @NotNull
    Error error;
}
