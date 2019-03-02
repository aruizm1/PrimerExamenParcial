package com.singular.blogapi.blogapi.service;

import com.singular.blogapi.blogapi.domain.Tag;
import com.singular.blogapi.blogapi.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TagService {
    private final TagRepository repository;


    public TagService(TagRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Tag> findAllTag(){
        return repository.findAll();
    }

    @Transactional
    public void saveTag(Tag tag){
        repository.saveAndFlush(tag);
    }

    @Transactional
    public void updateTag(Tag tag){
        Optional<Tag> otag = repository.findById(tag.getId());
        Tag tempTag = otag.get();
        tag.setId(tempTag.getId());
        repository.saveAndFlush(tag);
    }
}
