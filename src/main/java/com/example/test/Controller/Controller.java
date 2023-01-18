package com.example.test.Controller;

import com.example.test.Repository.HelloRepository;
import com.example.test.domain.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final HelloRepository helloRepository;
    @Autowired
    public Controller(HelloRepository helloRepository){
        this.helloRepository = helloRepository;
    }
    @RequestMapping("/hi")
    public ResponseEntity<Cat> hi(@RequestParam("id")int id){
        return ResponseEntity.ok(this.helloRepository.getCat(id));
    }
}
