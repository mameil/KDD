package me.kdshim.kdd_j.config;

import me.kdshim.kdd_j.link.LinkRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@RunWith(SpringRunner.class)
//@ExtendWith(BaseExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MyMockMvc extends BaseSupport{
    @Autowired
    public MockMvc mvc;

    @Autowired
    LinkRepository linkRepository;

    @AfterEach
    public void clearing(){
        linkRepository.deleteAll();
    }

    public void postSinlgeLink() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/link")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"category\": \"WORK\",\n" +
                                "  \"memo\": \"test memo1\",\n" +
                                "  \"name\": \"테스트 이름이용\",\n" +
                                "  \"url\": \"localhost:1234\"\n" +
                                "}")
                )
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}
