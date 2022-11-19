package me.kdshim.kdd_j.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kdshim.kdd_j.common.KDDError;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.startsWith;

public class Commit extends MyMockMvc {

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    ObjectMapper objectMapper;

    @KDTest
    public void getKyu9Commits() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/github/kyu9/library/commits"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.commitList[0].author").value("kyu9"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.commitList[0].commitYYYYMMDD").value(("2022-11-19")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.commitList[0].commitMsg").value(("Create blank.yml")))
                ;


    }

}
