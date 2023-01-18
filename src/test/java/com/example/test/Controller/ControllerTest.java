package com.example.test.Controller;

import com.example.test.Repository.HelloRepository;
import com.example.test.domain.Cat;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HelloRepository helloRepository;
    @Test
    public void hi_test()throws Exception{
        when(helloRepository.getCat(1)).thenReturn(new Cat("cat",1));
        MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/hi?id=1")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();
        Cat cat = new Gson().fromJson(result.getResponse().getContentAsString(), Cat.class);
        System.err.println("ret is "+cat.toString());
        Assertions.assertEquals(cat.getId(), 1);
    }
}
