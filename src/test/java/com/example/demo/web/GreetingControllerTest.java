package com.example.demo.web;

import com.example.demo.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    MockMvc mvc;

    @MockitoBean
    GreetingService greetingService;

    @Test
    void greet_ok() throws Exception {
        BDDMockito.given(greetingService.greet("amwtke")).willReturn("Hello, amwtke!");

        mvc.perform(get("/api/greet").param("name", "amwtke"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, amwtke!"));
    }
}
