package com.ajaywagh.authcenter.responsemodels.admin;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminResponse {

    @NotNull
    Success success;

    String token;

    List<Object> list;

}
