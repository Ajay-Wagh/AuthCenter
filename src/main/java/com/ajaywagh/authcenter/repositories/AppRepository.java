package com.ajaywagh.authcenter.repositories;

import com.ajaywagh.authcenter.POJO.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<App,String> {
}
