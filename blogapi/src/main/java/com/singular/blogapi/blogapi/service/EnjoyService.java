package com.singular.blogapi.blogapi.service;

import com.singular.blogapi.blogapi.domain.Enjoy;
import com.singular.blogapi.blogapi.domain.User;
import com.singular.blogapi.blogapi.repository.EnjoyRepository;
import com.singular.blogapi.blogapi.repository.TagRepository;
import com.singular.blogapi.blogapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class EnjoyService {
    private final EnjoyRepository repository;
    private final UserRepository userRepository;

    public EnjoyService(EnjoyRepository repository,
                        UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Enjoy> findEnjoyById(Long id){return  repository.findById(id);}

    @Transactional(readOnly = true)
    public List<Enjoy> findAllEnjoy(){
        return repository.findAll();
    }

    @Transactional
    public void saveEnjoy(Enjoy enjoy){
        Set<User> users = enjoy.getUsers();
        for (User item:users
             ) {
            userRepository.saveAndFlush(item);
        }
        repository.saveAndFlush(enjoy);
    }

    @Transactional
    public void updateEnjoy(Enjoy enjoy){
        Optional<Enjoy> oenjoy = repository.findById(enjoy.getId());
        Enjoy tempEnjoy = oenjoy.get();
        enjoy.setId(tempEnjoy.getId());
        repository.saveAndFlush(enjoy);
    }
}
