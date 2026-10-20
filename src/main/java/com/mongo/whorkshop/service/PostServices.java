package com.mongo.whorkshop.service;

import com.mongo.whorkshop.domain.Post;
import com.mongo.whorkshop.domain.User;
import com.mongo.whorkshop.dto.UserDTO;
import com.mongo.whorkshop.exception.ObjectNotFoundException;
import com.mongo.whorkshop.repository.PostRepository;
import com.mongo.whorkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServices {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
      Post user = postRepository.findById(id).orElse(null);
       if(user== null){
           throw new ObjectNotFoundException("Objeto não encontrado");
       }
       return user;
    }
}
