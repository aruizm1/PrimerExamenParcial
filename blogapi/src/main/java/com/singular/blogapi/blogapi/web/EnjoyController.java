package com.singular.blogapi.blogapi.web;

import com.singular.blogapi.blogapi.domain.Enjoy;
import com.singular.blogapi.blogapi.service.EnjoyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EnjoyController {
    private final EnjoyService service;

    public EnjoyController(EnjoyService service) {this.service = service; }

    @GetMapping("/likeById/{id}")
    public Optional<Enjoy> enjoyById(@PathVariable(value = "id")Long id){
        return service.findEnjoyById(id);
    }

    @GetMapping("/all-like")
    public List<Enjoy> allEnjoy() {
        return service.findAllEnjoy();
    }

    @PostMapping("/register-like")
    public ResponseEntity<Enjoy> registerEnjoy(@RequestBody Enjoy enjoy) {
        service.saveEnjoy(enjoy);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-like")
    public ResponseEntity<String> updateEnjoy(@RequestBody Enjoy enjoy) {
        service.updateEnjoy(enjoy);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
