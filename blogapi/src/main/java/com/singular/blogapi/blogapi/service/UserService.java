package com.singular.blogapi.blogapi.service;

import com.singular.blogapi.blogapi.domain.User;
import com.singular.blogapi.blogapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;


    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<User> findAllUser(){
        return repository.findAll();
    }

    @Transactional
    public void saveUser(User user){
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
