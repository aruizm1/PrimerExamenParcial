package com.singular.blogapi.blogapi.web;

import com.singular.blogapi.blogapi.domain.Comment;
import com.singular.blogapi.blogapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService service;

    public CommentController(CommentService service) {this.service = service; }

    @GetMapping("/commentById/{id}")
    public Optional<Comment> commnetById(@PathVariable(value = "id")Long id){
        return service.findCommentById(id);
    }

    @GetMapping("/all-comment")
    public List<Comment> allComment() {
        return service.findAllComment();
    }

    @PostMapping("/register-comment")
    public ResponseEntity<Comment> registerComment(@RequestBody Comment comment) {
        service.saveComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-comment")
    public ResponseEntity<String> updateComment(@RequestBody Comment comment) {
        service.updateComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
