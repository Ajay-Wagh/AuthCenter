package com.ajaywagh.authcenter.datarepositories;

import com.ajaywagh.authcenter.datamodels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
