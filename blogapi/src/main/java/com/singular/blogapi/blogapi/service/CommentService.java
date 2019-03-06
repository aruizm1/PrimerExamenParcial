package com.singular.blogapi.blogapi.service;

import com.singular.blogapi.blogapi.domain.Comment;
import com.singular.blogapi.blogapi.domain.User;
import com.singular.blogapi.blogapi.repository.CommentRepository;
import com.singular.blogapi.blogapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentService {
    private final CommentRepository repository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Comment> findCommentById(Long id){return  repository.findById(id);}

    @Transactional(readOnly = true)
    public List<Comment> findAllComment(){
        return repository.findAll();
    }

    @Transactional
    public void saveComment(Comment comment){
        User user = comment.getUser();
        userRepository.saveAndFlush(user);
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
