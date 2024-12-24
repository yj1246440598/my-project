package com.enjoy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.io.File;
import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MvcTest {
    @Autowired
    MockMvc mvc;

    @Test
    void testExample() throws Exception {
        mvc.perform(get("/course/a"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
        ;
    }

    @Test
    void testFile() throws Exception {
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", new FileInputStream(new File("D:\\1.png")));
        mvc.perform(multipart("/images/upload")
                .file(mockMultipartFile))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andDo(new MyResultHandler())
        ;
    }

    static class MyResultHandler implements ResultHandler {

        @Override
        public void handle(MvcResult result) throws Exception {
            System.out.println("myself handle result======================");
            System.out.println(result.getResponse().getIncludedUrls());
        }
    }
}
