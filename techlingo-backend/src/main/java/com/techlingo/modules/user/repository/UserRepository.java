package com.techlingo.modules.user.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.techlingo.modules.user.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
