package com.ajaywagh.authcenter.datarepositories;

import com.ajaywagh.authcenter.datamodels.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<App,String> {
}
