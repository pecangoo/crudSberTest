package com.testsber.sber;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

//@WebMvcTest(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SberApplicationTests {


    //  @Autowired
    //private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        String requestBody = "{name: fieldValue}";

//        mockMvc.perform(MockMvcRequestBuilders.post("/save")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Expected response body")); // Замените на ожидаемое тело ответа

    }

}
