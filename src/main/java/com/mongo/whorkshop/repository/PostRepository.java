package com.mongo.whorkshop.repository;

import com.mongo.whorkshop.domain.Post;
import com.mongo.whorkshop.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}
