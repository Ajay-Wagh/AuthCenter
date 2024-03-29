package com.ajaywagh.authcenter.datarepositories;

import com.ajaywagh.authcenter.datamodels.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant,Integer> {
}
