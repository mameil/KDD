package me.kdshim.kdd_j.utils;

import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.ContentType;
import lombok.SneakyThrows;
import me.kdshim.kdd_j.config.KDTest;
import me.kdshim.kdd_j.config.MyMockMvc;
import me.kdshim.kdd_j.swagger.model.StringDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

public class jsonParserTest extends MyMockMvc {

    @KDTest
    @SneakyThrows
    public void jsonParser(){
        ObjectMapper mapper = new ObjectMapper();

        String lomboks = "Link(url=localhost, category=JAVA, name=test link, memo=this is test only link)";
        StringDto req = new StringDto();
        req.setPlainString(lomboks);

        mvc.perform(MockMvcRequestBuilders.post("/utils/jsonify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(req))
                )
                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.StringDto").value(""))
                ;
    }

}
