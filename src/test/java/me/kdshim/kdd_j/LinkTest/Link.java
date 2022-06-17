package me.kdshim.kdd_j.LinkTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

public class Link extends MyMockMvc {

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    ObjectMapper objectMapper;

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
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.category").value("JAVA"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.memo").value("this is test only link"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("test link"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url").value("localhost"))
        ;

        mvc.perform(MockMvcRequestBuilders.get("/links"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].category").value("JAVA"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].memo").value("this is test only link"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("test link"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].url").value("localhost"))
        ;

        String response = mvc.perform(MockMvcRequestBuilders.get("/link/1"))
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
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
        ;

        mvc.perform(MockMvcRequestBuilders.get("/link/2"))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andDo(MockMvcResultHandlers.print())
        ;
        //CoreException extends RuntimeException -> coreExcepionData - returnCode, returnMessage, HttpStatus
    }

}
