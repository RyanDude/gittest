package com.example.test.Repository;

import com.example.test.domain.Cat;
import org.springframework.stereotype.Service;

@Service
public class HelloRepository {
    public Cat getCat(int id){
        Cat a = new Cat();
        a.setId(1);
        a.setName("cat");
        return a;
    }
}
