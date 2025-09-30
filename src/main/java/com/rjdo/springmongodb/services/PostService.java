package com.rjdo.springmongodb.services;

import com.rjdo.springmongodb.entities.Post;
import com.rjdo.springmongodb.repositories.PostRepository;
import com.rjdo.springmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(id));

    }

}
