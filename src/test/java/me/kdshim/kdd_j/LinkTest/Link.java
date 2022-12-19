package me.kdshim.kdd_j.LinkTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kdshim.kdd_j.common.KDDError;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import me.kdshim.kdd_j.link.LinkService;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

public class Link extends MyMockMvc {

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    LinkService linkService;

    @KDTest
    void linkPostGet() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/link")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"category\": \"JAVA\",\n" +
                                "  \"memo\": \"this is test only link\",\n" +
                                "  \"name\": \"test link\",\n" +
                                "  \"url\": \"localhost\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category").value("JAVA"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.memo").value("this is test only link"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("test link"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url").value("localhost"))
        ;

        mvc.perform(MockMvcRequestBuilders.get("/links"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].category").value("JAVA"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].memo").value("this is test only link"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("test link"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].url").value("localhost"))
        ;

        String response = mvc.perform(MockMvcRequestBuilders.get("/link/localhost"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn().getResponse().getContentAsString();
        System.out.println(response);
        GetLinkDto link = objectMapper.readValue(response, GetLinkDto.class);
        System.out.println(link);

        assertThat(link.getName())
                .isEqualTo("test link")

        ;
    }

    @KDTest
    void get_ListLink_test() throws Exception{
        postSinlgeLink();

        mvc.perform(MockMvcRequestBuilders.post("/link")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"category\": \"WORK\",\n" +
                                "  \"memo\": \"test memo2\",\n" +
                                "  \"name\": \"테스트 이름2\",\n" +
                                "  \"url\": \"0123:localhost\"\n" +
                                "}")
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url").value("0123:localhost"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("테스트 이름2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.memo").value("test memo2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category").value("WORK"))
        ;

        mvc.perform(MockMvcRequestBuilders.get("/link/find/localhost"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='테스트 이름2')].category").value("WORK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='테스트 이름2')].memo").value("test memo2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='테스트 이름2')].url").value("0123:localhost"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='테스트 이름이용')].category").value("WORK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='테스트 이름이용')].memo").value("test memo1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='테스트 이름이용')].url").value("localhost:1234"))
        ;
    }

    @KDTest
    void SingleLink_get_exception_test() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/link")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"category\": \"WORK\",\n" +
                        "  \"memo\": \"test memo1\",\n" +
                        "  \"name\": \"테스트 이름이용\",\n" +
                        "  \"url\": \"1.2.3.4\"\n" +
                        "}")
        )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url").value("1.2.3.4"))
        ;

        mvc.perform(MockMvcRequestBuilders.get("/link/2"))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(KDDError.LINK_NOT_FOUND.getCode()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(KDDError.LINK_NOT_FOUND.getMsg()))
        ;
    }

    @KDTest
    void listLink_post_response_check_test() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/links")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        "[\n" +
                                "    {\n" +
                                "      \"category\": \"JAVA\",\n" +
                                "      \"memo\": \"실제 예시를 통한 비교 해둔 글\",\n" +
                        "      \"name\": \"Java Stream API는 왜 for-loop보다 느릴까?\",\n" +
                        "      \"url\": \"https://jypthemiracle.medium.com/java-stream-api는-왜-for-loop보다-느릴까-50dec4b9974b\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"category\": \"KOTLIN\",\n" +
                        "      \"memo\": \"ddd\",\n" +
                        "      \"name\": \"qqq\",\n" +
                        "      \"url\": \"qwer\"\n" +
                        "    }\n" +
                                "  ]\n"
                )
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='Java Stream API는 왜 for-loop보다 느릴까?')].category").value("JAVA"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='Java Stream API는 왜 for-loop보다 느릴까?')].memo").value("실제 예시를 통한 비교 해둔 글"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='Java Stream API는 왜 for-loop보다 느릴까?')].url").value("https://jypthemiracle.medium.com/java-stream-api는-왜-for-loop보다-느릴까-50dec4b9974b"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='qqq')].category").value("KOTLIN"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='qqq')].memo").value("ddd"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[?(@.name=='qqq')].url").value("qwer"))
                ;

    }

    @KDTest
    public void queryDslSimpleTest(){
        linkService.getQLink();
    }

}
