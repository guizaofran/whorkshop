package com.mongo.whorkshop.repository;

import com.mongo.whorkshop.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
