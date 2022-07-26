package com.ajaywagh.authcenter.repositories;

import com.ajaywagh.authcenter.POJO.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermission,Integer> {
}
