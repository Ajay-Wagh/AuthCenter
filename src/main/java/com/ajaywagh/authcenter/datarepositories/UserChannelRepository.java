package com.ajaywagh.authcenter.datarepositories;

import com.ajaywagh.authcenter.datamodels.UserChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChannelRepository extends JpaRepository<UserChannel,Integer> {
}
