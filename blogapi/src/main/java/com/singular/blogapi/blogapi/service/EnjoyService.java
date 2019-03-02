package com.singular.blogapi.blogapi.service;

import com.singular.blogapi.blogapi.domain.Enjoy;
import com.singular.blogapi.blogapi.repository.EnjoyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EnjoyService {
    private final EnjoyRepository repository;

    public EnjoyService(EnjoyRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Optional<Enjoy> findEnjoyById(Long id){return  repository.findById(id);}

    @Transactional(readOnly = true)
    public List<Enjoy> findAllEnjoy(){
        return repository.findAll();
    }

    @Transactional
    public void saveEnjoy(Enjoy enjoy){
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
