package com.ajaywagh.authcenter.services.securityservices;
import com.ajaywagh.authcenter.requestmodels.admin.AdminRequest;
import javax.validation.constraints.NotNull;

public interface VerifyAdminService {
    void verifyAdmin(@NotNull AdminRequest adminRequest);
}
