package com.rjdo.springmongodb.repositories;

import com.rjdo.springmongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
}
