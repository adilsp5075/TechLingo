package com.techlingo.modules.user.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.techlingo.modules.user.entity.UserStats;

public interface UserStatsRepository  extends MongoRepository<UserStats, String> {

    Optional<UserStats> findByUserId(String userId);
    List<UserStats> findTop10ByOrderByXpDesc();
}
