package com.mongo.whorkshop.resources;

import com.mongo.whorkshop.domain.Post;
import com.mongo.whorkshop.domain.User;
import com.mongo.whorkshop.dto.UserDTO;
import com.mongo.whorkshop.resources.util.URL;
import com.mongo.whorkshop.service.PostServices;
import com.mongo.whorkshop.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostServices postServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findAll(@PathVariable String id) {
        Post obj = postServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = postServices.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
