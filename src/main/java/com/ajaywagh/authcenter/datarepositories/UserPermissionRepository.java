package com.ajaywagh.authcenter.datarepositories;

import com.ajaywagh.authcenter.datamodels.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission,Integer> {
}
