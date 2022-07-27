package com.ajaywagh.authcenter.datarepositories;

import com.ajaywagh.authcenter.datamodels.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
}
