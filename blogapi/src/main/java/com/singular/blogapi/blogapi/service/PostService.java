package com.singular.blogapi.blogapi.service;

import com.singular.blogapi.blogapi.domain.Comment;
import com.singular.blogapi.blogapi.domain.Post;
import com.singular.blogapi.blogapi.domain.Tag;
import com.singular.blogapi.blogapi.domain.User;
import com.singular.blogapi.blogapi.repository.CommentRepository;
import com.singular.blogapi.blogapi.repository.PostRepository;
import com.singular.blogapi.blogapi.repository.TagRepository;
import com.singular.blogapi.blogapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PostService {
    private final PostRepository repository;
    private final TagRepository tagRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository repository,
                       TagRepository tagRepository,
                       CommentRepository commentRepository,
                       UserRepository userRepository){
        this.repository = repository;
        this.tagRepository = tagRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<Post> findAllPost(){
        return repository.findAll();
    }

    @Transactional
    public void savePost(Post post){
        Set<Tag> tags = post.getTagsPost();
        Set<Comment> comments = post.getComments();
        User author = post.getUser();

        for (Tag item:tags
             ) {
            tagRepository.saveAndFlush(item);
        }

        for (Comment item:comments
             ) {
            commentRepository.saveAndFlush(item);
        }

        userRepository.saveAndFlush(author);
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
