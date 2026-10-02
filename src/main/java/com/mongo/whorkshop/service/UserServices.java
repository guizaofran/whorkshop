package com.mongo.whorkshop.service;

import com.mongo.whorkshop.domain.User;
import com.mongo.whorkshop.dto.UserDTO;
import com.mongo.whorkshop.exception.ObjectNotFoundException;
import com.mongo.whorkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
       User user = userRepository.findById(id).orElse(null);
       if(user== null){
           throw new ObjectNotFoundException("Objeto não encontrado");
       }
       return user;
    }

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
