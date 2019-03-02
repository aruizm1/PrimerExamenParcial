package com.singular.blogapi.blogapi.service;

import com.singular.blogapi.blogapi.domain.Comment;
import com.singular.blogapi.blogapi.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentService {
    private final CommentRepository repository;

    public CommentService(CommentRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Optional<Comment> findCommentById(Long id){return  repository.findById(id);}

    @Transactional(readOnly = true)
    public List<Comment> findAllComment(){
        return repository.findAll();
    }

    @Transactional
    public void saveComment(Comment comment){
        repository.saveAndFlush(comment);
    }

    @Transactional
    public void updateComment(Comment comment){
        Optional<Comment> ocomment = repository.findById(comment.getId());
        Comment tempComment = ocomment.get();
        comment.setId(tempComment.getId());
        repository.saveAndFlush(comment);
    }
}
