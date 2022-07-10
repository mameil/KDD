package me.kdshim.kdd_j.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.kdshim.kdd_j.link.LinkRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
public class MyMockMvc extends BaseSupport{
    @Autowired
    public MockMvc mvc;

    @Autowired
    LinkRepository linkRepository;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void testSetting(){
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @AfterEach
    public void clearing(){
        linkRepository.deleteAll();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
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
