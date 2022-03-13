package com.bear.boot.restful.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-03-13 19:24
 **/
@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ArticleControllerTest {
    //注入mock对象
    @Resource
    private MockMvc mockMvc;

    /*
    在所有测试⽅法执⾏之前进⾏mock对象初始化
    @BeforeAll
    static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new
                ArticleController()).build();
    }
    */

    //测试⽅法
    @Test
    public void saveArticle() throws Exception {
        String article = """
                               {
                                    "id": 1,
                "author": "radical",
                "title": "SpringBoot",
                "content": "SpringBoot",
                "createTime": "2022-03-12 12:12:12",
                "readerList":[{"name":"aaa","age":18},
                {"name":"bbb","age":20}]
                               }""";
        MvcResult result = mockMvc.perform(
                        MockMvcRequestBuilders
                                .request(HttpMethod.POST,
                                        "/api/v1/articles/body")
                                .contentType("application/json")
                                .content(article)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                //HTTP:status 200

                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("radical"))

                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readerList[0].age").value(18))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }
}