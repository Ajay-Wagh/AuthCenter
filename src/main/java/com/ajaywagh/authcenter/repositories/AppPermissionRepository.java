package com.ajaywagh.authcenter.repositories;

import com.ajaywagh.authcenter.POJO.AppPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppPermissionRepository  extends JpaRepository<AppPermission, Integer> {
}
