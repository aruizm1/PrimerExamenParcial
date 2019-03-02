package com.singular.blogapi.blogapi.service;

import com.singular.blogapi.blogapi.domain.Post;
import com.singular.blogapi.blogapi.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Post> findAllPost(){
        return repository.findAll();
    }

    @Transactional
    public void savePost(Post post){
        repository.saveAndFlush(post);
    }

    @Transactional
    public void updatePost(Post post){
        Optional<Post> opost = repository.findById(post.getId());
        Post tempPost = opost.get();
        post.setId(tempPost.getId());
        repository.saveAndFlush(post);
    }
}
