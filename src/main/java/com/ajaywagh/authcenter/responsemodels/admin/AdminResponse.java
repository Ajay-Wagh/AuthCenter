package com.ajaywagh.authcenter.responsemodels.admin;

import com.ajaywagh.authcenter.responsemodels.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class AdminResponse extends Response {
    String token;

    List<String> list;
}
