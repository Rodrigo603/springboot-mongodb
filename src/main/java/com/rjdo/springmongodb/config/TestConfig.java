package com.rjdo.springmongodb.config;

import com.rjdo.springmongodb.dto.AuthorDTO;
import com.rjdo.springmongodb.entities.Post;
import com.rjdo.springmongodb.entities.User;
import com.rjdo.springmongodb.repositories.PostRepository;
import com.rjdo.springmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration

public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null,sdf.parse("11/11/2011"),"Partiu viagem","Indo para Sergipe",new AuthorDTO(alex));
        Post post2 = new Post(null,sdf.parse("15/08/2005"),"Basquete","Ganhei um x1 ",new AuthorDTO(alex));

        postRepository.saveAll(Arrays.asList(post1,post2));

        alex.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(alex);

    }
}
