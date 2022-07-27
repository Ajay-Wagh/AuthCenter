package com.ajaywagh.authcenter.datarepositories;

import com.ajaywagh.authcenter.datamodels.AppPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppPermissionRepository  extends JpaRepository<AppPermission, Integer> {
}
