package com.singular.blogapi.blogapi.service;

import com.singular.blogapi.blogapi.domain.Tag;
import com.singular.blogapi.blogapi.domain.User;
import com.singular.blogapi.blogapi.repository.TagRepository;
import com.singular.blogapi.blogapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
public class UserService {
    private final UserRepository repository;
    private final TagRepository tagRepository;


    public UserService(UserRepository repository, TagRepository tagRepository) {

        this.repository = repository;
        this.tagRepository = tagRepository;
    }



    @Transactional(readOnly = true)
    public List<User> findAllUser(){
        return repository.findAll();
    }

    @Transactional
    public void saveUser(User user){
        Set<Tag> tags =  user.getTags();

        for (Tag item: tags) {

            tagRepository.saveAndFlush(item);
        }
        repository.saveAndFlush(user);
    }

    @Transactional
    public void updateUser(User user){
        Optional<User> ouser = repository.findById(user.getId());
        User tempUser = ouser.get();
        user.setId(tempUser.getId());
        repository.saveAndFlush(user);
    }

}
