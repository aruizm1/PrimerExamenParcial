package com.singular.blogapi.blogapi.web;

import com.singular.blogapi.blogapi.domain.Post;
import com.singular.blogapi.blogapi.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {this.service = service; }


    @GetMapping("/all-post")
    public List<Post> allPost() {
        return service.findAllPost();
    }

    @PostMapping("/register-post")
    public ResponseEntity<Post> registerPost(@RequestBody Post post) {
        service.savePost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-post")
    public ResponseEntity<String> updatePost(@RequestBody Post post) {
        service.updatePost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
