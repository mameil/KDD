package me.kdshim.kdd_j.LinkTest;

import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class Link extends MyMockMvc {

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
    }
}
