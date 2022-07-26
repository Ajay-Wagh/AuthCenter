package com.ajaywagh.authcenter.repositories;

import com.ajaywagh.authcenter.POJO.UserChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChannelRepository extends JpaRepository<UserChannel,Integer> {
}
