package me.kdshim.kdd_j.link;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyTest;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest
public class LinkapiTest extends MyTest{
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @KDTest
    void post_test() throws Exception {
        PostLinkDto linkDto = new PostLinkDto();
        linkDto.setCategory(PostLinkDto.CategoryEnum.FOOD);
        linkDto.setMemo("테스트 코드에서 만들어본 테스트용 객체");
        linkDto.setName("아무튼 테스트 객체");
        linkDto.setUrl("htttttttttttttps");

        //////////////////////////////////////////////////
        //desc 하나를 저장해보자 -> 예상되는걸로는 실제 DB에 저장될듯?
        //////////////////////////////////////////////////
        mvc.perform(MockMvcRequestBuilders.post("/links")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(linkDto))
        )
                .andExpect(MockMvcResultMatchers.status().is(200));

        mvc.perform(MockMvcRequestBuilders.get("/links"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print());
    }
}
