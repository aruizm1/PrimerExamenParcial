package com.singular.blogapi.blogapi.web;

import com.singular.blogapi.blogapi.domain.Tag;
import com.singular.blogapi.blogapi.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {
    private final TagService service;

    public TagController(TagService service) {this.service = service; }


    @GetMapping("/all-tag")
    public List<Tag> allTag() {
        return service.findAllTag();
    }

    @PostMapping("/register-tag")
    public ResponseEntity<Tag> registerTag(@RequestBody Tag tag) {
        service.saveTag(tag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-tag")
    public ResponseEntity<String> updateTag(@RequestBody Tag tag) {
        service.updateTag(tag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
